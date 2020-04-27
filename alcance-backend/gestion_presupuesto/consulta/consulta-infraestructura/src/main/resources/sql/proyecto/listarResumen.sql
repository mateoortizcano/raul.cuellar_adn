select proyecto.id, proyecto.nombre, proyecto.cliente, SUM(presupuesto.valor) AS presupuesto_global, 0 AS presupuesto_consumido
from proyecto LEFT JOIN presupuesto ON presupuesto.id_proyecto = proyecto.id
GROUP BY proyecto.id