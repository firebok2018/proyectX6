package interfaces;

import model.AccesoUsuario;

public interface AccesoUsuarioInterface {
	// Validar acceso
	public AccesoUsuario validar(String log, String pas);
}
