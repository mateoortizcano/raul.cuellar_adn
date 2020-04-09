package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.Sprint;
import java.time.LocalDateTime;

public interface RepositorioSprint {

    /**
	 * Permite actualizar un sprint
	 * @param sprint
	 */
    void actualizar(Sprint sprint);

	/**
	 * Permite validar si existe un sprint con un nombre excluyendo un id
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existeNombreExcluyendoId(Long id,String nombre);

	/**
	 * Permite validar si existe un sprint con un periodo de fechas en conflicto excluyendo un id
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return si existe o no
	 */
	boolean existePeriodoExcluyendoId(Long id, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
