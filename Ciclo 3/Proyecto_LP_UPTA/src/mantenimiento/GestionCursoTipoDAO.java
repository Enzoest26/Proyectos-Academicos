package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Curso;
import entidad.TipoCurso;
import interfaces.CursoTipoInterfazDAO;
import utils.MySQLConexion8;

public class GestionCursoTipoDAO implements CursoTipoInterfazDAO{

	@Override
	public ArrayList<TipoCurso> listaCursosxTipo() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<TipoCurso> lista = new ArrayList<>();
		ResultSet res = null;
		//Crear el objeto
		TipoCurso tcu;
		try {
			conn = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tbl_cursostipo";
			pstm = conn.prepareStatement(sql);
			//No hay parametros
			res = pstm.executeQuery();
			while(res.next()) {
				//Obtener los valores
				tcu = new TipoCurso();
				
				tcu.setIdTipoCurso(res.getString(1));
				tcu.setNombre(res.getString(2));
				
				lista.add(tcu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la sección: " + e.getMessage());
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(res !=null) {
					res.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e.getMessage());
			}
		}
		return lista;
		
	}

	@Override
	public ArrayList<TipoCurso> listarIdCursoXNombre(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<TipoCurso> lista = new ArrayList<>();
		ResultSet res = null;
		//Crear el objeto
		TipoCurso tcu;
		try {
			conn = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tbl_cursostipo WHERE nombre_tipo = ?";
			pstm = conn.prepareStatement(sql);
			//hay parametros
			pstm.setString(1, nombre);
			
			res = pstm.executeQuery();
			while(res.next()) {
				//Obtener los valores
				tcu = new TipoCurso();
				
				tcu.setIdTipoCurso(res.getString(1));
				tcu.setNombre(res.getString(2));
				
				lista.add(tcu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la sección: " + e.getMessage());
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(res !=null) {
					res.close();
				}
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e.getMessage());
			}
		}
		return lista;
	}
	
	
}
