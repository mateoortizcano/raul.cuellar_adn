package com.ceiba.core.dao.proyecto;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoProyectoResumen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProyectoResumen implements RowMapper<DtoProyectoResumen>,MapperResult {
    @Override
    public DtoProyectoResumen mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String cliente = resultSet.getString("cliente");
        Double presupuestoGlobal = resultSet.getDouble("presupuesto_global");
        Double presupuestoConsumido = resultSet.getDouble("presupuesto_consumido");

        return new DtoProyectoResumen(id,nombre,cliente, presupuestoGlobal, presupuestoConsumido);
    }
}
