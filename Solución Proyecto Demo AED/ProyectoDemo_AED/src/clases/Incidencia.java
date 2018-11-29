package clases;

public class Incidencia {
	
	//  Atributos privados
	private int codigo, codigoUsuario, codigoEspecialista, codigoTipoIncidencia, 
	            tiempoEstimadoSolucion, tiempoRealSolucion, fechaRegistro,
	            fechaInicioAtencion, fechaFinAtencion, estado;
	private String descripcion, comentario;
	//  Constructor
	public Incidencia(int codigo, int codigoUsuario, int codigoEspecialista, int codigoTipoIncidencia,
					  String descripcion, String comentario, int tiempoEstimadoSolucion, 
					  int tiempoRealSolucion, int fechaRegistro, int fechaInicioAtencion, 
					  int fechaFinAtencion, int estado) {
		this.codigo = codigo;
		this.codigoUsuario = codigoUsuario;
		this.codigoEspecialista = codigoEspecialista;
		this.codigoTipoIncidencia = codigoTipoIncidencia;
		this.descripcion = descripcion;
		this.comentario = comentario;
		this.tiempoEstimadoSolucion = tiempoEstimadoSolucion;
		this.tiempoRealSolucion = tiempoRealSolucion;
		this.fechaRegistro = fechaRegistro;
		this.fechaInicioAtencion = fechaInicioAtencion;
		this.fechaFinAtencion = fechaFinAtencion;
		this.estado = estado;
	}
	//  Métodos de acceso público: set/get	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public void setCodigoEspecialista(int codigoEspecialista) {
		this.codigoEspecialista = codigoEspecialista;
	}
	public void setCodigoTipoIncidencia(int codigoTipoIncidencia) {
		this.codigoTipoIncidencia = codigoTipoIncidencia;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public void setTiempoEstimadoSolucion(int tiempoEstimadoSolucion) {
		this.tiempoEstimadoSolucion = tiempoEstimadoSolucion;
	}
	public void setTiempoRealSolucion(int tiempoRealSolucion) {
		this.tiempoRealSolucion = tiempoRealSolucion;
	}
	public void setFechaRegistro(int fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public void setFechaInicioAtencion(int fechaInicioAtencion) {
		this.fechaInicioAtencion = fechaInicioAtencion;
	}
	public void setFechaFinAtencion(int fechaFinAtencion) {
		this.fechaFinAtencion = fechaFinAtencion;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCodigo() {
		return codigo;
	}
	public int getCodigoUsuario() {
		return codigoUsuario;
	}
	public int getCodigoEspecialista() {
		return codigoEspecialista;
	}	
	public int getCodigoTipoIncidencia() {
		return codigoTipoIncidencia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public String getComentario() {
		return comentario;
	}
	public int getTiempoEstimadoSolucion() {
		return tiempoEstimadoSolucion;
	}	
	public int getTiempoRealSolucion() {
		return tiempoRealSolucion;
	}	
	public int getFechaRegistro() {
		return fechaRegistro;
	}
	public int getFechaInicioAtencion() {
		return fechaInicioAtencion;
	}
	public int getFechaFinAtencion() {
		return fechaFinAtencion;
	}
	public int getEstado() {
		return estado;
	}
	
}