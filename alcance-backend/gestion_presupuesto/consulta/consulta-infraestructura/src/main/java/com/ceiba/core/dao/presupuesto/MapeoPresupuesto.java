package com.ceiba.core.dao.presupuesto;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.presupuesto.DtoPresupuesto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPresupuesto implements RowMapper<DtoPresupuesto>, MapperResult {

    @Override
    public DtoPresupuesto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        Double valor = resultSet.getDouble("valor");
        Double reservaEstabilizacion = resultSet.getDouble("reserva_estabilizacion");
        String observaciones = resultSet.getString("observaciones");
        Long idProyecto = resultSet.getLong("id_proyecto");

        return new DtoPresupuesto(id, valor, reservaEstabilizacion, observaciones, idProyecto);
    }
}
