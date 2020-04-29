package com.ceiba.core.dao.presupuesto_sprint;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.presupuestosprint.DtoPresupuestoSprint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPresupuestoSprint implements RowMapper<DtoPresupuestoSprint>, MapperResult {

    @Override
    public DtoPresupuestoSprint mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Long idConcepto = resultSet.getLong("id_concepto");
        Long idSprint = resultSet.getLong("id_sprint");
        Double horasPlaneadas = resultSet.getDouble("horas_planeadas");
        Double horasEjecutadas = resultSet.getDouble("horas_ejecutadas");
        Double valorPlaneado = resultSet.getDouble("valor_planeado");
        Double valorEjecutado = resultSet.getDouble("valor_ejecutado");

        return new DtoPresupuestoSprint(id, idConcepto, idSprint, horasPlaneadas, horasEjecutadas, valorPlaneado, valorEjecutado);
    }
}
