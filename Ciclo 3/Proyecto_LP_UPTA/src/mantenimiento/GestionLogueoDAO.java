package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Empleado;
import entidad.Logueo;
import interfaces.LogueoInterfazDAO;
import utils.MySQLConexion8;

public class GestionLogueoDAO implements LogueoInterfazDAO{

	@Override
	public Logueo verificarLogueo(String usu, String pass) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		
		Logueo logueo = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "{call proyecto_lp.usp_VerificarLogueo(?,?)}";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usu);
			pstm.setString(2, pass);
			
			
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				logueo = new Logueo();
				logueo.setIdCuenta(res.getString(1));
				logueo.setUsuario(res.getString(2));
				logueo.setPass(res.getString(3));
				logueo.setIdEmple(res.getString(4));
				
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
		return logueo;
	}

	@Override
	public int cambiarEstado(String idEmple,int estado) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "UPDATE tbl_conexion_emple SET id_estado = ? WHERE id_emple = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, estado);
			pstm.setString(2, idEmple);
			//Execute
			res = pstm.executeUpdate();
			
			
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
		return res;
	}
	
		
}
