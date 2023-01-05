package mantenimiento;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.DetalleBoleta;
import entidad.Solicitud;

import entidad.SolicitudDetalle;
import entidad.TipoSolicitud;
import interfaces.SolicitudInterfazDAO;
import utils.MySQLConexion8;

public class GestionSolicitudDAO implements SolicitudInterfazDAO {

	@Override
	public int registrarSolicitud(Solicitud sol, SolicitudDetalle scs) {
		int estado = 0;
		Connection conn = null;
		PreparedStatement pstm1 = null; //Registrar la solicitud
		PreparedStatement pstm2 = null; // Registrar en la tabla correspondiente
	
		
		try {
			conn = MySQLConexion8.getConexion();
			//Desactivar las transacciones de manera idependiente
			conn.setAutoCommit(false);
			//SQL
			String sql1 = "INSERT INTO tbl_solicitud VALUES (?,?,?,?)";
			//Enviar la instruccion
			pstm1 = conn.prepareStatement(sql1);
			//Parametros
			pstm1.setString(1, sol.getIdSolicitud());
			pstm1.setString(2, sol.getTipoSolicitud());
			pstm1.setString(3, sol.getIdEmple());
			pstm1.setString(4, sol.getFecha());
			estado = pstm1.executeUpdate();
			
			//el SQL2
			String sql2 = "INSERT INTO tbl_solidetalle values (?,?,?,?)";
			
			pstm2 = conn.prepareStatement(sql2);
			pstm2.setString(1, scs.getIdInforme());
			pstm2.setString(2, scs.getIdAlumno());
			pstm2.setString(3, scs.getIdSede());
			pstm2.setString(4,scs.getMotivo());
			
			estado = pstm2.executeUpdate();
			//Confirmar trasacciones
			conn.commit();
					
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al realizar la venta: " + e.getMessage());
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al restaurar la base de datos");
			}
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm1!=null) pstm1.close();
				if(pstm2!=null) pstm2.close();

			
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return estado;
	}

	@Override
	public String numSolicitud() {
		Connection conn = null;
		PreparedStatement pstm = null;
		String numsolicitud= null;
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT substring(max(id_solicitud), 4) FROM tbl_solicitud";
			
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				numsolicitud = "SOL" + df.format(Integer.parseInt(res.getString(1)) + 1); 
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
		return numsolicitud;
	}

	@Override
	public ArrayList<Solicitud> listar10Solicitudes() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Solicitud> listarSoli = new ArrayList<>();
		ResultSet res = null;
		Solicitud solicitud;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_solicitud ORDER BY id_solicitud DESC LIMIT 10";
			
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				solicitud = new Solicitud();
				solicitud.setIdSolicitud(res.getString(1));
				solicitud.setTipoSolicitud(res.getString(2));
				solicitud.setIdEmple(res.getString(3));
				solicitud.setFecha(res.getString(4));
				listarSoli.add(solicitud);
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
		return listarSoli;
	}

	@Override
	public ArrayList<Solicitud> listarSolicitudes() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Solicitud> listarSoli = new ArrayList<>();
		ResultSet res = null;
		Solicitud solicitud;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM proyecto_lp.tbl_solicitud";
			
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				solicitud = new Solicitud();
				solicitud.setIdSolicitud(res.getString(1));
				solicitud.setTipoSolicitud(res.getString(2));
				solicitud.setIdEmple(res.getString(3));
				solicitud.setFecha(res.getString(4));
				listarSoli.add(solicitud);
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
		return listarSoli;
	}

	@Override
	public Solicitud obtenerCabeSol(String idSol) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Solicitud sol = null;
		ResultSet res = null;
		
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_solicitud where id_solicitud = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idSol);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				sol = new Solicitud();
				sol.setIdSolicitud(res.getString(1));
				sol.setIdEmple(res.getString(3));
				sol.setTipoSolicitud(res.getString(2));
				sol.setFecha(res.getString(4));
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
		return sol;
	}
	
}
