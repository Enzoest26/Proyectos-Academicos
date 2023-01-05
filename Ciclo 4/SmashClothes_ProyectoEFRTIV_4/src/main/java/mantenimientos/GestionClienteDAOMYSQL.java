package mantenimientos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import entidad.Cliente;
import interfaces.ClienteInterface;
import utils.MySQLConexion;

public class GestionClienteDAOMYSQL implements ClienteInterface{

	@Override
	public Cliente obtenerCli(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Cliente cl = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_clientes where cod_cli = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeQuery();
			
			if(res.next()) {
				cl = new Cliente();
				cl.setCodigo(res.getString(1));
				cl.setNombre(res.getString(2));
				cl.setApellido(res.getString(3));
				cl.setTipoDoc(res.getInt(4));
				cl.setNumDoc(res.getString(5));
				cl.setSexo(res.getString(6));
				cl.setEdad(res.getInt(7));
				cl.setFechaNa(res.getString(8));
				cl.setEstado(res.getInt(9));
				cl.setCorreo(res.getString(10));
				cl.setFotoRu(res.getString(11));
				cl.setFotoExtension(res.getString(12));
				//cl.setFotoFull(res.getBlob(12).getBinaryStream());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return cl;
	}

	@Override
	public int registrar(Cliente cl) {
		// TODO Auto-generated method stub
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert into tb_clientes values (?,?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cl.getCodigo());
			pstm.setString(2, cl.getNombre());
			pstm.setString(3,cl.getApellido());
			pstm.setInt(4, cl.getTipoDoc());
			pstm.setString(5, cl.getNumDoc());
			pstm.setString(6, cl.getSexo());
			pstm.setInt(7, cl.getEdad());
			pstm.setString(8, cl.getFechaNa());
			pstm.setInt(9, cl.getEstado());
			pstm.setString(10, cl.getCorreo());
			pstm.setString(11, cl.getFotoRu());
			pstm.setString(12, cl.getFotoExtension());
			//pstm.setBlob(12, cl.getFotoFull());
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int editar(Cliente cl) {
		// TODO Auto-generated method stub
				int res = 0;
				//Plantilla de base de datos
				Connection conn = null;
				PreparedStatement pstm = null;
				try {
					conn = MySQLConexion.getConexion();
					String sql = "update tb_clientes set nombres_cli = ?, apellidos_cli = ?, tipoDoc_cli = ?, numDoc_cli = ?,sexo_cli = ?,"
							+ " edad_cli=?, fechaNa_cli = ?, id_estado = ?, correo_cli =?,fotoRu_cli = ?, extension_cli=? where cod_cli = ?";
					pstm = conn.prepareStatement(sql);
					
					pstm.setString(1, cl.getNombre());
					pstm.setString(2,cl.getApellido());
					pstm.setInt(3, cl.getTipoDoc());
					pstm.setString(4, cl.getNumDoc());
					pstm.setString(5, cl.getSexo());
					pstm.setInt(6, cl.getEdad());
					pstm.setString(7, cl.getFechaNa());
					pstm.setInt(8, cl.getEstado());
					pstm.setString(9, cl.getCorreo());
					pstm.setString(10, cl.getFotoRu());
					pstm.setString(11, cl.getFotoExtension());
					pstm.setString(12, cl.getCodigo());
					//pstm.setBlob(12, cl.getFotoFull());
					res = pstm.executeUpdate();
					
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error en editar: " + e.getMessage());
				}finally {
					MySQLConexion.closeConexion(conn);
				}
				return res;
	}

	@Override
	public int eliminar(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int res  =0;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_clientes set id_estado = 2 where cod_cli = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en eliminar: : " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public ArrayList<Cliente> listarClientes() {
		ArrayList<Cliente> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_clientes";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			Cliente cl;
			while(res.next()) {
				cl = new Cliente();
				cl.setCodigo(res.getString(1));
				cl.setNombre(res.getString(2));
				cl.setApellido(res.getString(3));
				cl.setTipoDoc(res.getInt(4));
				cl.setNumDoc(res.getString(5));
				cl.setSexo(res.getString(6));
				cl.setEdad(res.getInt(7));
				cl.setFechaNa(res.getString(8));
				cl.setEstado(res.getInt(9));
				cl.setCorreo(res.getString(10));
				cl.setFotoRu(res.getString(11));
				cl.setFotoExtension(res.getString(12));
				//cl.setFotoFull(res.getBlob(12).getBinaryStream());
				lista.add(cl);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar: " + e.getMessage());
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
			String sql = "select MAX(substring(cod_cli,3)) from tb_clientes";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "CL" + df.format(Integer.parseInt(res.getString(1)) + 1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}

	@Override
	public Cliente obtenerXNombre(String nombre) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Cliente cl = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_clientes where nombres_cli = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nombre);
			res = pstm.executeQuery();
			
			if(res.next()) {
				cl = new Cliente();
				cl.setCodigo(res.getString(1));
				cl.setNombre(res.getString(2));
				cl.setApellido(res.getString(3));
				cl.setTipoDoc(res.getInt(4));
				cl.setNumDoc(res.getString(5));
				cl.setSexo(res.getString(6));
				cl.setEdad(res.getInt(7));
				cl.setFechaNa(res.getString(8));
				cl.setEstado(res.getInt(9));
				cl.setCorreo(res.getString(10));
				cl.setFotoRu(res.getString(11));
				cl.setFotoExtension(res.getString(12));
				//cl.setFotoFull(res.getBlob(12).getBinaryStream());
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return cl;
	}

	@Override
	public ArrayList<Cliente> listarXCondi(String fecha, String nombre) {
		ArrayList<Cliente> lista = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "";
			if(fecha != null && nombre != null) {
				sql = "SELECT * FROM tb_clientes where nombres_cli like concat(?,'%') AND fechaNa_cli <= ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, nombre);
				pstm.setString(2, fecha);
				
			}else {
				if(fecha == null && nombre!= null) {
					sql = "SELECT * FROM tb_clientes where nombres_cli like concat(?,'%')";
					
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, nombre);
				}else if(nombre == null && fecha!=null) {
					sql = "SELECT * FROM tb_clientes where fechaNa_cli <= ?";
					
					
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, fecha);
				}else if(nombre == null && fecha == null) {
					
					sql = "SELECT * FROM tb_clientes;";
					pstm = conn.prepareStatement(sql);
				}
			}

			res = pstm.executeQuery();
			Cliente cl;
			while(res.next()) {
				cl = new Cliente();
				cl.setCodigo(res.getString(1));
				cl.setNombre(res.getString(2));
				cl.setApellido(res.getString(3));
				cl.setTipoDoc(res.getInt(4));
				cl.setNumDoc(res.getString(5));
				cl.setSexo(res.getString(6));
				cl.setEdad(res.getInt(7));
				cl.setFechaNa(res.getString(8));
				cl.setEstado(res.getInt(9));
				cl.setCorreo(res.getString(10));
				cl.setFotoRu(res.getString(11));
				cl.setFotoExtension(res.getString(12));
				//cl.setFotoFull(res.getBlob(12).getBinaryStream());
				lista.add(cl);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

}
