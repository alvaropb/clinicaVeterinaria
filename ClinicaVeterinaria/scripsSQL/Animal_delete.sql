CREATE PROCEDURE clinica_veterinaria.clinica_veterinaria_animal_deleteAnimal(IN p_id INT,
OUT p_ok BOOL) BEGIN
DELETE
FROM
	clinica_veterinaria.animal 
WHERE
	id = p_id ;

SET
p_ok = TRUE;

END