SELECT
s.id AS "idSprint",
s.nombre,
s.fecha_inicial,
s.fecha_final,
s.dias_habiles,
s.numero_personas,
s.id_proyecto,
ps.id AS "idPresupuesto",
ps.id_concepto,
ps.horas_planeadas,
ps.horas_ejecutadas,
ps.valor_planeado,
ps.valor_ejecutado
FROM sprint AS s LEFT JOIN presupuesto_sprint AS ps ON ps.id_sprint = s.id
Where s.id = :id