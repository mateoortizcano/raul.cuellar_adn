SELECT count(*)
FROM sprint
WHERE
id <> :id AND
((:fechaInicial BETWEEN fecha_inicial AND fecha_final) OR
(:fechaFinal BETWEEN fecha_inicial AND fecha_final))