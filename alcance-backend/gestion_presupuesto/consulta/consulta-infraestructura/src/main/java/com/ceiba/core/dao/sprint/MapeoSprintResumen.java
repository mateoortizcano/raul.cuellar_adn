package com.ceiba.core.dao.sprint;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.sprint.DtoSprintResumen;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoSprintResumen implements RowMapper<DtoSprintResumen>, MapperResult {

    @Override
    public DtoSprintResumen mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        LocalDateTime fechaInicial = extraerLocalDateTime(resultSet, "fecha_inicial");
        LocalDateTime fechaFinal = extraerLocalDateTime(resultSet, "fecha_final");
        Integer diasHabiles = resultSet.getInt("dias_habiles");
        Integer numeroPersonas = resultSet.getInt("numero_personas");
        Long idProyecto = resultSet.getLong("id_proyecto");
        Double valorPlaneado = resultSet.getDouble("valorPlaneado");
        Double valorEjecutado = resultSet.getDouble("valorEjecutado");
        Double desviacion = (valorPlaneado - valorEjecutado) / valorEjecutado;

        return new DtoSprintResumen(id, nombre, fechaInicial, fechaFinal, diasHabiles,numeroPersonas,
                idProyecto, valorPlaneado, valorEjecutado, desviacion.isNaN() ? 0 : desviacion);
    }
}
