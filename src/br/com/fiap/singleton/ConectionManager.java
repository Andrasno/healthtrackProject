package br.com.fiap.singleton;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionManager {

	private static ConectionManager connectionManager;
	
	private ConectionManager() {
		
	}
	
	public static ConectionManager  getInstance(){
		if(connectionManager == null) {
			connectionManager = new ConectionManager();
		}
		return connectionManager;
	}
	
	public Connection getConnection() {
		Connection connection = null;
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM82708", "fiap");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	
	}
	
	

}
