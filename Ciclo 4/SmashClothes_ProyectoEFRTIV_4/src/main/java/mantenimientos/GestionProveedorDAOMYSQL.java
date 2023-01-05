package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Proveedor;
import interfaces.ProveedorInterface;
import utils.MySQLConexion;

public class GestionProveedorDAOMYSQL implements ProveedorInterface{

	@Override
	public Proveedor obtenerProv(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Proveedor prov = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_proveedor where cod_pro = ?" ;
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeQuery();
			
			if(res.next()) {
				prov = new Proveedor();
				prov.setCodProv(res.getString(1));
				prov.setReprese(res.getString(2));
				prov.setEmpresa(res.getString(3));
				prov.setRuc(res.getString(4));
				prov.setPais(res.getString(5));
				prov.setCorreo(res.getString(6));
				prov.setTele(res.getString(7));
				prov.setEstado(res.getInt(8));
				prov.setFotoRu(res.getString(9));
				prov.setFotoExte(res.getString(10));
				/*
				if((res.getBlob(9).getBinaryStream()) == null){
					p.setFoto(null);
				}else {
					p.setFoto(res.getBlob(9).getBinaryStream());
				}
				*/
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en encontrar el Proveedor: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return prov;
	}

	@Override
	public int registrar(Proveedor prov) {
		// TODO Auto-generated method stub
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert into tb_proveedor values (?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, prov.getCodProv());
			pstm.setString(2, prov.getReprese());
			pstm.setString(3, prov.getEmpresa());
			pstm.setString(4, prov.getRuc());
			pstm.setString(5, prov.getPais());
			pstm.setString(6, prov.getCorreo());
			pstm.setString(7, prov.getTele());
			pstm.setInt(8, prov.getEstado());
			pstm.setString(9, prov.getFotoRu());
			pstm.setString(10, prov.getFotoExte());
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar - Proveedor: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int editar(Proveedor prov) {
		// TODO Auto-generated method stub
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_proveedor set repre_pro = ?, empresa_pro = ?, ruc_pro= ?,pais_pro = ?,"
					+ " correo_pro= ?,tele_pro = ?,id_estado = ?, fotoRu_pro = ?, fotoExte_pro = ? where cod_pro = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, prov.getReprese());
			pstm.setString(2, prov.getEmpresa());
			pstm.setString(3, prov.getRuc());
			pstm.setString(4, prov.getPais());
			pstm.setString(5, prov.getCorreo());
			pstm.setString(6, prov.getTele());
			pstm.setInt(7, prov.getEstado());
			pstm.setString(8, prov.getFotoRu());
			pstm.setString(9, prov.getFotoExte());
			pstm.setString(10, prov.getCodProv());
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en editar - Proveedor: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int eliminar(String cod) {
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_proveedor set id_estado = 2 where cod_pro = ?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en eliminar - Proveedor: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public ArrayList<Proveedor> listarProveedor() {
		ArrayList<Proveedor> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_proveedor";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			Proveedor prov;
			while(res.next()) {
				prov = new Proveedor();
				prov.setCodProv(res.getString(1));
				prov.setReprese(res.getString(2));
				prov.setEmpresa(res.getString(3));
				prov.setRuc(res.getString(4));
				prov.setPais(res.getString(5));
				prov.setCorreo(res.getString(6));
				prov.setTele(res.getString(7));
				prov.setEstado(res.getInt(8));
				prov.setFotoRu(res.getString(9));
				prov.setFotoExte(res.getString(10));
				
				/*
				if((res.getBlob(9).getBinaryStream()) == null){
					p.setFoto(null);
				}else {
					p.setFoto(res.getBlob(9).getBinaryStream());
				}
				*/
				lista.add(prov);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

	@Override
	public String obtenerCod() {
		String codigo = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select MAX(substring(cod_pro,3)) from tb_proveedor";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "PO" + df.format(Integer.parseInt(res.getString(1)) + 1);
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
