package com.ceiba.core.fabrica.usuario;

import org.springframework.stereotype.Component;

import com.ceiba.core.comando.usuario.ComandoUsuario;
import com.ceiba.core.modelo.usuario.Usuario;

@Component
public class FabricaUsuario {
	
	public Usuario crear(ComandoUsuario comandoUsuario) {
	    return new Usuario(
	    	comandoUsuario.getId(),
	        comandoUsuario.getNombre(),
	        comandoUsuario.getClave(),
	        comandoUsuario.getFecha()
	    );
	}

}
