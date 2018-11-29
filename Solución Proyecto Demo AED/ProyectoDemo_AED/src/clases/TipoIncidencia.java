package clases;

public class TipoIncidencia {
	
	//  Atributos privados	
	private int codigo, estado;
	private String descripcion, abreviacion;
	//  Constructor	
	public TipoIncidencia(int codigo, String descripcion,
					      String abreviacion, int estado) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.abreviacion = abreviacion;	
		this.estado = estado;
	}
	//  Métodos de acceso público: set/get 
	public void setCodigo(int codigo) {			
		this.codigo = codigo;	    	 
	}	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;  	
	}	
    public void setAbreviacion(String abreviacion) {	    	
    	this.abreviacion = abreviacion;  	
    }	
 	public void setEstado(int estado) {	    		
 		this.estado = estado;  	
	}
	public int getCodigo() {
		return codigo;  	
	}		         
    public String getDescripcion() {	    	
    	return descripcion;
    }
    public String getAbreviacion() {     	 
    	return abreviacion;	 
    }
 	public int getEstado() {
 		return estado;
 	}
 	
}