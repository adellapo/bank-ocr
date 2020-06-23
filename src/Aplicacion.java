import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("input.txt");

		Lector lector = new Lector();

		ArrayList<String> cuentas = lector.leer(fis);

		cuentas.forEach(c -> {
			System.out.println("CUENTA: [" + c + "]");
		});

		cuentas.forEach(c -> chequearSuma(c));
	}

	public static void chequearSuma(String cuenta) {

		int nros[] = new int[9];
		int sumatoria = 0;

		for (int i = 0; i < cuenta.length(); i++) {
			sumatoria += (i + 1) * Character.getNumericValue(cuenta.charAt(i));
		}

		System.out
				.println(cuenta + ": SUMATORIA = " + sumatoria + " - " + (sumatoria % 11 == 0 ? "VALIDA" : "INVALIDA"));

	}

	public int calcular(int numero) {
		if (numero <= 1) {
			return 1;
		} else {

			return 0;
		}
	}
}
