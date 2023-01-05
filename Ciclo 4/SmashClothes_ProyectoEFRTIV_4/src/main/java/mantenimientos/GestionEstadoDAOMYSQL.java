package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Estado;
import entidad.Producto;
import interfaces.EstadoInterface;
import utils.MySQLConexion;

public class GestionEstadoDAOMYSQL implements EstadoInterface {

	@Override
	public ArrayList<Estado> listarEstado() {
		ArrayList<Estado> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		Estado  es = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_estados";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			while(res.next()) {
				es = new Estado();
				es.setIdEstado(res.getInt(1));
				es.setDescrip(res.getString(2));
				lista.add(es);
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
