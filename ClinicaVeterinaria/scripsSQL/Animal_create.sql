CREATE PROCEDURE clinica_veterinaria.clinica_veterinaria_animal_createAnimal(
	IN p_nombre VARCHAR(50),
	IN p_especie VARCHAR(50),
	IN p_raza VARCHAR(50),
	IN p_edad INT,
	OUT p_id INT)
BEGIN
	INSERT INTO clinica_veterinaria.animal(nombre,especie,raza,edad)
	VALUES(p_nombre,p_especie,p_raza,p_edad);
SET p_id= LAST_INSERT_ID();


END