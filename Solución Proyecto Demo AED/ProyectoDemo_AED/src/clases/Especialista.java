package clases;

public class Especialista {
	
	//  Atributos privados
	private int codigo, estado, fechaIngreso;
	private String nombres, apellidos, especialidad, anexo;
	//  Constructor
	public Especialista(int codigo, String nombres, String apellidos, 
			            String especialidad, String anexo,
			            int fechaIngreso, int estado) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.especialidad = especialidad;
		this.anexo = anexo;
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
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
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
	public String getEspecialidad() {
		return especialidad;
	}
	public String getAnexo() {
		return anexo;
	}
	public int getFechaIngreso() {
		return fechaIngreso;
	}
	public int getEstado() {
		return estado;
	}
	
}