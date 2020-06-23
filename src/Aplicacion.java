import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Aplicacion {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("input.txt");
		FileOutputStream fos = new FileOutputStream("output.txt");

		Lector lector = new Lector();
		ArrayList<String> cuentas = lector.leer(fis);

		guardarCuentas(fos, cuentas);

		cuentas.forEach(c -> {
			System.out.println("cuenta: " + c + "\tvalidacion: " + validar(c));
			;
		});
	}

	public static boolean validar(String cuenta) {

		if (sumaRecursiva(cuenta.length(), cuenta.toCharArray()) % 11 == 0) {
			return true;
		} else {
			return false;
		}

	}

	public static int sumaRecursiva(int n, char digitos[]) {

		if (n == 0) {
			return 0;
		} else {
			int digito = Integer.valueOf(String.valueOf(digitos[digitos.length - n]));
			return (digito * n) + sumaRecursiva(n - 1, digitos);
		}
	}

	public static void guardarCuentas(FileOutputStream fos, ArrayList<String> cuentas) {
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
