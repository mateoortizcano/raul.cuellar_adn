select c.id, c.nombre, c.gerencia, c.tiempo_completo, t.valor AS tarifa
from concepto AS c JOIN tarifa AS t ON c.id = t.id_concepto
Where t.id_proyecto = :idProyecto AND
:fechaInicial BETWEEN t.vigencia_inicial AND t.vigencia_final