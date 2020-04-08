update sprint
set nombre = :nombre,
	fecha_inicial = :fechaInicial,
	fecha_final = :fechaFinal,
	dias_habiles = :diasHabiles,
	numero_personas = :numeroPersonas,
	id_proyecto = :idProyecto
where id = :id