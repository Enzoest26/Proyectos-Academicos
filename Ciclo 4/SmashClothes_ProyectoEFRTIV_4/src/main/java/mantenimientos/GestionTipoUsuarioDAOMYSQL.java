package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entidad.TipoUsuario;
import interfaces.TipoUsuarioInterface;
import utils.MySQLConexion;

public class GestionTipoUsuarioDAOMYSQL implements TipoUsuarioInterface{

	@Override
	public ArrayList<TipoUsuario> listarTipoUsu() {
		ArrayList<TipoUsuario> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoUsuario tUsu = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_tipos";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			while(res.next()) {
				tUsu = new TipoUsuario();
				tUsu.setCod(res.getInt(1));
				tUsu.setDescrip(res.getString(2));
				lista.add(tUsu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar - Tipo Usuario: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

	@Override
	public ArrayList<TipoUsuario> listarManUsuario() {
		ArrayList<TipoUsuario> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoUsuario tUsu = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_tipos where idtipo != 2;";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			while(res.next()) {
				tUsu = new TipoUsuario();
				tUsu.setCod(res.getInt(1));
				tUsu.setDescrip(res.getString(2));
				lista.add(tUsu);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar - Tipo Usuario: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

}
