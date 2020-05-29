package com.ceiba.core.dao.sprint;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.sprint.DtoSprint;
import com.ceiba.core.modelo.sprint.DtoSprintDetalles;
import com.ceiba.core.modelo.sprint.DtoSprintJoinPresupuestos;
import com.ceiba.core.modelo.sprint.DtoSprintResumen;
import com.ceiba.core.traductor.SprintJoinPresupuestos;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSprintMysql implements DaoSprint {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="sprint", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = "sprint", value = "consultar")
    private static String sqlConsultar;

    @SqlStatement(namespace="sprint", value="listarResumen")
    private static String sqlListarResumen;

    @SqlStatement(namespace="sprint", value="listarDetalles")
    private static String sqlListarDetalles;

    public DaoSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    private static final String PARAM_ID_PROYECTO = "idProyecto";

    @Override
    public List<DtoSprint> listar(Long idProyecto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, paramSource, new MapeoSprint());
    }

    @Override
    public DtoSprint consultar(Long idProyecto, Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);
        paramSource.addValue("id", id);

        List<DtoSprint> resultados = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlConsultar, paramSource, new MapeoSprint());

        return resultados.get(0);
    }

    @Override
    public List<DtoSprintResumen> listarResumen(Long idProyecto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue(PARAM_ID_PROYECTO, idProyecto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarResumen, paramSource, new MapeoSprintResumen());
    }

    @Override
    public DtoSprintDetalles listarDetalles(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        List<DtoSprintJoinPresupuestos> resultados = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarDetalles, paramSource, new MapeoSprintJoinPresupuestos());

        return SprintJoinPresupuestos.toSprintDetalles(resultados);
    }
}
