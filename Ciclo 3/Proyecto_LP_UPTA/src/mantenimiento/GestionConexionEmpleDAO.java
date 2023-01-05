package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.ConexionEmple;

import interfaces.ConexionEmpleInterfazDAO;

import utils.MySQLConexion8;

public class GestionConexionEmpleDAO implements ConexionEmpleInterfazDAO {

	@Override
	public ArrayList<ConexionEmple> obtenerEmpleadoConectado() {
		ArrayList<ConexionEmple> obtenerEmConectados = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ConexionEmple coE;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_conexion_emple WHERE id_estado = 1";
			pstm = conn.prepareStatement(sql);
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				coE = new ConexionEmple();
				
				coE.setIdEmple(res.getString(1));
				coE.setIdEstado(res.getInt(2));
				
				obtenerEmConectados.add(coE);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null) pstm.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return obtenerEmConectados;
	}

}
