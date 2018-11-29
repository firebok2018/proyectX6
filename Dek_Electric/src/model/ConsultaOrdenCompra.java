package model;

public class ConsultaOrdenCompra {
	private int num_oco;
	private String fec_oco,ruc_prv,rso_prv,cod_emp;
	public String getCod_emp() {
		return cod_emp;
	}
	public void setCod_emp(String cod_emp) {
		this.cod_emp = cod_emp;
	}
	public int getNum_oco() {
		return num_oco;
	}
	public void setNum_oco(int num_oco) {
		this.num_oco = num_oco;
	}
	public String getFec_oco() {
		return fec_oco;
	}
	public void setFec_oco(String fec_oco) {
		this.fec_oco = fec_oco;
	}
	public String getRuc_prv() {
		return ruc_prv;
	}
	public void setRuc_prv(String ruc_prv) {
		this.ruc_prv = ruc_prv;
	}
	public String getRso_prv() {
		return rso_prv;
	}
	public void setRso_prv(String rso_prv) {
		this.rso_prv = rso_prv;
	}
}
