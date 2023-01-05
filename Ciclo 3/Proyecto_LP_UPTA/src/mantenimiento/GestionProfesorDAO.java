package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidad.Profesor;
import interfaces.ProfesorInterfazDAO;
import utils.MySQLConexion8;


public class GestionProfesorDAO implements ProfesorInterfazDAO{



	@Override
	public ArrayList<Profesor> listarProfesor() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ArrayList<Profesor> listarProfesor = new ArrayList<>();
		ResultSet rSet = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT * FROM tbl_profesores";
			pstm = conn.prepareStatement(sql);

			//Execute
			rSet = pstm.executeQuery();
			
			//Hacer el listado
			while(rSet.next()) {
				Profesor pr= new Profesor();
				pr.setIdProf(rSet.getString(1));
				pr.setNomProf(rSet.getString(2));
				pr.setApeProf(rSet.getString(3));
				pr.setDniProf(rSet.getString(4));
				pr.setFechaNac(rSet.getString(5));
				pr.setEdad(rSet.getInt(6));
				pr.setCel(rSet.getString(7));
				pr.setDomici(rSet.getString(8));
				pr.setIdDistrito(rSet.getString(9));
				pr.setCorreo(rSet.getString(10));
				pr.setSexo(rSet.getString(11));
				pr.setIdSede(rSet.getString(12));
				
				listarProfesor.add(pr);
			}
			
			
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
		return listarProfesor;
	}

	@Override
	public Profesor nombreProfesores(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		Profesor  pr = new Profesor();
		ResultSet rSet = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT nombre_prof FROM tbl_profesores WHERE id_prof = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			//Execute
			rSet = pstm.executeQuery();
			//Hacer el listado
			if(rSet.next()) {
				pr= new Profesor();
				pr.setIdProf(id);
				pr.setNomProf(rSet.getString(1));
			}
			
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error en la seccion: " + e.getMessage());
			}finally {
				try {
					if(conn != null) conn.close();
					if(pstm!=null) pstm.close();
					if(rSet!=null) rSet.close();
				} catch (SQLException e2) {
					// TODO: handle exception
					System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
				}
			}
		return pr;
		}

	@Override
	public int registrar(Profesor prof) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "INSERT INTO tbl_profesores VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
					
			pstm.setString(1, prof.getIdProf());
			pstm.setString(2, prof.getNomProf());
			pstm.setString(3, prof.getApeProf());
			pstm.setString(4, prof.getDniProf());
			pstm.setString(5, prof.getFechaNac());
			pstm.setInt(6, prof.getEdad());
			pstm.setString(7, prof.getCel());
			pstm.setString(8, prof.getDomici());
			pstm.setString(9, prof.getIdDistrito());
			pstm.setString(10, prof.getCorreo());
			pstm.setString(11, prof.getSexo());
			pstm.setString(12, prof.getIdSede());
			
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
	public int modificar(Profesor prof) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res = 0;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "UPDATE tbl_profesores SET nombre_prof = ?,apelli_prof = ?,"
					+ "dni_prof=?,fechaNa_prof=?, edad_prof = ?,"
					+ "cel_prof = ?, domici_prof = ?, id_distrito = ?, correo_prof = ?, sexo_prof=?, id_sede = ?"
					+ " WHERE id_prof = ?";
			pstm = conn.prepareStatement(sql);
			
			
			
			pstm.setString(1, prof.getNomProf());
			pstm.setString(2, prof.getApeProf());
			pstm.setString(3, prof.getDniProf());
			pstm.setString(4, prof.getFechaNac());
			pstm.setInt(5, prof.getEdad());
			pstm.setString(6, prof.getCel());
			pstm.setString(7, prof.getDomici());		
			pstm.setString(8, prof.getIdDistrito());
			pstm.setString(9, prof.getCorreo());
			pstm.setString(10, prof.getSexo());
			pstm.setString(11, prof.getIdSede());
			pstm.setString(12, prof.getIdProf());
			
		
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
	public int eliminar(String idProf) {
		
		int res = 0;
		Connection con = null;
		PreparedStatement pstm = null;
		try {

			con = MySQLConexion8.getConexion();
			String sql = "delete from tbl_profesores where id_prof = ?";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, idProf);
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
	public Profesor obterneID(String nombre) {
			Connection conn = null;
			PreparedStatement pstm = null;
			Profesor  pr = new Profesor();
			ResultSet rSet = null;
			try {
				conn = MySQLConexion8.getConexion();
				//SQL
				String sql = "SELECT nombre_prof FROM tbl_profesores WHERE nombre_prof = ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, nombre);
				//Execute
				rSet = pstm.executeQuery();
				//Hacer el listado
				if(rSet.next()) {
					pr= new Profesor();
					pr.setIdProf(nombre);
					pr.setNomProf(rSet.getString(1));
				}
				
				
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en la seccion: " + e.getMessage());
				}finally {
					try {
						if(conn != null) conn.close();
						if(pstm!=null) pstm.close();
						if(rSet!=null) rSet.close();
					} catch (SQLException e2) {
						// TODO: handle exception
						System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
					}
				}
			return pr;
			}
	
		
	}




