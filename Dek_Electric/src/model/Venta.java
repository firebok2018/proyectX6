package model;

public class Venta {
	// Atributos
	private int num_ven, cod_cli, cod_emp;
	private String fec_ven, est_ven,cantidad,total,des_mar,des_pro,rso_cli,ape_emp,nom_emp;
	
	public String getNom_emp() {
		return nom_emp;
	}
	public void setNom_emp(String nom_emp) {
		this.nom_emp = nom_emp;
	}
	public String getApe_emp() {
		return ape_emp;
	}
	public void setApe_emp(String ape_emp) {
		this.ape_emp = ape_emp;
	}
	public String getRso_cli() {
		return rso_cli;
	}
	public void setRso_cli(String rso_cli) {
		this.rso_cli = rso_cli;
	}
	public String getDes_pro() {
		return des_pro;
	}
	public void setDes_pro(String des_pro) {
		this.des_pro = des_pro;
	}
	public String getDes_mar() {
		return des_mar;
	}
	public void setDes_mar(String des_mar) {
		this.des_mar = des_mar;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	// Operaciones get y set
	public int getNum_ven() {
		return num_ven;
	}
	public int getCod_cli() {
		return cod_cli;
	}
	public int getCod_emp() {
		return cod_emp;
	}
	public String getFec_ven() {
		return fec_ven;
	}
	public String getEst_ven() {
		return est_ven;
	}
	public void setNum_ven(int num_ven) {
		this.num_ven = num_ven;
	}
	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}
	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}
	public void setFec_ven(String fec_ven) {
		this.fec_ven = fec_ven;
	}
	public void setEst_ven(String est_ven) {
		this.est_ven = est_ven;
	}	
}
