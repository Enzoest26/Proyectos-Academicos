package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidad.Horario;
import interfaces.HorarioInterfazDAO;
import utils.MySQLConexion8;

public class GestionHorarioDAO implements HorarioInterfazDAO {

	@Override
	public ArrayList<Horario> listarHorarios() {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Horario> listarHorarios = new ArrayList<>();
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_horario";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			//Hacer el listado
			while(res.next()) {
				Horario ho= new Horario();
				ho.setIdHorario(res.getString(1));
				ho.setTiempo(res.getString(2));
				
				listarHorarios.add(ho);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return listarHorarios;
	}

	@Override
	public Horario obtenerID(String hora) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Horario ho = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_horario where tiempo_horario = ?";
			pstm = conn.prepareStatement(sql);
			//Execute
			res = pstm.executeQuery();
			//Hacer el listado
			if(res.next()) {
				ho= new Horario();
				ho.setIdHorario(res.getString(1));
				ho.setTiempo(res.getString(2));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res!=null)res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return ho;
	}
	
		
}
