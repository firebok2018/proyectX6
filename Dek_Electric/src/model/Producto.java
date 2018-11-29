package model;

public class Producto {
	// Atributos
	private int cod_pro, cod_cat, cod_mar, sta_pro, stm_pro;
	private double pre_pro;
	private String des_pro, imp_pro, unm_pro, est_pro;
	
	// Operaciones get y set
	public int getCod_pro() {
		return cod_pro;
	}
	public int getCod_cat() {
		return cod_cat;
	}
	public int getCod_mar() {
		return cod_mar;
	}
	public int getSta_pro() {
		return sta_pro;
	}
	public int getStm_pro() {
		return stm_pro;
	}
	public double getPre_pro() {
		return pre_pro;
	}
	public String getUnm_pro() {
		return unm_pro;
	}
	public String getDes_pro() {
		return des_pro;
	}
	public String getImp_pro() {
		return imp_pro;
	}
	public String getEst_pro() {
		return est_pro;
	}
	public void setCod_pro(int cod_pro) {
		this.cod_pro = cod_pro;
	}
	public void setCod_cat(int cod_cat) {
		this.cod_cat = cod_cat;
	}
	public void setCod_mar(int cod_mar) {
		this.cod_mar = cod_mar;
	}
	public void setSta_pro(int sta_pro) {
		this.sta_pro = sta_pro;
	}
	public void setStm_pro(int stm_pro) {
		this.stm_pro = stm_pro;
	}
	public void setPre_pro(double pre_pro) {
		this.pre_pro = pre_pro;
	}
	public void setUnm_pro(String unm_pro) {
		this.unm_pro = unm_pro;
	}
	public void setDes_pro(String des_pro) {
		this.des_pro = des_pro;
	}
	public void setImp_pro(String imp_pro) {
		this.imp_pro = imp_pro;
	}
	public void setEst_pro(String est_pro) {
		this.est_pro = est_pro;
	}	
}
