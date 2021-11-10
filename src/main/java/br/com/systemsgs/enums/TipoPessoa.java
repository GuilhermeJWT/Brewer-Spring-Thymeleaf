package br.com.systemsgs.enums;

public enum TipoPessoa {
	
	FISICA("Física", "CPF", "000.000.000-00"),
	JURIDICA("Juridica", "CNPJ", "00.000.000/0000-00");
	
	private String descricao;
	private String documento;
	private String mascara;
	
	TipoPessoa(String descricao, String documento, String mascara){
		this.descricao = descricao;
		this.documento = descricao;
		this.mascara = mascara;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getDocumento() {
		return documento;
	}

	public String getMascara() {
		return mascara;
	}
	
}
