package clases;

public class BoxMesa {
	private int numeroMesa,numeroBox,estado;
	int sona;
	public BoxMesa(int numeroMesa, int numeroBox, int estado, int sona) {
		
		this.numeroMesa = numeroMesa;
		this.numeroBox = numeroBox;
		this.estado = estado;
		this.sona = sona;
	}
	public int getNumeroMesa() {
		return numeroMesa;
	}
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	public int getNumeroBox() {
		return numeroBox;
	}
	public void setNumeroBox(int numeroBox) {
		this.numeroBox = numeroBox;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getSona() {
		return sona;
	}
	public void setSona(int sona) {
		this.sona = sona;
	}
	
}
