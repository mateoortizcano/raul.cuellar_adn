package com.ceiba.core.servicio.usuario;

import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.Usuario;
import com.ceiba.core.repositorio.RepositorioUsuario;

public class ServicioCrearUsuario {

	private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

	private final RepositorioUsuario repositorioUsuario;

	public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	public Long ejecutar(Usuario usuario) {
		validarExistenciaPrevia(usuario);
		return this.repositorioUsuario.crear(usuario);
	}

	private void validarExistenciaPrevia(Usuario usuario) {
		boolean existe = this.repositorioUsuario.existe(usuario.getNombre());
		if(existe) {
			throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
		}
	}
}