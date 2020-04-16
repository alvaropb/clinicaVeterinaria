CREATE PROCEDURE clinica_veterinaria.clinica_veterinaria_animal_updateAnimal( IN p_nombre VARCHAR(50),
IN p_especie VARCHAR(50),
IN p_raza VARCHAR(50),
IN p_edad INT,
IN p_id INT,
OUT p_ok BOOL)
BEGIN
UPDATE
	clinica_veterinaria.animal a
SET
	a.nombre = p_nombre ,
	a.especie = p_especie ,
	a.raza = p_raza ,
	a.edad = p_edad
WHERE
	a.id = p_id ;
SET p_ok=TRUE;


END