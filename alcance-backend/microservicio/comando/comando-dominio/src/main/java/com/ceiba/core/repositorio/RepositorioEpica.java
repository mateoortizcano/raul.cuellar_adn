package com.ceiba.core.repositorio;

import com.ceiba.core.modelo.epica.Epica;

public interface RepositorioEpica {
    /**
     * Permite crear un usuario
     * @param epica
     * @return el id generado
     */
    Long crear(Epica epica);
}
