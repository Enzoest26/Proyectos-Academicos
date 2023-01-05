package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;

import entidad.Categoria;
import entidad.Estado;
import entidad.Prod_Cat;
import entidad.Producto;
import interfaces.ProductoInterface;
import utils.MySQLConexion;

public class GestionProductoDAOMYSQL implements ProductoInterface{

	@Override
	public Producto obtenerPro(String cod) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Producto p = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_productos where cod_prod=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeQuery();
			
			if(res.next()) {
				p = new Producto();
				p.setCodProd(res.getString(1));
				p.setFecha(res.getString(2));
				p.setDescrip(res.getString(3));;
				p.setIdCate(res.getString(4));
				p.setEstado(res.getInt(5));
				p.setStock(res.getInt(6));
				p.setPrecio(res.getDouble(7));
				p.setNombre(res.getString(8));
				p.setCodProvee(res.getString(9));
				p.setFoto(res.getString(10));
				p.setFotoExte(res.getString(11));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en consultar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return p;
	}

	@Override
	public int registrar(Producto p) {
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "insert into tb_productos values (?,?,?,?,?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, p.getCodProd());
			pstm.setString(2, p.getFecha());
			pstm.setString(3,p.getDescrip());
			pstm.setString(4, p.getIdCate());
			pstm.setInt(5, p.getEstado());
			pstm.setInt(6, p.getStock());
			pstm.setDouble(7, p.getPrecio());
			pstm.setString(8, p.getNombre());
			pstm.setString(9, p.getCodProvee());
			pstm.setString(10, p.getFoto());
			pstm.setString(11, p.getFotoExte());
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
	public int editar(Producto p) {
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_productos set  fecha_prod = ?, descrip_prod = ?, id_cate = ?,idestado = ? ,stock_prod= ?, precio_prod = ?, nombre_prod= ?, cod_pro=?, "
					+ "fotoRut_prod = ?,fotoExte_prod = ? where cod_prod = ?";
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, p.getFecha());
			pstm.setString(2,p.getDescrip());
			pstm.setString(3, p.getIdCate());
			pstm.setInt(4, p.getEstado());
			pstm.setInt(5, p.getStock());
			pstm.setDouble(6, p.getPrecio());
			pstm.setString(7, p.getNombre());
			pstm.setString(8, p.getCodProvee());
			pstm.setString(9, p.getFoto());
			pstm.setString(10, p.getFotoExte());
			pstm.setString(11, p.getCodProd());
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en editar - Proveedor: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public int eliminar(String cod) {
		int res = 0;
		//Plantilla de base de datos
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "update tb_productos set idestado = 2 where cod_prod = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cod);
			res = pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en eliminar - Producto: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return res;
	}

	@Override
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_productos";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			Producto p;
			while(res.next()) {
				p = new Producto();
				p.setCodProd(res.getString(1));
				p.setFecha(res.getString(2));
				p.setDescrip(res.getString(3));;
				p.setIdCate(res.getString(4));
				p.setEstado(res.getInt(5));
				p.setStock(res.getInt(6));
				p.setPrecio(res.getDouble(7));
				p.setNombre(res.getString(8));
				p.setCodProvee(res.getString(9));
				p.setFoto(res.getString(10));
				p.setFotoExte(res.getString(11));
				lista.add(p);
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
			String sql = "select MAX(substring(cod_prod,3)) from tb_productos";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("000");
				codigo = "PR" + df.format(Integer.parseInt(res.getString(1)) + 1);
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
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Categoria cate = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_categoria";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			while(res.next()) {
				cate = new Categoria();
				cate.setIdCate(res.getString(1));
				cate.setDescrip(res.getString(2));
				
				lista.add(cate);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar Categoria: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

	@Override
	public ArrayList<Producto> listarDisponibles() {
		ArrayList<Producto> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_productos where idestado = 1 AND stock_prod > 0;";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			Producto p;
			while(res.next()) {
				p = new Producto();
				p.setCodProd(res.getString(1));
				p.setFecha(res.getString(2));
				p.setDescrip(res.getString(3));;
				p.setIdCate(res.getString(4));
				p.setEstado(res.getInt(5));
				p.setStock(res.getInt(6));
				p.setPrecio(res.getDouble(7));
				p.setNombre(res.getString(8));
				p.setCodProvee(res.getString(9));
				p.setFoto(res.getString(10));
				p.setFotoExte(res.getString(11));
				lista.add(p);
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
	public ArrayList<Prod_Cat> listadoProductoCategoria() {
		ArrayList<Prod_Cat> listado = new ArrayList<Prod_Cat>(); // null
		// Plantilla de BD !!!
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select p.cod_prod, p.nombre_prod, p.descrip_prod, p.stock_prod, p.precio_prod, p.id_cate, p.idestado,c.id_cate, c.descrip_cate from tb_productos p inner join tb_categoria c on p.id_cate = c.id_cate;";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			// pasar el contenido del "rs" a la variable
			while (rs.next()) { //lee el contenido de cada fila
				Prod_Cat p = new Prod_Cat();
				p.setCodProd(rs.getString(1));
				p.setNombreProduct(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setStock(rs.getInt(4));
				p.setPrecio(rs.getDouble(5));
				p.setIdCate(rs.getString(6));
				p.setEstado(rs.getInt(7));
				p.setNombreCategoria(rs.getString(9));
				listado.add(p);
			}
			
		} catch (Exception e) {
			System.out.println("Error en listar Prod_Cat: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return listado;
	}

	@Override
	public ArrayList<Producto> listarReportes(String fecha, String cate) {
		ArrayList<Producto> listarProd = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Producto p = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "";
			if(fecha != null && cate != null) {
				sql = "SELECT * FROM tb_productos where id_cate = ? AND fecha_prod <= ?";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cate);
				pstm.setString(2, fecha);
				System.out.println("Estoy en niguno nula");
			}else {
				if(fecha == null && cate!= null) {
					sql = "SELECT * FROM tb_productos where id_cate = ?";
					System.out.println("Estoy en cate no nula");
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, cate);
				}else if(cate == null && fecha!=null) {
					sql = "SELECT * FROM tb_productos where fecha_prod <= ?";
					System.out.println("Estoy en fecha no nula " +fecha);
					
					pstm = conn.prepareStatement(sql);
					pstm.setString(1, fecha);
				}else if(cate == null && fecha == null) {
					System.out.println("Estoy en todos");
					sql = "SELECT * FROM tb_productos";
					pstm = conn.prepareStatement(sql);
				}
			}
			res = pstm.executeQuery();
			
			while(res.next()) {
				p = new Producto();
				p.setCodProd(res.getString(1));
				
				p.setFecha(res.getString(2));
				p.setDescrip(res.getString(3));;
				p.setIdCate(res.getString(4));
				p.setEstado(res.getInt(5));
				p.setStock(res.getInt(6));
				p.setPrecio(res.getDouble(7));
				p.setNombre(res.getString(8));
				p.setCodProvee(res.getString(9));
				p.setFoto(res.getString(10));
				p.setFotoExte(res.getString(11));
				listarProd.add(p);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en reportar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return listarProd;
	}
	

}
