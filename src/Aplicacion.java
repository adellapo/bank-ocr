import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Aplicacion {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("input.txt");
		FileOutputStream fos = new FileOutputStream("output.txt");

		Lector lector = new Lector();
		ArrayList<Cuenta> cuentas = lector.leerCuentas(fis);

		guardarCuentas(fos, cuentas);

//		cuentas.forEach(c -> {
//			System.out.println("cuenta: " + c.getCuenta() + "\tvalidacion: " + c.esValida());
//			;
//		});

	}

	public static void guardarCuentas(FileOutputStream fos, ArrayList<Cuenta> cuentas) throws IOException {

		try {

			cuentas.forEach(c -> {

				// concateno el nro de cuenta con su validacion
				(c.getCuenta() + c.esValida()).chars().forEach(chr -> {

					try {

						fos.write((char) chr);

					} catch (IOException e) {
						e.printStackTrace();
					}

				});

				try {

					// salto de linea
					fos.write(13);

				} catch (IOException e) {
					e.printStackTrace();
				}

			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
