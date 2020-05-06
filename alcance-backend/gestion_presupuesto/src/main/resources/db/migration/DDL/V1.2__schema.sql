ALTER TABLE presupuesto_sprint ADD UNIQUE( id_sprint, id_concepto);
ALTER TABLE concepto ADD tiempo_completo BOOLEAN NULL DEFAULT FALSE AFTER gerencia;