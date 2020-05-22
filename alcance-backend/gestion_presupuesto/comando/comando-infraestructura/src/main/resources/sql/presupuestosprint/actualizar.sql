update presupuesto_sprint
set
id_sprint = :idSprint,
id_concepto = :idConcepto,
horas_planeadas = :horasPlaneadas,
horas_ejecutadas = :horasEjecutadas,
valor_planeado = :valorPlaneado,
valor_ejecutado = :valorEjecutado
where id = :id