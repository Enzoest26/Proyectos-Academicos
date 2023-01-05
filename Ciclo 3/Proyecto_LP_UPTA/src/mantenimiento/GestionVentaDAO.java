package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import entidad.Alumno;
import entidad.CabeceraBoleta;
import entidad.DetalleBoleta;
import interfaces.VentaInterfazDAO;
import utils.MySQLConexion8;

public class GestionVentaDAO implements VentaInterfazDAO {

	@Override
	public String numBoleta() {
		String codigo = "B00001";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet res = null;
		try {
			conn = MySQLConexion8.getConexion();
			//SQL
			String sql = "SELECT substring(max(id_boleta),2) FROM tbl_cabe_boletas ";
			pstm = conn.prepareStatement(sql);

			//Execute
			res = pstm.executeQuery();
			if(res.next()) {
				DecimalFormat df = new DecimalFormat("00000");
				codigo = "B" + df.format(Integer.parseInt(res.getString(1)) + 1);
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
		return codigo;
	}

	@Override
	public int realizarVenta(CabeceraBoleta cBol, ArrayList<DetalleBoleta> dbol) {
		int estado = 0;
		Connection conn = null;
		PreparedStatement pstm1 = null; //registrar en la cabecera
		PreparedStatement pstm2 = null; // Registrar los detalles
		PreparedStatement pstm3 = null; //Modificar los vacantes
		
		try {
			conn = MySQLConexion8.getConexion();
			//Desactivar las transacciones de manera idependiente
			conn.setAutoCommit(false);
			//SQL
			String sql1 = "INSERT INTO tbl_cabe_boletas VALUES (?,?,?,?,?,?)";
			//Enviar la instruccion
			pstm1 = conn.prepareStatement(sql1);
			//Parametros
			pstm1.setString(1, cBol.getIdBoleta());
			pstm1.setString(2, cBol.getFechaBoleta());
			pstm1.setString(3, cBol.getIdAlum());
			pstm1.setString(4, cBol.getIdEmple());
			pstm1.setDouble(5, cBol.getPrecioBoleta());
			if(cBol.getIdTipoBol() == null) {
				pstm1.setString(6, "BTI001");
			}else {
				pstm1.setString(6, cBol.getIdTipoBol());
			}
			
			estado = pstm1.executeUpdate();
			
			//el SQL2
			String sql2 = "INSERT INTO tbl_detalleboleta values (?,?,?)";
			for (DetalleBoleta detalle : dbol) {
				pstm2 = conn.prepareStatement(sql2);
				pstm2.setString(1, cBol.getIdBoleta());
				pstm2.setString(2, detalle.getIdCurso());
				pstm2.setDouble(3, detalle.getPrecioCurso());
				
				estado = pstm2.executeUpdate();
			}
			
			//SQL3 ---> Actualizar las vacantes
			String sql3 = "Update tbl_cursos set vacantes_curso = vacantes_curso - 1 where id_curso = ?";
			for (DetalleBoleta detalle : dbol) {
				pstm3 = conn.prepareStatement(sql3);
				pstm3.setString(1, detalle.getIdCurso());
				
				estado = pstm3.executeUpdate();
			}
			//Confirmar trasacciones
			conn.commit();
					
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al realizar la venta: " + e.getMessage());
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al restaurar la base de datos");
			}
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm1!=null) pstm1.close();
				if(pstm2!=null) pstm2.close();
				if(pstm3!=null) pstm3.close();
			
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return estado;
	
	}

	@Override
	public int realzarBoletaAuto(CabeceraBoleta cBol) {
		int estado = 0;
		Connection conn = null;
		PreparedStatement pstm1 = null; //registrar en la cabecera
		
		try {
			conn = MySQLConexion8.getConexion();

			//SQL
			String sql1 = "INSERT INTO tbl_cabe_boletas VALUES (?,?,?,?,?,?)";
			//Enviar la instruccion
			pstm1 = conn.prepareStatement(sql1);
			//Parametros
			pstm1.setString(1, cBol.getIdBoleta());
			pstm1.setString(2, cBol.getFechaBoleta());
			pstm1.setString(3, cBol.getIdAlum());
			pstm1.setString(4, cBol.getIdEmple());
			pstm1.setDouble(5, cBol.getPrecioBoleta());
			if(cBol.getIdTipoBol() == null) {
				pstm1.setString(6, "default");
			}else {
				pstm1.setString(6, cBol.getIdTipoBol());
			}
			
			estado = pstm1.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al realizar la venta: " + e.getMessage());
			try {
				conn.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println("Error al restaurar la base de datos");
			}
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstm1!=null) pstm1.close();
			
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println("Error en cerrar la base de datos: " + e2.getMessage());
			}
		}
		return estado;
	}

	
}
