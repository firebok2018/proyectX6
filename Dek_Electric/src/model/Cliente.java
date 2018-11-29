package model;

public class Cliente {
	// Atributos
	private int cod_cli, cod_dis;
	private String rsn_cli, rdn_cli,dir_cli,tel_cli, ema_cli,tip_cli ;
	
	// Operaciones get y set
	public int getCod_cli() {
		return cod_cli;
	}
	public int getCod_dis() {
		return cod_dis;
	}
	public String getRsn_cli() {
		return rsn_cli;
	}
	public String getRdn_cli() {
		return rdn_cli;
	}
	public String getDir_cli() {
		return dir_cli;
	}
	public String getTel_cli() {
		return tel_cli;
	}
	public String getEma_cli() {
		return ema_cli;
	}
	public String getTip_cli() {
		return tip_cli;
	}
	public void setCod_cli(int cod_cli) {
		this.cod_cli = cod_cli;
	}
	public void setCod_dis(int cod_dis) {
		this.cod_dis = cod_dis;
	}
	public void setRsn_cli(String rsn_cli) {
		this.rsn_cli = rsn_cli;
	}
	public void setRdn_cli(String rdn_cli) {
		this.rdn_cli = rdn_cli;
	}
	public void setDir_cli(String dir_cli) {
		this.dir_cli = dir_cli;
	}
	public void setTel_cli(String tel_cli) {
		this.tel_cli = tel_cli;
	}
	public void setEma_cli(String ema_cli) {
		this.ema_cli = ema_cli;
	}
	public void setTip_cli(String tip_cli) {
		this.tip_cli = tip_cli;
	}	
}
