package com.ceiba.core.dao.concepto;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoConcepto implements RowMapper<DtoConcepto>, MapperResult {

    @Override
    public DtoConcepto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String gerencia = resultSet.getString("gerencia");

        return new DtoConcepto(id, nombre, gerencia);
    }
}
