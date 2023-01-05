package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidad.Distrito;
import interfaces.DistritoInterfazDAO;
import utils.MySQLConexion8;

public class GestionDistritoDAO implements DistritoInterfazDAO{

	@Override
	public ArrayList<Distrito> listarDistritos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Distrito> listarDistritos = new ArrayList<>();
		ResultSet res = null;
		Distrito distrito;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_distrito";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				distrito = new Distrito();
				distrito.setIdDistrito(res.getString(1));
				distrito.setNombre(res.getString(2));
				listarDistritos.add(distrito);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null) res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return listarDistritos;
	}

	@Override
	public ArrayList<Distrito> buscarID(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ArrayList<Distrito> obtenerDistrito = new ArrayList<>();
		Distrito distrito;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM proyecto_lp.tbl_distrito WHERE nombre_distrito = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				distrito = new Distrito();
				distrito.setIdDistrito(res.getString(1));
				distrito.setNombre(res.getString(2));
				obtenerDistrito.add(distrito);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null) res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return obtenerDistrito;
	}

	@Override
	public Distrito buscarNombre(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		
		Distrito distrito = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM proyecto_lp.tbl_distrito WHERE id_distrito = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				distrito = new Distrito();
				distrito.setIdDistrito(res.getString(1));
				distrito.setNombre(res.getString(2));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null) res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return distrito;
	}
	
}
