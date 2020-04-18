select id, nombre, fecha_inicial, fecha_final, dias_habiles, numero_personas, id_proyecto
from sprint
Where id_proyecto = :idProyecto AND
id = :id