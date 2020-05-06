package com.ceiba.core.dao.concepto;

import com.ceiba.core.dao.DaoConcepto;
import com.ceiba.core.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.core.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.core.modelo.concepto.DtoConcepto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoConceptoMysql implements DaoConcepto {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="concepto", value="listar")
    private String sqlListar;

    public DaoConceptoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoConcepto> listar(Long idProyecto) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idProyecto", idProyecto);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,paramSource, new MapeoConcepto());
    }
}
