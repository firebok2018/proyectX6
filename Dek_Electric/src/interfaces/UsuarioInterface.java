package interfaces;

import java.util.ArrayList;

import model.Usuario;

public interface UsuarioInterface {
	// Insertar registro de Usuario
		public int insertar(Usuario u);
		
		// Actualizar registro de Usuario
		public int actualizar(Usuario u);
		
		// Eliminar registro de Usuario
		public int eliminar(int cod);
		
		// Listar registros de Usuario
		ArrayList<Usuario> listar();
		
}
