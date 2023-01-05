package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import entidad.Alumno;
import entidad.AlumnoAca;
import interfaces.AlumnoAcaInterfazDAO;
import utils.MySQLConexion8;

public class GestionAlumnoAcaDAO implements AlumnoAcaInterfazDAO {

	@Override
	public int registrar(AlumnoAca alc) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "INSERT INTO tbl_alumnoaca VALUES (?,?,?,?)";
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, alc.getIdAlumno());
			pstm.setString(2, alc.getIdCarrera());
			pstm.setString(3, alc.getIdSede());
			pstm.setString(4, alc.getCiclo());
			
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

	@Override
	public int modificar(AlumnoAca alc) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "update tbl_alumnoaca set id_carrera = ?, id_sede= ?,ciclo_aca = ? WHERE id_alum = ?";
			
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, alc.getIdCarrera());
			pstm.setString(2, alc.getIdSede());
			pstm.setString(3, alc.getCiclo());
			pstm.setString(4, alc.getIdAlumno());
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

	@Override
	public AlumnoAca obtenerDatos(String idAlum) {

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		AlumnoAca alc = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "select * from tbl_alumnoaca where id_alum = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, idAlum);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				alc = new AlumnoAca();
				alc.setIdAlumno(res.getString(1));
				alc.setIdCarrera(res.getString(2));
				alc.setIdSede(res.getString(3));
				alc.setCiclo(res.getString(4));
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
		return alc;
	}

}
