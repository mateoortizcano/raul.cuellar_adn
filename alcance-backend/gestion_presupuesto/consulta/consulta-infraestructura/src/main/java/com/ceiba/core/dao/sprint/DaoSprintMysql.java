package com.ceiba.core.dao.sprint;

import com.ceiba.core.dao.DaoSprint;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoSprint;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoSprintMysql implements DaoSprint {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="sprint", value="listar")
    private String sqlListar;

    @SqlStatement(namespace = "sprint", value = "consultar")
    private String sqlConsultar;

    public DaoSprintMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoSprint> listar(Long idProyecto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProyecto", idProyecto);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListar, paramSource, new MapeoSprint());
    }

    @Override
    public DtoSprint consultar(Long idProyecto, Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProyecto", idProyecto);
        paramSource.addValue("id", id);

        List<DtoSprint> resultados = this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlConsultar, paramSource, new MapeoSprint());

        return resultados.get(0);
    }
}
