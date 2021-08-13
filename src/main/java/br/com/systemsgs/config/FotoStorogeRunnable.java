package br.com.systemsgs.config;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorogeRunnable implements Runnable {
	
	private MultipartFile[] files;
	private DeferredResult<String> resultado;

	public FotoStorogeRunnable(MultipartFile[] files, DeferredResult<String> resultado) {
		this.files = files;
		this.resultado = resultado;
	}

	@Override
	public void run() {
		System.out.println("CAIU AQUI");
		System.out.println(files[0].getSize());
		
		resultado.setResult("OK! Foto Recebida!");
	}

}
