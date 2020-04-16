package com.ipartek.clinicaMVC.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.ipartek.clinicaMVC.conexion.Conexion;
import com.ipartek.clinicaMVC.idao.AnimalDAO;
import com.ipartek.clinicaMVC.model.Animal;

public class AnimalDAOImpl implements AnimalDAO {
	
	private Connection conexion;
	private CallableStatement callableStatement;

	@Override
	public int createAnimal(Animal animal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Animal getById(int id) {
		Animal animal=null;;
		try {
			//obtener la conexion
			/*
			 *     private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private int id;

			 */
			String llamadaProcedimiento="{CALl clinica_veterinaria.clinica_veterinaria_animal_getById(?,?,?,?,?,?)}";
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Animal animal) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
