CREATE PROCEDURE clinica_veterinaria.clinica_veterinaria_animal_getById(IN in_id INT,
OUT p_nombre VARCHAR(100),
OUT p_especie VARCHAR(100),
OUT p_raza VARCHAR(100),
OUT p_edad INT(255),
OUT p_id INT(255) ) BEGIN
SELECT
	nombre,
	especie,
	raza,
	edad,
	id
INTO
	p_nombre ,
	p_especie ,
	p_raza ,
	p_edad ,
	p_id
FROM
	clinica_veterinaria.animal

WHERE
	clinica_veterinaria.animal.id = in_id ;

END