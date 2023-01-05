package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Distrito;
import entidad.SolicitudDetalle;

import interfaces.SolicitudDetalleDAO;
import utils.MySQLConexion8;

public class GestionSolicitudDetalleDAO implements SolicitudDetalleDAO{

	@Override
	public SolicitudDetalle obtenerDetalle(String idSolicitud) {
		Connection conn = null;
		PreparedStatement pstm = null;
		SolicitudDetalle detalle = null;
		ResultSet res = null;
		
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_solidetalle where id_solicitud = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idSolicitud);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				detalle = new SolicitudDetalle();
				detalle.setIdInforme(res.getString(1));
				detalle.setIdAlumno(res.getString(2));
				detalle.setIdSede(res.getString(3));
				detalle.setMotivo(res.getString(4));
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
		return detalle;
	}

	
	
}
