package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.TipoUsuarioInterfaces;
import entidad.TipoUsuario;
import utils.MySQLConexion;

public class GestionTipoUsuarioMYSQL implements TipoUsuarioInterfaces{

	@Override
	public ArrayList<TipoUsuario> listado() {
		ArrayList<TipoUsuario> lista = new ArrayList<TipoUsuario>();
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tb_tipos";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			// pasar el contenido del "rs" a la variable
			while (rs.next()) { //lee el contenido de cada fila
				TipoUsuario t = new TipoUsuario();
				t.setCod(rs.getInt(1));
				t.setDescrip(rs.getString(2));
				lista.add(t);
			}
					
		} catch (Exception e) {
			System.out.println("Error en listar: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista ;
	}

}
