package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.VentaCabezera;
import entidad.VentaDetalle;
import interfaces.VentaInterface;

import utils.MySQLConexion;

public class GestionVentaDAOMYSQL implements VentaInterface {

	@Override
	public int realizarVenta(VentaCabezera cabezera, ArrayList<VentaDetalle> detalle) {
		// TODO Auto-generated method stub
				int res = 0;
				//Plantilla de base de datos
				Connection conn = null;
				//PAra la venta_cabezera
				PreparedStatement pstm = null;
				//PAra la venta_detalle
				PreparedStatement pstm1 = null;
				//Para la para el stock el producto
				PreparedStatement pstm2 = null;
				
				
			
				try {
					conn = MySQLConexion.getConexion();
					// TODO Auto-generated method stub
					//Desactivar las transacciones
					conn.setAutoCommit(false);
				
					String sql = "insert into tb_boleta_cabezera values (?,?,?,?,?,?)";
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, cabezera.getNumBol());
					pstm.setString(2, cabezera.getTipoBol());
					pstm.setString(3, cabezera.getCodCli());
					pstm.setString(4, cabezera.getFecha());
					pstm.setString(5, cabezera.getPagadoBol());
					pstm.setDouble(6, cabezera.getPrecioTo());
					res = pstm.executeUpdate();
					//Parte del detalle

					for (VentaDetalle de : detalle) {
						//Agregar los detalles
						String sql1 = "insert into tb_boleta_detalle values (?,?,?,?)";
						pstm1 = conn.prepareStatement(sql1);
						pstm1.setString(1, de.getNumBol());
						pstm1.setString(2, de.getCodProd());
						pstm1.setString(3, de.getCantidad());
						pstm1.setDouble(4, de.getPrecioUni());
						res = pstm1.executeUpdate();
						//Para disminuir el stock de productos
						
						String sql2 = "update tb_productos set stock_prod = stock_prod - ? where cod_prod = ?";
						pstm2 = conn.prepareStatement(sql2);
						pstm2.setString(1, de.getCantidad());
						pstm2.setString(2, de.getCodProd());
						res = pstm2.executeUpdate();
						
					}
					
					conn.commit();
					
				} catch (Exception e) {
					try {
						conn.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						System.out.println("Error en el roll back - Ventas: " + e1.getMessage());
					}
					// TODO: handle exception
					System.out.println("Error en registrar - Transaccion: " + e.getMessage());
				}finally {
					MySQLConexion.closeConexion(conn);
				}
				return res;
			}

	@Override
	public String obtenerCod() {
		String codigo = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select MAX(substring(num_bol,3)) from tb_boleta_cabezera";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "BO" + df.format(Integer.parseInt(res.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}
	

}
