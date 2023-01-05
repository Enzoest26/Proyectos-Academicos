package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entidad.Sede;
import entidad.TipoEmpleado;
import interfaces.InterfazTipoEmpleado;
import utils.MySQLConexion8;

public class GestionTipoEmpleadoDAO implements InterfazTipoEmpleado{

	@Override
	public TipoEmpleado obtenerTipo(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoEmpleado tipo = null; 
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tipo_empleado WHERE id_tipo= ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				tipo = new TipoEmpleado();
				tipo.setIdTipo(res.getString(1));
				tipo.setNombre(res.getString(2));
				
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
		return tipo;
	}

}
