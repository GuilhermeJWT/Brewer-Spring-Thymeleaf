package br.com.systemsgs.config;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import br.com.systemgs.util.FotoStorage;

public class SalvaFotoLocal implements FotoStorage{
	
	private Path local;
	private Path localTemporario;
	
	public SalvaFotoLocal() {
		this(getDefault().getPath(System.getenv("HOME"), "brewerfotos"));
		criarPastas();
	}
	
	@Override
	public String salvarTemporariamente(MultipartFile[] files) {
		String novoNome = null;
		if(files != null && files.length>0) {
			MultipartFile arquivo = files[0];
			 novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(this.localTemporario.toAbsolutePath().toString() + getDefault().getSeparator() + novoNome));
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException("Erro ao Salvar a Foto", e);
			}
			return novoNome;
		}
		return novoNome;
	}
	
	@Override
	public byte[] recuperarFotoTemporaria(String nome) {
		try {
			return Files.readAllBytes(this.localTemporario.resolve(nome));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao ler a Foto para Exibir");
		}
	}
	
	public SalvaFotoLocal(Path path) {
		this.local = path;
		criarPastas();
	}
	
	private void criarPastas() {
		try {
			Files.createDirectories(this.local);
			this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
			Files.createDirectories(this.localTemporario);
		} catch (IOException e) {
			throw new RuntimeException("Erro ao criar a Pasta para Salvar a Foto!");
		}
	}

	private String renomearArquivo(String nomeOriginal) {
		String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;
		
		return novoNome;
	}
}
