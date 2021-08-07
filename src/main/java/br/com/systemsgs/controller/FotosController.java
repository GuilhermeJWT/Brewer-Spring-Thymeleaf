package br.com.systemsgs.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/fotos")
public class FotosController {
	
	@PostMapping
	public DeferredResult<String> upload(@RequestParam("files[]")MultipartFile[] files) {
		DeferredResult<String> resultado = new DeferredResult<String>();
		resultado.setResult("Foto Recebida!");
		
		System.out.println(files[0].getSize());
		return resultado;
	}

}
