SELECT id, id_sprint, id_concepto, horas_planeadas, horas_ejecutadas, valor_planeado, valor_ejecutado
FROM presupuesto_sprint
WHERE id_sprint = :idSprint