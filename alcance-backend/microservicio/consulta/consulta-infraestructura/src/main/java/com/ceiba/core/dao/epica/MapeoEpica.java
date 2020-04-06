package com.ceiba.core.dao.epica;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoEpica;

public class MapeoEpica implements RowMapper<DtoEpica>,MapperResult {
    @Override
    public DtoEpica mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer id = resultSet.getInt("id");
        String titulo = resultSet.getString("titulo");
        Integer estimacion_comercial = resultSet.getInt("estimacion_comercial");

        return new DtoEpica(id,titulo,estimacion_comercial);
    }
}
