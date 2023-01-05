package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Alumno;
import entidad.TipoBoleta;
import interfaces.TipoBoletaInterfazDAO;
import utils.MySQLConexion8;

public class GestionTipoBoletaDAO implements TipoBoletaInterfazDAO{

	@Override
	public ArrayList<TipoBoleta> listarBoleta() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<TipoBoleta> listarTipos = new ArrayList<>();
		ResultSet res = null;
		TipoBoleta tipo;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tipoboleta";
			pstm = conn.prepareStatement(sql);

			//Execute
			res= pstm.executeQuery();
			
			//Hacer el listado
			while(res.next()) {
				tipo = new TipoBoleta();
				tipo.setIdTipoBol(res.getString(1));
				tipo.setDescripBol(res.getString(2));
				tipo.setPrecio(res.getDouble(3));
				listarTipos.add(tipo);
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
		return listarTipos;
	}

	@Override
	public TipoBoleta obtenerID(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet res = null;
		TipoBoleta tipo = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_tipoboleta where descrip_tipobol = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			//Execute
			res= pstm.executeQuery();
		
			
			//Hacer el listado
			if(res.next()) {
				tipo = new TipoBoleta();
				tipo.setIdTipoBol(res.getString(1));
				tipo.setDescripBol(res.getString(2));
				tipo.setPrecio(res.getDouble(3));
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
		return tipo;
	}

}
