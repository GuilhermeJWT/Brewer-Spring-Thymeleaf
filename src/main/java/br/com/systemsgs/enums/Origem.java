package br.com.systemsgs.enums;

public enum Origem {
	
	NACIONAL("Nacional"),
	INTERNACIONAL("Internacional");
	
	private String descricao;
	
	private Origem(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
