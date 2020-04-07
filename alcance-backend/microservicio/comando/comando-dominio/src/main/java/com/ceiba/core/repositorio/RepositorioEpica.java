package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.Epica;

public interface RepositorioEpica {
    /**
     * Permite crear un epica
     * @param epica
     * @return el id generado
     */
    Long crear(Epica epica);
}
