package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import entidad.TipoDocumento;
import interfaces.TipoDocumentoInterface;
import utils.MySQLConexion;

public class GestionTipoDocumentoDAOMYSQL implements TipoDocumentoInterface{

	@Override
	public ArrayList<TipoDocumento> listarTipo() {
		ArrayList<TipoDocumento> lista = new ArrayList<>(); 
		//Plantilla de la bd

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		TipoDocumento  tDoc = null;
		try {
			conn = MySQLConexion.getConexion();
			String sql = "select * from tb_tipodocumento";
			pstm = conn.prepareStatement(sql);

			res = pstm.executeQuery();
			while(res.next()) {
				tDoc = new TipoDocumento();
				tDoc.setCod(res.getInt(1));
				tDoc.setDescrip(res.getString(2));
				lista.add(tDoc);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error en listar - Tipo Documento: " + e.getMessage());
		}finally {
			MySQLConexion.closeConexion(conn);
		}
		return lista;
	}

}
