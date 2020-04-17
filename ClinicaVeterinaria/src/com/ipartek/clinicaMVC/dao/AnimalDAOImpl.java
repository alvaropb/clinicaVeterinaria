package com.ipartek.clinicaMVC.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ipartek.clinicaMVC.conexion.Conexion;
import com.ipartek.clinicaMVC.idao.AnimalDAO;
import com.ipartek.clinicaMVC.model.Animal;

public class AnimalDAOImpl implements AnimalDAO {
	
	private Connection conexion;
	private CallableStatement callableStatement;

	@Override
	public int createAnimal(Animal animal) {
		int id=0;
		try {
			//obtener la conexion
			String llamadaProcedimiento="{CALL clinica_veterinaria.clinica_veterinaria_animal_createAnimal(?,?,?,?,?)}";
											   
			conexion=Conexion.getConexion();
			callableStatement=conexion.prepareCall(llamadaProcedimiento);
			//					p_nombre,p_especie,p_raza,p_edad
			//parametros de entrada nombre IN,especie IN,raza IN,edad IN
			callableStatement.setString("p_nombre",animal.getNombre() );
			callableStatement.setString("p_especie",animal.getEspecie() );
			callableStatement.setString("p_raza", animal.getRaza());
			callableStatement.setInt("p_edad",animal.getEdad() );
			//parametros de salida ordenados segun el modelo Animal 
			//id OUT
			callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);

			
			
			callableStatement.execute();
			id=callableStatement.getInt("p_id");
			//id=callableStatement.getInt(5);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return id;
	}

	@Override
	public Animal getById(int id) {
		Animal animal=null;
		try {
			//obtener la conexion

			String llamadaProcedimiento="{CALL clinica_veterinaria.clinica_veterinaria_animal_getById(?,?,?,?,?,?)}";
			conexion=Conexion.getConexion();
			callableStatement=conexion.prepareCall(llamadaProcedimiento);
			
			//parametro de entrada
			callableStatement.setInt("in_id", id);
			//parametros de salida ordenados segun el modelo Animal 
			//id IN ,nombre OUT,especie OUT,raza OUT,edad OUT,id OUT 
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
			callableStatement.registerOutParameter(6, java.sql.Types.INTEGER);
			
			
			callableStatement.executeQuery();
			
			animal=new Animal();
			animal.setNombre(callableStatement.getString(2));
			animal.setEspecie(callableStatement.getString(3));
			animal.setRaza(callableStatement.getString(4));
			animal.setEdad(callableStatement.getInt(5));
			animal.setId(callableStatement.getInt(6));
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return animal;
	}

	@Override
	public List<Animal> getAll() {
		ArrayList<Animal>animales=new ArrayList<Animal>();
		String llamadaProcedimiento="{CALL clinica_veterinaria.clinica_veterinaria_animal_getAll()}";
		
		try {
			conexion=Conexion.getConexion();
			callableStatement=conexion.prepareCall(llamadaProcedimiento);
			ResultSet resultSet=callableStatement.executeQuery();
			//id IN ,nombre OUT,especie OUT,raza OUT,edad OUT,id OUT 
		while (resultSet.next()) {
			Animal animal=new Animal();
			animal.setNombre(resultSet.getNString("nombre"));
			animal.setEspecie(resultSet.getNString("especie"));
			animal.setRaza(resultSet.getNString("raza"));
			animal.setEdad(resultSet.getInt("edad"));
			animal.setId(resultSet.getInt("id"));
			animales.add(animal);
			
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return animales;
	}

	@Override
	public boolean update(Animal animal) {
		boolean resultado=false;
		try {
			//obtener la conexion
			String llamadaProcedimiento="{CALL clinica_veterinaria.clinica_veterinaria_animal_updateAnimal(?,?,?,?,?,?)}";
											   
			conexion=Conexion.getConexion();
			callableStatement=conexion.prepareCall(llamadaProcedimiento);
			//					
			//parametros de entrada nombre IN,especie IN,raza IN,edad IN
			callableStatement.setString("p_nombre",animal.getNombre() );
			callableStatement.setString("p_especie",animal.getEspecie() );
			callableStatement.setString("p_raza", animal.getRaza());
			callableStatement.setInt("p_edad",animal.getEdad() );
			callableStatement.setInt("p_id",animal.getId() );
		
			
			callableStatement.execute();
			resultado=callableStatement.getBoolean(6);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return resultado;
	}

	@Override
	public boolean delete(int id) {
		boolean resultado=false;
		try {
			//obtener la conexion

			String llamadaProcedimiento="{CALL clinica_veterinaria.clinica_veterinaria_animal_deleteAnimal(?,?)}";
											   
			conexion=Conexion.getConexion();
			callableStatement=conexion.prepareCall(llamadaProcedimiento);
			//					
			//parametros de entrada id IN

			callableStatement.setInt("p_id",id );
			
			callableStatement.execute();
			resultado=callableStatement.getBoolean(2);
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		return resultado;
	}

}
