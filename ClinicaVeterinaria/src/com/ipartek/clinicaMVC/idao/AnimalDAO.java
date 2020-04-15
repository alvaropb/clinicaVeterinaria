package com.ipartek.clinicaMVC.idao;

import java.util.List;

import com.ipartek.clinicaMVC.model.Animal;

public interface AnimalDAO {

	/*
	 * C R U D
	 */

	/**
	 * Método que inserta un animal en la base de datos
	 * @param animal
	 * @return int
	 */
	public int createAnimal(Animal animal);
	
	/**
	 * Método que retorna un animal de la base de datos al pasarle un id
	 * @param id
	 * @return Animal
	 */
	public Animal getById(int id);
	
	/**
	 * Método que retorna un listado de animales
	 * @return List<Animal>
	 */
	public List<Animal> getAll();
	
	/**
	 * Método que actualiza un animal
	 * @param animal
	 * @return boolean
	 */
	public boolean update(Animal animal);
	
	/**
	 * Método que elimina un animal de la base de datos al pasarle un id
	 * @param id
	 * @return boolean
	 */
	public boolean delete(int id);
	
}
