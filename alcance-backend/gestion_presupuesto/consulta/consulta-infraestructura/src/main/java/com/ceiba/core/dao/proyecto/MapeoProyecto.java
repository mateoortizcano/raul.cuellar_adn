package com.ceiba.core.dao.proyecto;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoProyecto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProyecto implements RowMapper<DtoProyecto>, MapperResult {

    @Override
    public DtoProyecto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String cliente = resultSet.getString("cliente");

        return new DtoProyecto(id, nombre, cliente);
    }
}
