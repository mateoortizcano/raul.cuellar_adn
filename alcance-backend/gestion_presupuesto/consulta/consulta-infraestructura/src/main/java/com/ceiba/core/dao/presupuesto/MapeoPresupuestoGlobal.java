package com.ceiba.core.dao.presupuesto;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoPresupuestoGlobal;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPresupuestoGlobal implements RowMapper<DtoPresupuestoGlobal>, MapperResult {

    @Override
    public DtoPresupuestoGlobal mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Double valor = resultSet.getDouble("valor");
        Double reservaEstabilizacion = resultSet.getDouble("reserva_estabilizacion");
        Long idProyecto = resultSet.getLong("id_proyecto");

        return new DtoPresupuestoGlobal(valor, reservaEstabilizacion, idProyecto);
    }
}
