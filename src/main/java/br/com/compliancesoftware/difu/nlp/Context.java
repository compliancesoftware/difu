package br.com.compliancesoftware.difu.nlp;

public class Context {
	private boolean temCumprimento = false;
	private boolean temNovidades = false;
	private boolean temImovel = false;
	private boolean temConstrutora = false;
	private boolean querSaberMeuNome = false;
	private boolean disseONome = false;
	private boolean querSaberPraQueSirvo = false;
	
	private String nome = "";
	private String telefone = "";
	private String email = "";
	
	public boolean isTemCumprimento() {
		return temCumprimento;
	}
	public void setTemCumprimento(boolean temCumprimento) {
		this.temCumprimento = temCumprimento;
	}
	public boolean isTemNovidades() {
		return temNovidades;
	}
	public void setTemNovidades(boolean temNovidades) {
		this.temNovidades = temNovidades;
	}
	public boolean isTemImovel() {
		return temImovel;
	}
	public void setTemImovel(boolean temImovel) {
		this.temImovel = temImovel;
	}
	public boolean isTemConstrutora() {
		return temConstrutora;
	}
	public void setTemConstrutora(boolean temConstrutora) {
		this.temConstrutora = temConstrutora;
	}
	public boolean isQuerSaberMeuNome() {
		return querSaberMeuNome;
	}
	public void setQuerSaberMeuNome(boolean querSaberMeuNome) {
		this.querSaberMeuNome = querSaberMeuNome;
	}
	public boolean isDisseONome() {
		return disseONome;
	}
	public void setDisseONome(boolean disseONome) {
		this.disseONome = disseONome;
	}
	public boolean isQuerSaberPraQueSirvo() {
		return querSaberPraQueSirvo;
	}
	public void setQuerSaberPraQueSirvo(boolean querSaberPraQueSirvo) {
		this.querSaberPraQueSirvo = querSaberPraQueSirvo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
