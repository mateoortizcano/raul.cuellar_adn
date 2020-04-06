package com.ceiba.core.actuator;

import javax.sql.DataSource;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ceiba.core.infraestructura.actuator.DataSourceHealthIndicator;
import com.ceiba.core.infraestructura.actuator.Salud;
import com.ceiba.core.infraestructura.actuator.ManejadorHealthCheckBloques;
import com.ceiba.core.infraestructura.excepcion.ExcepcionTecnica;

@Component
public class SaludMysql implements Salud {

	private final DataSourceHealthIndicator dataSourceHealthIndicator;
	private final DataSource dataSource;
	private static final String CONSULTA_PRUEBA = "SELECT 1";
	private static final String BLOQUE_DOWN = "El bloque se encuentra DOWN";
	private final ManejadorHealthCheckBloques manejadorHealthCheckBloques;
	private static final String HEALTH_CHECK_MYSQL = "HealthCheckMysql";

	public SaludMysql(DataSourceHealthIndicator dataSourceHealthIndicator, DataSource dataSource,
			ManejadorHealthCheckBloques manejador) {
		this.dataSourceHealthIndicator = dataSourceHealthIndicator;
		this.dataSource = dataSource;
		this.manejadorHealthCheckBloques = manejador;
		this.registrarBloque();
	}

	@Override
	public void registrarBloque() {
		this.manejadorHealthCheckBloques.registrarme(HEALTH_CHECK_MYSQL, this);
	}

	@Override
	public void verificar() {
		new JdbcTemplate(this.dataSource).execute(CONSULTA_PRUEBA);
		dataSourceHealthIndicator.setDataSource(dataSource);
		dataSourceHealthIndicator.setQuery(CONSULTA_PRUEBA);
		Health health = dataSourceHealthIndicator.health();

		if (!health.getStatus().equals(Status.UP)) {
			throw new ExcepcionTecnica(BLOQUE_DOWN);
		}
	}

}
