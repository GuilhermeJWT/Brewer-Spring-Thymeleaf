package br.com.systemsgs.config;

import static java.nio.file.FileSystems.getDefault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

import br.com.systemgs.util.FotoStorage;

public class SalvaFotoLocal implements FotoStorage{
	
	private Path local;
	private Path localTemporario;
	
	public SalvaFotoLocal() {
		this(getDefault().getPath(System.getenv("HOME"), "brewerfotos"));
		criarPastas();
	}
	
	public SalvaFotoLocal(Path path) {
		this.local = path;
		criarPastas();
	}
	
	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "tem");
			Files.createDirectories(this.localTemporario);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao criar a Pasta para Salvar a Foto!");
		}
	}

	@Override
	public void salvarTemporariamente(MultipartFile[] files) {
		System.out.println("Salvando temporariamente");
	}
	
}
