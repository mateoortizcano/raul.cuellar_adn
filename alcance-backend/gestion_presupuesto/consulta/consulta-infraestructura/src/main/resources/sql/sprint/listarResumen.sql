SELECT
sprint.*,
SUM(presupuesto_sprint.valor_planeado) AS "valorPlaneado",
SUM(presupuesto_sprint.valor_ejecutado) AS "valorEjecutado"
FROM sprint LEFT JOIN presupuesto_sprint ON presupuesto_sprint.id_sprint = sprint.id
WHERE id_proyecto = :idProyecto
GROUP BY sprint.id
ORDER BY sprint.fecha_inicial DESC