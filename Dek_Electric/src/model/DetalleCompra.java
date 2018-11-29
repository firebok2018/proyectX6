package model;

public class DetalleCompra {
	// Atributos
	private int num_oco, cod_pro, can_ped;
	private double pre_com;
	
	// Operaciones get y set

	public int getNum_oco() {
		return num_oco;
	}

	public int getCod_pro() {
		return cod_pro;
	}

	public int getCan_ped() {
		return can_ped;
	}

	public double getPre_com() {
		return pre_com;
	}

	public void setNum_oco(int num_oco) {
		this.num_oco = num_oco;
	}

	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}

	public void setCan_ped(int can_ped) {
		this.can_ped = can_ped;
	}

	public void setPre_com(double pre_com) {
		this.pre_com = pre_com;
	}
}
