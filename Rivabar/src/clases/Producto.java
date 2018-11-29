package clases;

public class Producto {
	private int codigo;
	private String nombre;
	private String tipo;
	private int stock;
	private double precio_vaso,precio_botella;
	public Producto(int codigo, String nombre, String tipo, int stock, double precio_vaso, double precio_botella) {
		
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo = tipo;
		this.stock = stock;
		this.precio_vaso = precio_vaso;
		this.precio_botella = precio_botella;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio_vaso() {
		return precio_vaso;
	}
	public void setPrecio_vaso(double precio_vaso) {
		this.precio_vaso = precio_vaso;
	}
	public double getPrecio_botella() {
		return precio_botella;
	}
	public void setPrecio_botella(double precio_botella) {
		this.precio_botella = precio_botella;
	}
	
	
}
