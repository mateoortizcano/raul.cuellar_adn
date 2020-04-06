package com.ceiba.core.repositorio;

import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.epica.Epica;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEpicaMysql implements RepositorioEpica{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="epica", value="crear")
    private String sqlCrear;

    public RepositorioEpicaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Epica epica) {
        return this.customNamedParameterJdbcTemplate.crear(epica, this.sqlCrear);
    }
}
