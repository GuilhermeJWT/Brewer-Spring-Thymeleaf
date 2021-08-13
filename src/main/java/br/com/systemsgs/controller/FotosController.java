package br.com.systemsgs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import br.com.systemsgs.config.FotoStorageRunnable;
import br.com.systemsgs.dto.FotoDTO;

@RestController
@RequestMapping(value = "/fotos")
public class FotosController {
	
	@PostMapping
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]")MultipartFile[] files) {
		DeferredResult<FotoDTO> resultado = new DeferredResult<FotoDTO>();
		
		Thread thread = new Thread(new FotoStorageRunnable(files, resultado));
		thread.start();
		
		return resultado;
	}

}
