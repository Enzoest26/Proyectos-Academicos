package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.TipoSolicitud;
import interfaces.TipoSolicitudInterfazDAO;
import utils.MySQLConexion8;

public class GestionTipoSolicitudDAO implements TipoSolicitudInterfazDAO {

	@Override
	public ArrayList<TipoSolicitud> listarSolicitud() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<TipoSolicitud> listarTipoSol = new ArrayList<>();
		ResultSet res = null;
		TipoSolicitud tipoSolicitud;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tiposolicitud";
			
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				tipoSolicitud = new TipoSolicitud();
				tipoSolicitud.setIdTipoSol(res.getString(1));
				tipoSolicitud.setNombreTipoSol(res.getString(2));
				
				listarTipoSol.add(tipoSolicitud);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null)res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return listarTipoSol;
	}

	@Override
	public TipoSolicitud obtenerTipoSol(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		TipoSolicitud tipoSolicitud = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tiposolicitud WHERE nombre_tiposoli = ?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);

			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				tipoSolicitud = new TipoSolicitud();
				tipoSolicitud.setIdTipoSol(res.getString(1));
				tipoSolicitud.setNombreTipoSol(res.getString(2));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null)res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return tipoSolicitud;
	}

	@Override
	public TipoSolicitud obtenerNombreSol(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		TipoSolicitud tipoSolicitud = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tiposolicitud WHERE id_tiposoli = ?";
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);

			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				tipoSolicitud = new TipoSolicitud();
				tipoSolicitud.setIdTipoSol(res.getString(1));
				tipoSolicitud.setNombreTipoSol(res.getString(2));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(res != null)res.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return tipoSolicitud;
	}

}
