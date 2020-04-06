package com.ceiba.core.dao.epica;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.core.dao.DaoEpica;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.DtoEpica;

@Component
public class DaoEpicaMysql implements DaoEpica {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    @SqlStatement(namespace="epica", value="listar")
    private String sqlListar;

    public DaoEpicaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoEpica> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEpica());
    }
}
