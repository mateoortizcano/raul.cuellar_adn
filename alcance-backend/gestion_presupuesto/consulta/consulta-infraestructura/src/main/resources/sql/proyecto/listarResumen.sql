SELECT py.id, py.nombre, py.cliente, SUM(pr.valor) AS presupuesto_global, presupuesto_consumido AS presupuesto_consumido
FROM (SELECT s.id_proyecto, SUM(ps.valor_ejecutado) AS presupuesto_consumido FROM presupuesto_sprint ps LEFT JOIN sprint s ON s.id = ps.id_sprint GROUP BY s.id_proyecto) t
RIGHT JOIN proyecto py ON t.id_proyecto = py.id
LEFT JOIN presupuesto pr ON pr.id_proyecto = py.id
GROUP BY py.id