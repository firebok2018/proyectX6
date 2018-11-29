package model;

public class CuentaBancaria {
	// Atributos
	private int cod_cue, cod_prv;
	private String nro_cue, ban_cue, tip_cue;
	
	// Operaciones get y set
	public int getCod_cue() {
		return cod_cue;
	}
	public int getCod_prv() {
		return cod_prv;
	}
	public String getNro_cue() {
		return nro_cue;
	}
	public String getBan_cue() {
		return ban_cue;
	}
	public String getTip_cue() {
		return tip_cue;
	}
	public void setCod_cue(int cod_cue) {
		this.cod_cue = cod_cue;
	}
	public void setCod_prv(int cod_prv) {
		this.cod_prv = cod_prv;
	}
	public void setNro_cue(String nro_cue) {
		this.nro_cue = nro_cue;
	}
	public void setBan_cue(String ban_cue) {
		this.ban_cue = ban_cue;
	}
	public void setTip_cue(String tip_cue) {
		this.tip_cue = tip_cue;
	}	
}
