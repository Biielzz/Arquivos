package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;





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
	public void LerFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			System.out.println("FOOD NAME \t SCIENTIFIC NAME \t SUB GROUP");
			while (linha != null) {
			//	System.out.println(linha);
				linha = buffer.readLine();
				String[] Virg = linha.split(",");
				System.out.println(Virg[0]+"\t" +Virg[1]+"\t"+ Virg[3]);
			}
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
			
		}
		
	}
}
