package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.Sprint;
import java.time.LocalDateTime;

public interface RepositorioSprint {

	/**
	 * Permite crear un sprint
	 * @param sprint
	 * @return el id generado
	 */
	Long crear(Sprint sprint);

	/**
	 * Permite validar si existe un sprint con un nombre
	 * @param idProyecto
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existeNombre(Long idProyecto, String nombre);

	/**
	 * Permite validar si existe un sprint con un periodo de fechas en conflicto
	 * @param idProyecto
	 * @param fechaInicial
	 * @param fechaFinal
	 * @return si existe o no
	 */
	boolean existePeriodo(Long idProyecto, LocalDateTime fechaInicial, LocalDateTime fechaFinal);

    /**
	 * Permite actualizar un sprint
	 * @param sprint
	 */
    void actualizar(Sprint sprint);

	/**
	 * Permite validar si existe un sprint con un nombre excluyendo un id
	 * @param id
	 * @param nombre
	 * @param idProyecto
	 * @return si existe o no
	 */
	boolean existeNombreExcluyendoId(Long id,String nombre, Long idProyecto);

	/**
	 * Permite validar si existe un sprint con un periodo de fechas en conflicto excluyendo un id
	 * @param id
	 * @param fechaInicial
	 * @param fechaFinal
	 * @param idProyecto
	 * @return si existe o no
	 */
	boolean existePeriodoExcluyendoId(Long id, LocalDateTime fechaInicial, LocalDateTime fechaFinal, Long idProyecto);

	/**
	 * Permite eliminar un sprint
	 * @param id
	 */
	void eliminar(Long id);
}
