import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lector {

	private final char CHR_ESPACIO = 32;
	private final char CHR_BARRAVERTICAL = 124;
	private final char CHR_GUIONBAJO = 95;
	private final char CHR_NUEVALINEA = 10;
	private final char CHR_RETORNOCARRO = 13;

	private int iContador = 0;
	private int jContador = 0;
	private int fila = 0;
	private int columna = 0;
	private int digitoActual = 0;
	private char c;
	private Digito[] digitos = crearDigitos();
	private String cuenta = "";

	public ArrayList<String> leer(FileInputStream fis) throws IOException {

		ArrayList<String> cuentas = new ArrayList<String>();
		
		while (fis.available() > 0) {

			// leo el siguiente caracter
			c = (char) fis.read();

			// analizo el caracter
			switch (c) {

			case CHR_RETORNOCARRO:
				break;

			case CHR_NUEVALINEA:
				iContador++;
				jContador = 0;
				digitoActual = 0;
				if (iContador == 4) {
					cuenta = obtenerCuenta(digitos);
					cuentas.add(cuenta);
					nuevaCuenta();
				}
				break;

			default:
				fila = iContador;
				columna = jContador - (3 * digitoActual);
				digitos[digitoActual].insertarCaracter(c, fila, columna);
				if (columna == 2)
					digitoActual++;
				jContador++;

			}
			System.out.print((char) c);
		}
		return cuentas;

	}

	private static Digito[] crearDigitos() {
		Digito[] aux = { new Digito(), new Digito(), new Digito(), new Digito(), new Digito(), new Digito(),
				new Digito(), new Digito(), new Digito() };
		return aux;
	}

	private String obtenerCuenta(Digito[] digitos) {
		
		String cuenta = "";

		for (Digito d : digitos) {
			cuenta = cuenta + String.valueOf(d.decodificar());
		}

		return cuenta;
	}

	private void nuevaCuenta() {
		cuenta = "";
		digitos = crearDigitos();
		iContador = 0;
		jContador = 0;
		fila = 0;
		columna = 0;
		digitoActual = 0;
	}
}
