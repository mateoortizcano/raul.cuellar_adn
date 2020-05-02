package com.ceiba.core.dao.sprint;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.presupuestosprint.DtoPresupuestoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintDetalles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MapeoSprintDetalles implements RowMapper<DtoSprintDetalles>, MapperResult {

    @Override
    public DtoSprintDetalles mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        LocalDateTime fechaInicial = extraerLocalDateTime(resultSet, "fecha_inicial");
        LocalDateTime fechaFinal = extraerLocalDateTime(resultSet, "fecha_final");
        Integer diasHabiles = resultSet.getInt("dias_habiles");
        Integer numeroPersonas = resultSet.getInt("numero_personas");
        Long idProyecto = resultSet.getLong("id_proyecto");
        List<DtoPresupuestoSprint> listaPresupuestoSprint = new ArrayList<>();

        return new DtoSprintDetalles(id, nombre, fechaInicial, fechaFinal, diasHabiles,numeroPersonas,
                idProyecto, listaPresupuestoSprint);
    }
}
