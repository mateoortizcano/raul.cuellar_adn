package com.ceiba.core.dao.sprint;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.sprint.DtoSprintJoinPresupuestos;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoSprintJoinPresupuestos implements RowMapper<DtoSprintJoinPresupuestos>, MapperResult {

    @Override
    public DtoSprintJoinPresupuestos mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long idSprint = resultSet.getLong("idSprint");
        String nombre = resultSet.getString("nombre");
        LocalDateTime fechaInicial = extraerLocalDateTime(resultSet, "fecha_inicial");
        LocalDateTime fechaFinal = extraerLocalDateTime(resultSet, "fecha_final");
        Integer diasHabiles = resultSet.getInt("dias_habiles");
        Integer numeroPersonas = resultSet.getInt("numero_personas");
        Long idProyecto = resultSet.getLong("id_proyecto");
        Long idPresupuesto = resultSet.getLong("idPresupuesto");
        Long idConcepto = resultSet.getLong("id_concepto");
        Double horasPlaneadas = resultSet.getDouble("horas_planeadas");
        Double horasEjecutadas = resultSet.getDouble("horas_ejecutadas");
        Double valorPlaneado = resultSet.getDouble("valor_planeado");
        Double valorEjecutado = resultSet.getDouble("valor_ejecutado");

        return new DtoSprintJoinPresupuestos(
                idSprint, nombre, fechaInicial, fechaFinal, diasHabiles, numeroPersonas,
                idProyecto, idPresupuesto, idConcepto,
                horasPlaneadas, horasEjecutadas, valorPlaneado, valorEjecutado);
    }
}
