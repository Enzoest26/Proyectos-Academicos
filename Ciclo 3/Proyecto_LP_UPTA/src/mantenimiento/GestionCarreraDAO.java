package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Carrera;

import interfaces.CarreraInterfazDAO;
import utils.MySQLConexion8;

public class GestionCarreraDAO implements CarreraInterfazDAO {

	@Override
	public ArrayList<Carrera> listarCarreras() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Carrera> listarCarreras = new ArrayList<>();
		ResultSet res = null;
		Carrera carrera;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_carreras";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				carrera = new Carrera();
				carrera.setIdCarrera(res.getString(1));
				carrera.setNombre(res.getString(2));
				carrera.setIdFacultad(res.getString(3));
				listarCarreras.add(carrera);
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
		return listarCarreras;
	}

	@Override
	public Carrera buscarCarrera(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Carrera carrera = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_carreras WHERE nombre_carrera = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				carrera = new Carrera();
				carrera.setIdCarrera(res.getString(1));
				carrera.setNombre(res.getString(2));
				carrera.setIdFacultad(res.getString(3));
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
		return carrera;
	}

	@Override
	public Carrera buscarNombre(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Carrera carrera = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_carreras WHERE id_carrera = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				carrera = new Carrera();
				carrera.setIdCarrera(res.getString(1));
				carrera.setNombre(res.getString(2));
				carrera.setIdFacultad(res.getString(3));
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
		return carrera;
	}
	
}
