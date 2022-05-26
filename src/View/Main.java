package View;

import java.io.IOException;

import controller.Arq;
import controller.ArqContro;

public class Main {

	public static void main(String[] args) {
 ArqContro  arqCont = new Arq();
		 String dir = "C:\\TEMP";
		 String nome = "generic_food.csv";
		 try {
			arqCont.LerFile(dir, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
