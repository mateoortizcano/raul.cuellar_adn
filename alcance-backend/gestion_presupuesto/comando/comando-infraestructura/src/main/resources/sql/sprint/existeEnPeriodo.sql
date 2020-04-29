SELECT count(1)
FROM sprint
WHERE
((:fechaInicial BETWEEN fecha_inicial AND fecha_final) OR
(:fechaFinal BETWEEN fecha_inicial AND fecha_final)) AND
id_proyecto = :idProyecto