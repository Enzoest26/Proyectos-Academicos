package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import interfaces.CuentaInterfaces;
import entidad.Cuenta;
import utils.MySQLConexion;

public class GestionCuentaMySQL implements CuentaInterfaces{

	@Override
	public int registrar(Cuenta u) {
		int rs = 0;
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tb_cuenta_usuarios values (null,?,?,?,?,?, default, default);";
			pstm = con.prepareStatement(sql);
			pstm.setString(1, u.getNombre());
			pstm.setString(2, u.getApellido());
			pstm.setString(3, u.getUsuario());
			pstm.setString(4, u.getClave());
			pstm.setString(5, u.getFecha_nac());
			// ejecutar la sentencia y guardar el resultado
			rs = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar usuario: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public Cuenta validar(String usuario, String clave) {
		Cuenta u = null;
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			// PASO 1 : Establecer la conexión con la BD
			con = MySQLConexion.getConexion();
			// PASO 2 : Establecer la instrucción SQL --> 
			String sql = "{call usp_validaAccesoMini(?,?)}";
			// PASO 3 : Enviar la variable SQL al objeto "pstm" --> obtener los comandos
			pstm = con.prepareStatement(sql);
			// PASO 4 : Parámetros
			pstm.setString(1, usuario);
			pstm.setString(2, clave);
			// PASO 5 : Ejecutar la instruccion SQL
			res = pstm.executeQuery();
			// condicional
			if(res.next()){
				u = new Cuenta(
						res.getInt(1),
						res.getString(2),
						res.getString(3),
						res.getString(4),
						res.getString(5),
						res.getString(6),
						res.getInt(7),
						res.getInt(8)
						);
			}
		} catch (Exception e) {
			System.out.println(">>>> Error en la instrucción SQL - Validar usuario : " + e.getMessage());
		} finally {
			try {
				if(pstm != null)pstm.close();
				if(con != null)con.close();
				
			} catch (SQLException e2) {
				System.out.println(">>>> Error al cerrar la BD " + e2.getMessage());
			}
		}
		// Plantilla 
		return u;
	}

	@Override
	public int obtenerCod() {
		int codigo = 0;
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "Select MAX(codigo) from tb_cuenta_usuarios";
			pstm = conn.prepareStatement(sql);
			res = pstm.executeQuery();
			if(res.next()) {
				codigo = res.getInt(1)+1;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en registrar: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return codigo;
	}

}
