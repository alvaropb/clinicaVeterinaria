package com.ipartek.clinicaMVC.conexion;

import java.sql.Connection;
import java.sql.SQLException;



import org.apache.commons.dbcp2.BasicDataSource;




public class Conexion {
	private static BasicDataSource dataSource=null;
	private static BasicDataSource getDataSource() {
		if(dataSource==null) {
			dataSource=new BasicDataSource();
			
			dataSource.setUrl("jdbc:mysql://localhost:3306/clinica_veterinaria?serverTimezone=UTC");//se añade timezone para que no de error
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUsername("debian-sys-maint");
			dataSource.setPassword("o8lAkaNtX91xMUcV");
			
			//pool de conexiones
			dataSource.setInitialSize(20);
			dataSource.setMaxIdle(15);
			dataSource.setMaxTotal(20);
			dataSource.setMaxWaitMillis(5000);
			//TODO preguntar:¿no es mas logico pasarle una conexion del pool al DAO desde el servlet?, porque 
			//tal y como está montado, se crea un pool de 20 conexiones cada vez que se hace una operacion CRUD
			//pero nunca usará mas de una por accion CRUD
			
		}
		return dataSource;
	}
	
	public static Connection getConexion() throws SQLException {
		return getDataSource().getConnection();
	}

}
