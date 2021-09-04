package br.com.systemgs.util;

import org.springframework.web.multipart.MultipartFile;

public interface FotoStorage {
	
	public String salvarTemporariamente(MultipartFile[] files);

	public byte[] recuperarFotoTemporaria(String nome);

}
