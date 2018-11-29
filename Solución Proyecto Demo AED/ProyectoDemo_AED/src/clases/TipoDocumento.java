package clases;

public class TipoDocumento {
	
	//  Atributos privados	
	private int codigo, estado;
	private String descripcion, abreviacion;
	//  Constructor	
	public TipoDocumento(int codigo, String descripcion,
					     String abreviacion, int estado) {
		this.codigo = codigo;
		this.estado = estado;
		this.descripcion = descripcion;
		this.abreviacion = abreviacion;		 		   
	}
	//  Métodos de acceso público: set/get 
	public void setCodigo(int codigo) {			
		this.codigo = codigo;	    	 
	}	
 	public void setEstado(int estado) {	    		
 		this.estado = estado;  	
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;  	
	}	
    public void setAbreviacion(String abreviacion) {	    	
    	this.abreviacion = abreviacion;  	
    }	
	public int getCodigo() {
		return codigo;  	
	}
 	public int getEstado() {
 		return estado;
 	}		         
    public String getDescripcion() {	    	
    	return descripcion;
    }
    public String getAbreviacion() {     	 
    	return abreviacion;	 
    }  
    
}