package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Empleado;
import interfaces.EmpleadoInterfazDAO;
import utils.MySQLConexion8;

public class GestionEmpleadoDAO implements EmpleadoInterfazDAO{

	@Override
	public Empleado buscarEmpleados(String idEmple) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Empleado em = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_empleados WHERE id_emple = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, idEmple);
			//Execute
			res = pstm.executeQuery();
			
			
			em = new Empleado();
			if(res.next()) {
				em.setIdEmple(res.getString(1));
				em.setNombre(res.getString(2));
				em.setApellido(res.getString(3));
				em.setDni(res.getString(4));
				em.setIdTipo(res.getString(5));
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
		return em;
		
	}

}
