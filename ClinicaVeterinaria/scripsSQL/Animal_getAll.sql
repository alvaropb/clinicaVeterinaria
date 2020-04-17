CREATE PROCEDURE clinica_veterinaria.clinica_veterinaria_animal_getAll()
BEGIN
	SELECT nombre,especie,raza,edad,id 
	FROM clinica_veterinaria.animal ;
END