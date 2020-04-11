package com.ceiba.core.dao.sprint;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoSprint;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoSprint implements RowMapper<DtoSprint>, MapperResult {

    @Override
    public DtoSprint mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        LocalDateTime fechaInicial = extraerLocalDateTime(resultSet, "fecha_inicial");
        LocalDateTime fechaFinal = extraerLocalDateTime(resultSet, "fecha_final");
        Integer diasHabiles = resultSet.getInt("dias_habiles");
        Integer numeroPersonas = resultSet.getInt("numero_personas");
        Long idProyecto = resultSet.getLong("id_proyecto");

        return new DtoSprint(id, nombre, fechaInicial, fechaFinal, diasHabiles,numeroPersonas, idProyecto);
    }
}
