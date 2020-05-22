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
c.nombre AS "nombreConcepto",
t.valor AS "tarifaConcepto",
c.tiempo_completo AS "tiempoCompletoConcepto",
ps.horas_planeadas,
ps.horas_ejecutadas,
ps.valor_planeado,
ps.valor_ejecutado
FROM (sprint AS s LEFT JOIN presupuesto_sprint AS ps ON ps.id_sprint = s.id
LEFT JOIN concepto AS c ON ps.id_concepto = c.id)
LEFT JOIN tarifa AS t ON (ps.id_concepto = t.id_concepto AND t.id_proyecto = s.id_proyecto AND
s.fecha_inicial BETWEEN t.vigencia_inicial AND t.vigencia_final)
Where
s.id = :id