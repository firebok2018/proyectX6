package clases;

public class Usuario {
	
	//  Atributos privados
	private int codigo, tipoID, area, fechaIngreso, estado;
	private String nombres, apellidos, numeroID,
	               correo, telefono;
	//  Constructor
	public Usuario(int codigo, String nombres, String apellidos, int tipoID, 
				   String numeroID, int area, String correo, String telefono, 
				   int fechaIngreso, int estado) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.tipoID = tipoID;
		this.numeroID = numeroID;
		this.area = area;
		this.correo	= correo;
		this.telefono = telefono;
		this.fechaIngreso = fechaIngreso;
		this.estado = estado;	
	}
	//  Métodos de acceso público: set/get 
	public void setCodigo(int codigo) {			
		this.codigo = codigo;	    	 
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}	
	public void setTipoID(int tipoID) {
		this.tipoID = tipoID;
	}	
	public void setNumeroID(String numeroID) {
		this.numeroID = numeroID;
	}	
	public void setArea(int area) {
		this.area = area;
	}	
	public void setCorreo(String correo) {
		this.correo = correo;
	}	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	public void setFechaIngreso(int fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}	
	public void setEstado(int estado) {
		this.estado = estado;
	}	
	public int getCodigo() {
		return codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public int getTipoID() {
		return tipoID;
	}
	public String getNumeroID() {
		return numeroID;
	}
	public int getArea() {
		return area;
	}
	public String getCorreo() {
		return correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public int getFechaIngreso() {
		return fechaIngreso;
	}
	public int getEstado() {
		return estado;
	}
	
}