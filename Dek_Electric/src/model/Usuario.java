package model;

public class Usuario {
	// Atributos
	private int cod_usu, cod_emp;
	private String log_usu, pas_usu;
	
	// Operaciones get y set
	public int getCod_usu() {
		return cod_usu;
	}
	public int getCod_emp() {
		return cod_emp;
	}
	public String getLog_usu() {
		return log_usu;
	}
	public String getPas_usu() {
		return pas_usu;
	}
	public void setCod_usu(int cod_usu) {
		this.cod_usu = cod_usu;
	}
	public void setCod_emp(int cod_emp) {
		this.cod_emp = cod_emp;
	}
	public void setLog_usu(String log_usu) {
		this.log_usu = log_usu;
	}
	public void setPas_usu(String pas_usu) {
		this.pas_usu = pas_usu;
	}
}
