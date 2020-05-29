package com.ceiba.core.dao.proyecto;

import com.ceiba.core.dao.DaoProyecto;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.proyecto.DtoProyecto;
import com.ceiba.core.modelo.proyecto.DtoProyectoResumen;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProyectoMysql implements DaoProyecto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="proyecto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="proyecto", value="listarResumen")
    private static String sqlListarResumen;

    public DaoProyectoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProyecto> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProyecto());
    }

    @Override
    public List<DtoProyectoResumen> listarResumen() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlListarResumen, new MapeoProyectoResumen());
    }
}
