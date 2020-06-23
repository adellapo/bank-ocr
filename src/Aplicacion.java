import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Aplicacion {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("input.txt");
		FileOutputStream fos = new FileOutputStream("output.txt");

		Lector lector = new Lector();
		ArrayList<String> cuentas = lector.leer(fis);

		guardarCuentas(fos, cuentas);
		
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
	
	public static void guardarCuentas(FileOutputStream fos, ArrayList<String>cuentas) {
		try {
			
			cuentas.forEach(c -> {
				c.chars().forEach(chr -> {

					try {
						fos.write((char) chr);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				});
				
				try {
					fos.write(13);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("CUENTA: [" + c + "]");
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
