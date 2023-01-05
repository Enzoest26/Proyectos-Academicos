package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {
	//metodo encargado de realizar la conexión con la BD
	public static Connection getConexion() {
		//Declarando un objeto de tipo conection
		Connection con = null;
		try {
			//Estableciendo el drive de la base de datos
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Determinar los datos a la base de datos
						//driver:protocoloDriver//ubicacion//nombreBD//actualización
			String url = "jdbc:mysql://localhost:3306/proyecto_lp_02?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String usr = "root";//root
			String psw = "Gatini26";//contraseña
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException e) {
			System.out.println("Error >> Driver no Instalado!!" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error >> de conexión con la BD" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error >> general : " + e.getMessage());
		} 
		return con;
	}

}
