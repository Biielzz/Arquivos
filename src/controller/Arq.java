package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Arq implements ArqContro{

	public Arq() {
		super();
		
	}

	@Override
	public void Ler(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
		 File[] files = dir.listFiles();
		 for ( File f : files) {
			 if (f.isFile()) {
				 System.out.println("       \t"+f.getName());
				
			 } else {
				 System.out.println("<DIR>\t"+f.getName());
			 }
		 }
	} else {
	throw new IOException ("Diretório inválido");
	}
	}

	@Override
	public void CriarFile(String path, String nome) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				
			}
			String conteudo = geraTxt();
			FileWriter fileW =  new FileWriter(arq, existe);
			PrintWriter print = new PrintWriter (fileW);
			print.write(conteudo);
			print.flush();
			print.close();
			fileW.close();
		}else {
			throw new IOException ("Diretório Inválido");
		}
	} 

	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = "";
		while(!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase",
			"Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			if (!linha.equalsIgnoreCase("Fim")) {
			buffer.append(linha + "\n");
			
		}
		
	}
		return buffer.toString();
	}

	@Override
	public void LerFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
			
		}
		
	}

	@Override
	public void Abrir(String path, String nome) throws IOException {
		
		
	}


	
}
