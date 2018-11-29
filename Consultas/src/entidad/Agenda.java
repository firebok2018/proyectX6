package entidad;

public class Agenda {
	
	private int idagenda;
	private String apellidos;
	private String nombres;
	private String direccion;
	private int edad;
	private String fechaNacimiento;
	
	public Agenda() {}
	
	public Agenda(String apellidos,
			String nombres,String direccion, 
			int edad,String fechaNacimiento) {
		
		this.apellidos=apellidos;
		this.nombres=nombres;
		this.direccion=direccion;
		this.edad=edad;
		this.fechaNacimiento=fechaNacimiento;
		
	}

	public int getIdagenda() {
		return idagenda;
	}

	public void setIdagenda(int idagenda) {
		this.idagenda = idagenda;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	

}
