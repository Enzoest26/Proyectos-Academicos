package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Carrera;
import entidad.Sede;
import interfaces.SedeInterfazDAO;
import utils.MySQLConexion8;

public class GestionSedeDAO implements SedeInterfazDAO{

	@Override
	public ArrayList<Sede> listarSede() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Sede> listarSedes = new ArrayList<>();
		ResultSet res = null;
		Sede sede;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_sede";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				sede = new Sede();
				sede.setIdSede(res.getString(1));
				sede.setNombre(res.getString(2));
				listarSedes.add(sede);
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
		return listarSedes;
	}

	@Override
	public Sede buscarSede(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Sede sede = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_sede WHERE nombre_sede = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				sede = new Sede();
				sede.setIdSede(res.getString(1));
				sede.setNombre(res.getString(2));
				sede.setIdDistrito(res.getString(3));
				
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
		return sede;
	}

	@Override
	public Sede buscarNombre(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Sede sede = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_sede WHERE id_sede = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				sede = new Sede();
				sede.setIdSede(res.getString(1));
				sede.setNombre(res.getString(2));
				sede.setIdDistrito(res.getString(3));
				
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
		return sede;
	}
	
	
}
