package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.security.sasl.RealmCallback;

import entidad.Alumno;
import entidad.AlumnoEstado;
import entidad.ReportarAlumno;
import interfaces.AlumnoIntefazDAO;
import utils.MySQLConexion8;


public class GestionAlumnoDAO implements AlumnoIntefazDAO{

	@Override
	public int registrar(Alumno al) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "INSERT INTO tbl_alumnos VALUES (?,?,?,?,?,?,default,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, al.getIdAlumno());
			pstm.setString(2, al.getNombre());
			pstm.setString(3, al.getApellido());
			pstm.setString(4, al.getDni());
			pstm.setString(5, al.getFechNa());
			pstm.setInt(6, al.getEdad());
			pstm.setString(7, al.getTeleMo());
			pstm.setString(8, al.getTeleFi());
			pstm.setString(9, al.getDomici());
			pstm.setString(10, al.getIdDistrito());
			pstm.setString(11, al.getCorreo());
			pstm.setString(12, al.getSexo());
			pstm.setString(13, al.getNacio());
			
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
	public int modificar(Alumno al) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "UPDATE tbl_alumnos SET nombre_alum = ?,apelli_alum = ?,"
					+ "dni_alum=?,fechaNa_alum=?, edad_alum = ?,"
					+ "teleMo_alum = ?, teleFi_alum = ?, domici_alum = ?, id_distrito = ?, correo_alum = ?, sexo_alum=?, nacio_alum = ?"
					+ " WHERE id_alum = ?";
			pstm = conn.prepareStatement(sql);
			
			
			pstm.setString(1, al.getNombre());
			pstm.setString(2, al.getApellido());
			pstm.setString(3, al.getDni());
			pstm.setString(4, al.getFechNa());
			pstm.setInt(5, al.getEdad());
			pstm.setString(6, al.getTeleMo());
			pstm.setString(7, al.getTeleFi());
			pstm.setString(8, al.getDomici());
			pstm.setString(9, al.getIdDistrito());
		
			pstm.setString(10, al.getCorreo());
			pstm.setString(11, al.getSexo());
			pstm.setString(12,al.getNacio());
			pstm.setString(13, al.getIdAlumno());
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
	public int eliminar(String idAlumno) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "UPDATE tbl_alumnos SET id_estado = 2 WHERE id_alum = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, idAlumno);
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
	public ArrayList<Alumno> listarAlumnosGeneral() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Alumno> listarAlumnos = new ArrayList<>();
		ResultSet rSet = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_alumnos";
			pstm = conn.prepareStatement(sql);

			//Execute
			rSet = pstm.executeQuery();
			
			//Hacer el listado
			while(rSet.next()) {
				Alumno al= new Alumno();
				al.setIdAlumno(rSet.getString(1));
				al.setNombre(rSet.getString(2));
				al.setApellido(rSet.getString(3));
				al.setDni(rSet.getString(4));
				al.setFechNa(rSet.getString(5));
				al.setEdad(rSet.getInt(6));
				
				al.setTeleMo(rSet.getString(7));
				al.setTeleFi(rSet.getString(8));
				al.setDomici(rSet.getString(9));
				al.setIdDistrito(rSet.getString(10));
				al.setCorreo(rSet.getString(11));
				al.setSexo(rSet.getString(12));
				
				listarAlumnos.add(al);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(rSet != null)rSet.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return listarAlumnos;
	}
	@Override
	public ArrayList<Alumno> listarAlumnosActivos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Alumno> listarAlumnos = new ArrayList<>();
		ResultSet rSet = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_alumnos where id_estado = 1";
			pstm = conn.prepareStatement(sql);

			//Execute
			rSet = pstm.executeQuery();
			
			//Hacer el listado
			while(rSet.next()) {
				Alumno al= new Alumno();
				al.setIdAlumno(rSet.getString(1));
				al.setNombre(rSet.getString(2));
				al.setApellido(rSet.getString(3));
				al.setDni(rSet.getString(4));
				al.setFechNa(rSet.getString(5));
				al.setEstado(rSet.getInt(6));
				
	
				al.setTeleMo(rSet.getString(7));
				al.setTeleFi(rSet.getString(8));
				al.setDomici(rSet.getString(9));
				al.setIdDistrito(rSet.getString(10));
				al.setCorreo(rSet.getString(11));
				al.setSexo(rSet.getString(12));
				listarAlumnos.add(al);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en la seccion: " + e.getMessage());
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm!=null) pstm.close();
				if(rSet != null) rSet.close();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return listarAlumnos;
	}

	@Override
	public ArrayList<ReportarAlumno> buscarAlumno(String cond) {
		ArrayList<ReportarAlumno>listarAlumnos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		ReportarAlumno ral;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "{call usp_BuscarAlumno(?) }";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, cond);
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				ral = new ReportarAlumno();
				ral.setIdAlumno(res.getString(1));
				ral.setNombrecompletos(res.getString(2));
				ral.setDni(res.getString(3));
				
				listarAlumnos.add(ral);
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
		return listarAlumnos;
	}

	@Override
	public ArrayList<AlumnoEstado> listarEstados() {
		ArrayList<AlumnoEstado>listarEstados = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		AlumnoEstado alE;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_alumnoestado";
			pstm = conn.prepareStatement(sql);
			
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				alE = new AlumnoEstado();
				alE.setIdEstado(res.getInt(1));
				alE.setDescrip(res.getString(2));
				
				listarEstados.add(alE);
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
		return listarEstados;
	}

	@Override
	public Alumno obtenerDatos(String idAlu) {
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Alumno al = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "select * from tbl_alumnos where id_alum = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, idAlu);
			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				al= new Alumno();
				al.setIdAlumno(res.getString(1));
				al.setNombre(res.getString(2));
				al.setApellido(res.getString(3));
				al.setDni(res.getString(4));
				al.setFechNa(res.getString(5));
				al.setEdad(res.getInt(6));
				al.setTeleMo(res.getString(8));
				al.setTeleFi(res.getString(9));
				al.setDomici(res.getString(10));
				al.setIdDistrito(res.getString(11));
				al.setCorreo(res.getString(12));
				al.setSexo(res.getString(13));
				al.setNacio(res.getString(14));
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
		return al;
	}

	@Override
	public String numAlumno() {
		Connection conn = null;
		PreparedStatement pstm = null;
		String numAlu= null;
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT substring(max(id_alum), 3) FROM tbl_alumnos";
			
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("0000");
				numAlu = "AL" + df.format(Integer.parseInt(res.getString(1)) + 1); 
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
		return numAlu;
	}

}
