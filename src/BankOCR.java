import java.util.ArrayList;

public class BankOCR {

	public static void main(String args[]) {

		/*
		 * clases: - Ruta - Archivo - Digito - id - descifrar
		 */

		// inicio

		// mientras no haya ruta
		// pido ruta
		// chequeo ruta
		// si excedo la cantidad de veces termino el programa

		// proceso
		// defino MAXFILA, MAXCOLUMNA, fila, columna
		// defino arrDigitos, va tener 9 digitos, cada digito mat 4x3
		// abro archivo a partir de la ruta
		// mientras fila<MAXFILA
		// mientras columna<MAXCOLUMNA

		// fin

		char fila1[] = "._.._.._....._.._.._.._....".toCharArray();
		char fila2[] = "|.|._|._||_||_.|_...||_|..|".toCharArray();
		char fila3[] = "|_||_.._|..|._||_|..||_|..|".toCharArray();
		char fila4[] = "...........................".toCharArray();
		int MAXFILAS = 4;
		int MAXCOLUMNAS = 27;
		int digitoActual = 0;
		int contador = 0;
		char fila[] = null;

		Digito digito = new Digito();

		ArrayList<Digito> digitosList = new ArrayList<>();

		// 1er digito
		digitosList.add(new Digito());
		// 2do digito
		digitosList.add(new Digito());
		// 3er digito
		digitosList.add(new Digito());
		// 4to digito
		digitosList.add(new Digito());
		// 5to digito
		digitosList.add(new Digito());
		// 6to digito
		digitosList.add(new Digito());
		// 7mo digito
		digitosList.add(new Digito());
		// 8vo digito
		digitosList.add(new Digito());
		// 9no digito
		digitosList.add(new Digito());

		for (int i = 0; i < MAXFILAS; i++) {

			switch (i) {
			case 0:
				fila = fila1;
				break;
			case 1:
				fila = fila2;
				break;
			case 2:
				fila = fila3;
				break;
			case 3:
				fila = fila4;
				break;
			}

			for (int j = 0; j < MAXCOLUMNAS; j++) {

				if (contador == 3) {
					contador = 0;
					digitosList.remove(digitoActual);
					digitosList.add(digitoActual, digito);
					System.out.println("-------------------\ndigito: " + digitoActual);
					digitoActual++;
					digito.imprimirDigito();
					digito = digitosList.get(digitoActual);
				}

				digito.insertarCaracter(fila[j], i, j - (3 * digitoActual));
				contador++;

			}

			System.out.println(".............................");
			digitoActual = 0;
			contador = 0;
		}

		System.out.println("Cantidad de elementos: " + digitosList.size() + "\n==============");

		for(Object d : digitosList.toArray()) {
			((Digito)d).imprimirDigito();
		}
	}
}
