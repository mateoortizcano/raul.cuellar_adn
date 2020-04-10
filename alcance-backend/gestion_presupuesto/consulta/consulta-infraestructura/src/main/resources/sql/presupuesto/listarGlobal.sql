SELECT SUM(valor) + SUM(reserva_estabilizacion) AS valor , SUM(reserva_estabilizacion) AS reserva_estabilizacion, id_proyecto
FROM presupuesto
WHERE id_proyecto = :idProyecto
group by id_proyecto;