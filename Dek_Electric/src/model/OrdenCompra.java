package model;

public class OrdenCompra {
	// Atributos
	private int num_oco, cod_prv, cod_tra, cod_emp;
	private String fec_oco;
	
	// Operaciones get y set
	public int getNum_oco() {
		return num_oco;
	}
	public int getCod_prv() {
		return cod_prv;
	}
	public int getCod_tra() {
		return cod_tra;
	}
	public int getCod_emp() {
		return cod_emp;
	}
	public String getFec_oco() {
		return fec_oco;
	}
	public void setNum_oco(int num_oco) {
		this.num_oco = num_oco;
	}
	public void setCod_prv(int cod_prv) {
		this.cod_prv = cod_prv;
	}
	public void setCod_tra(int cod_tra) {
		this.cod_tra = cod_tra;
	}
	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}
	public void setFec_oco(String fec_oco) {
		this.fec_oco = fec_oco;
	}	
}
