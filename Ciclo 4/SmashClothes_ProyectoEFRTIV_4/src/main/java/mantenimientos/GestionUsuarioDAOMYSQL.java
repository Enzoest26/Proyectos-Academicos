package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Set;

import entidad.Cuenta;
import entidad.Usuario;
import interfaces.UsuarioInterface;
import utils.MySQLConexion;

public class GestionUsuarioDAOMYSQL implements UsuarioInterface{

	@Override
	public Usuario obtenerUsu(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Usuario usu = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios where cod_usu = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeQuery();
			
			if(res.next()) {
				usu = new Usuario();
				usu.setCodUsu(res.getString(1));
				usu.setNombre(res.getString(2));
				usu.setApellido(res.getString(3));
				usu.setTipoDoc(res.getInt(4));
				usu.setNumDoc(res.getString(5));
				usu.setSexo(res.getString(6));
				usu.setEdad(res.getInt(7));
				usu.setIdtipo(res.getInt(8));
				usu.setDepa(res.getString(9));
				usu.setDomici(res.getString(10));
				usu.setDistrito(res.getString(11));
				usu.setProvi(res.getString(12));
				usu.setPais(res.getString(13));
				usu.setNacio(res.getString(14));
				usu.setCorreo(res.getString(15));
				usu.setEstado(res.getInt(16));
				usu.setIdCuenta(res.getInt(17));
				usu.setFotoRu(res.getString(18));
				usu.setFotoExte(res.getString(19));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return usu;
	}

	@Override
	public int registrar(Usuario usu, Cuenta cu) {
		Connection conn = null;
		PreparedStatement pstm = null;
		PreparedStatement pstm1 = null;
		int  res = 0;
		
		try {
			
			/*Las transacciones */
			
			conn = MySQLConexion.getConexion();
			conn.setAutoCommit(false);
			
			String sql1 = "insert into tb_cuenta_usuarios values(?,?,?,?,?,?,?,? )";
			pstm1 = conn.prepareStatement(sql1);
			pstm1.setInt(1, cu.getCodigo());
			pstm1.setString(2, cu.getNombre());
			pstm1.setString(3, cu.getApellido());
			pstm1.setString(4, cu.getUsuario());
			pstm1.setString(5, cu.getClave());
			pstm1.setString(6, cu.getFecha_nac());
			pstm1.setInt(7, cu.getTipo());
			pstm1.setInt(8, cu.getEstado());
			res = pstm1.executeUpdate();
			
			String sql = "insert into tb_usuarios values (?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, usu.getCodUsu());
			pstm.setString(2, usu.getNombre());
			pstm.setString(3, usu.getApellido());
			pstm.setInt(4, usu.getTipoDoc());
			pstm.setString(5, usu.getNumDoc());
			pstm.setString(6, usu.getSexo());
			pstm.setInt(7, usu.getEdad());
			pstm.setInt(8, usu.getIdtipo());
			pstm.setString(9, usu.getDepa());
			pstm.setString(10, usu.getDomici());
			pstm.setString(11, usu.getDistrito());
			pstm.setString(12, usu.getProvi());
			pstm.setString(13, usu.getPais());
			pstm.setString(14, usu.getNacio());
			pstm.setString(15, usu.getCorreo());
			pstm.setInt(16, usu.getEstado());
			pstm.setInt(17, usu.getIdCuenta());
			pstm.setString(18, usu.getFotoRu());
			pstm.setString(19, usu.getFotoExte());
			res = pstm.executeUpdate();
			
			conn.commit();
			
		}catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				System.out.println("Error en el roll back - Usuario: " + e1.getMessage());
			}
			// TODO: handle exception
			System.out.println("Error en registrar - Transaccion: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int editar(Usuario usu) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int  res = 0;
		
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_usuarios set nombres_usu = ?, apellido_usu= ?, tipoDoc_usu = ?, numDoc_usu = ?, sexo_usu = ?,"
					+ "edad_usu = ?,id_tipo = ?,depa_usu = ?,domici_usu = ?,distrito_usu = ?, provi_usu = ?,pais_usu = ?, nacio_usu = ?,"
					+ "correo_usu=?,id_estado = ?, fotoRu_usu = ?,fotoExten_usu = ? where cod_usu = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usu.getNombre());
			pstm.setString(2, usu.getApellido());
			pstm.setInt(3, usu.getTipoDoc());
			pstm.setString(4, usu.getNumDoc());
			pstm.setString(5, usu.getSexo());
			pstm.setInt(6, usu.getEdad());
			pstm.setInt(7, usu.getIdtipo());
			pstm.setString(8, usu.getDepa());
			pstm.setString(9, usu.getDomici());
			pstm.setString(10, usu.getDistrito());
			pstm.setString(11, usu.getProvi());
			pstm.setString(12, usu.getPais());
			pstm.setString(13, usu.getNacio());
			pstm.setString(14, usu.getCorreo());
			pstm.setInt(15, usu.getEstado());
			pstm.setString(16, usu.getFotoRu());
			pstm.setString(17, usu.getFotoExte());
			pstm.setString(18, usu.getCodUsu());
			res = pstm.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en editar - Productos: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int eliminar(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int  res = 0;
		
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_usuarios set id_estado = 2 where cod_usu = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en editar - Productos: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public ArrayList<Usuario> listarUsuarios() {
		ArrayList<Usuario> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_usuarios";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			Usuario usu;
			while(res.next()) {
				usu = new Usuario();
				usu.setCodUsu(res.getString(1));
				usu.setNombre(res.getString(2));
				usu.setApellido(res.getString(3));
				usu.setTipoDoc(res.getInt(4));
				usu.setNumDoc(res.getString(5));
				usu.setSexo(res.getString(6));
				usu.setEdad(res.getInt(7));
				usu.setIdtipo(res.getInt(8));
				usu.setDepa(res.getString(9));
				usu.setDomici(res.getString(10));
				usu.setDistrito(res.getString(11));
				usu.setProvi(res.getString(12));
				usu.setPais(res.getString(13));
				usu.setNacio(res.getString(14));
				usu.setCorreo(res.getString(15));
				usu.setEstado(res.getInt(16));
				usu.setIdCuenta(res.getInt(17));
				usu.setFotoRu(res.getString(18));
				/*
				if((res.getBlob(9).getBinaryStream()) == null){
					p.setFoto(null);
				}else {
					p.setFoto(res.getBlob(9).getBinaryStream());
				}
				*/
				lista.add(usu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

	@Override
	public String obtenerCod() {
		String codigo = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select MAX(substring(cod_usu,3)) from tb_usuarios";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "US" + df.format(Integer.parseInt(res.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en obtener el codigo: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}
	

}
