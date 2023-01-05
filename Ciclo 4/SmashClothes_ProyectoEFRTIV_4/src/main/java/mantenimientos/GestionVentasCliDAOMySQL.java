package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentasClieInterfaces;
import entidad.CabeceraBoletaCli;
import entidad.DetalleBoletaCli;
import utils.MySQLConexion;

public class GestionVentasCliDAOMySQL implements VentasClieInterfaces{

	@Override
	public String generaNumBoleta() {
		String codigo = "B0001"; 
		
		// Plantilla
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(NUM_BOL),2) from tb_cab_boleta_cli";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				codigo = String.format("B%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraBoletaCli cab, ArrayList<DetalleBoletaCli> det) {
		int rs = 0;
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		try {
			con = MySQLConexion.getConexion();
			con.setAutoCommit(false);
			
			System.out.println(cab);
			cab.setNum_bol(generaNumBoleta());
			System.out.println(cab);
			
			String sql1 = "insert into tb_cab_boleta_cli values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);
			pst1.setString(1, generaNumBoleta());
			pst1.setInt(2, cab.getCod_cliente());
			rs = pst1.executeUpdate();

			String sql2 = "insert into tb_det_boleta_cli values (?,?,?,?)";
			String sql3 = "update tb_productos set stock_prod = stock_prod - ? where cod_prod = ?";
			for (DetalleBoletaCli d : det) {
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNum_bol());
				pst2.setString(2, d.getIdprod());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPreciovta());
				rs += pst2.executeUpdate();

				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getIdprod());

				rs += pst3.executeUpdate();
			}

			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar : " + e.getMessage());
			rs = 0;
			try {
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

}
