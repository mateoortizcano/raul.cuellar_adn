package com.ceiba.core.servicio.epica;

import com.ceiba.core.modelo.epica.Epica;
import com.ceiba.core.repositorio.RepositorioEpica;

public class ServicioCrearEpica {
    private final RepositorioEpica repositorioEpica;

    public ServicioCrearEpica(RepositorioEpica repositorioEpica) {
        this.repositorioEpica = repositorioEpica;
    }

    public Long ejecutar(Epica epica){
        return this.repositorioEpica.crear(epica);
    }
}
