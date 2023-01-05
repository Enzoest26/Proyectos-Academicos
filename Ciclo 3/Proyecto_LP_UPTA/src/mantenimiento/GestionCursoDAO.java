package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidad.Alumno;
import entidad.Curso;
import entidad.CursosXProfesores;
import entidad.ReportarAlumno;
import interfaces.CursoInterfazDAO;
import utils.MySQLConexion8;

public class GestionCursoDAO implements CursoInterfazDAO{

	@Override
	public int registrar(Curso cur) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "INSERT INTO tbl_cursos VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cur.getIdCurso());
			pstm.setString(2, cur.getNombre());
			pstm.setString(3, cur.getIdprofesor());
			pstm.setString(4, cur.getCiclo());
			pstm.setString(5, cur.getCarrera());
			pstm.setString(6, cur.getDia());
			pstm.setString(7, cur.getIdTipo());
			pstm.setString(8, cur.getFechaIni());
			pstm.setString(9, cur.getFehcaFin());
			pstm.setString(10, cur.getIdHorario());
			pstm.setInt(11, cur.getVacantes());
			pstm.setInt(12, cur.getCreditos());
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
	public int modificar(Curso cur) {

		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "UPDATE tbl_cursos SET nombre_curso=?, id_prof=?, ciclo = ?, id_carrera = ?, dias_curso=?, id_tipo=?, fechaIni_curso=?, fechaFin_curso=?, id_horario=?, vacantes_curso=?, creditos_curso=?   WHERE id_curso = ?";
			pstm = conn.prepareStatement(sql); 
			pstm.setString(1, cur.getNombre());
			pstm.setString(2, cur.getIdprofesor());
			pstm.setString(3, cur.getCiclo());
			pstm.setString(4, cur.getCarrera());
			pstm.setString(5, cur.getDia());
			pstm.setString(6, cur.getIdTipo());
			pstm.setString(7, cur.getFechaIni());
			pstm.setString(8, cur.getFehcaFin());
			pstm.setString(9, cur.getIdHorario());
			pstm.setInt(10, cur.getVacantes());
			pstm.setInt(11, cur.getCreditos());
			pstm.setString(12, cur.getIdCurso());
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
	public int eliminar(String idCurso) {
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "delete from tbl_cursos where id_curso = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idCurso);
			//5 Se ejecuta la Instrucción
			res = pstm.executeUpdate();
						
		} catch (Exception e) {
			System.out.println(">>>>>>>>>>>> Error en la Instrucción SQL - Eliminar" + e.getMessage());
		}finally {
			try {
				if(pstm != null ) pstm.close();
				if(con != null) con.close();
				
			} catch (SQLException e2) {
				System.out.println("<<<< Error al cerrar la base de datos "+ e2.getMessage());
			}
		}
		return res;
	}

	@Override
	public ArrayList<Curso> listaCursos() {

		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Curso> listarCursos = new ArrayList<>();
		ResultSet res = null;
		Curso c = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_cursos";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			
			//Hacer el listado
			while(res.next()) {
				c = new Curso();
				c.setIdCurso(res.getString(1));
				c.setNombre(res.getString(2));
				c.setIdprofesor(res.getString(3));
				c.setCiclo(res.getString(4));
				c.setCarrera(res.getString(5));
				c.setDia(res.getString(6));
				c.setIdTipo(res.getString(7));
				c.setFechaIni(res.getString(8));
				c.setFehcaFin(res.getString(9));
				c.setIdHorario(res.getString(10));
				c.setVacantes(res.getInt(11));
				c.setCreditos(res.getInt(12));
				
				listarCursos.add(c);
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
		return listarCursos;
	}

	@Override
	public ArrayList<CursosXProfesores> buscarCursos(String condi) {
		ArrayList<CursosXProfesores> buscarCursos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		CursosXProfesores cuP;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "{call usp_BuscarCurso(?)}";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, condi);
			//Execute
			res = pstm.executeQuery();
			
			while(res.next()) {
				cuP = new CursosXProfesores();
				cuP.setIdCurso(res.getString(1));
				cuP.setNombre(res.getString(2));
				cuP.setNombreProfesor(res.getString(3));
				cuP.setDia(res.getString(4));
				cuP.setHorario(res.getString(5));
				
				buscarCursos.add(cuP);
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
		return buscarCursos;
	}

	@Override
	public int obtenerCreditos(String idCurso) {
		int creditos = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT creditos_curso FROM tbl_cursos WHERE id_curso = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, idCurso);
			//Execute
			res = pstm.executeQuery();
			
			//Hacer el listado
			if(res.next()) {
				creditos = res.getInt(1);
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
		return creditos;
	}

	@Override
	public int obtenerVacantes(String idCurso) {
		int vacantes = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT vacantes_curso FROM tbl_cursos WHERE id_curso = ?";
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, idCurso);
			//Execute
			res = pstm.executeQuery();
			
			//Hacer el listado
			if(res.next()) {
				vacantes = res.getInt(1);
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
		return vacantes;
	}

	@Override
	public ArrayList<Curso> listarIdCursoXNombre(String tipo) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Curso> lista = new ArrayList<Curso>();
		ResultSet res = null;
		//Crear el objeto 
		Curso tcu;
		try {
			conn = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM proyecto_lp.tbl_cursos where id_tipo = ?";
			pstm = conn.prepareStatement(sql);
			//hay parametros
			pstm.setString(1, tipo);
			
			res = pstm.executeQuery();
			while(res.next()) {
				//Obtener los valores
				tcu = new Curso();
				
				tcu.setIdCurso(res.getString(1));
				tcu.setNombre(res.getString(2));
				tcu.setIdprofesor(res.getString(3));
				tcu.setDia(res.getString(4));
				tcu.setIdTipo(res.getString(5));
				tcu.setFechaIni(res.getString(6));
				tcu.setFehcaFin(res.getString(7));
				tcu.setIdHorario(res.getString(8));
				tcu.setVacantes(res.getInt(9));
				tcu.setCreditos(res.getInt(10));
				
				
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
	public Curso obtenerCursoXID(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet res = null;
		//Crear el objeto 
		Curso tcu = null;
		try {
			conn = MySQLConexion8.getConexion();
			String sql = "SELECT * FROM tbl_cursos where id_curso = ?";
			pstm = conn.prepareStatement(sql);
			//hay parametros
			pstm.setString(1, id);
			
			res = pstm.executeQuery();
			while(res.next()) {
				//Obtener los valores
				tcu = new Curso();
				
				tcu.setIdCurso(res.getString(1));
				tcu.setNombre(res.getString(2));
				tcu.setIdprofesor(res.getString(3));
				tcu.setCiclo(res.getString(4));
				tcu.setCarrera(res.getString(5));
				tcu.setDia(res.getString(6));
				tcu.setIdTipo(res.getString(7));
				tcu.setFechaIni(res.getString(8));
				tcu.setFehcaFin(res.getString(9));
				tcu.setIdHorario(res.getString(10));
				tcu.setVacantes(res.getInt(11));
				tcu.setCreditos(res.getInt(12));
				
				
			
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
		return tcu;
	}
	
}
