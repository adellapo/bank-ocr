
public class Digito {

	private int MAXFILAS = 4;
	private int MAXCOLUMNAS = 3;
	private char digito[][] = new char[4][3];

	public void insertarCaracter(char caracter, int fila, int columna) {
		this.digito[fila][columna] = caracter;
	}

	public void imprimirDigito() {
		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				System.out.print(this.digito[i][j]);
			}
			System.out.println();
		}
	}

	public String decodificar() {

		String d = "";
		
		String digitoPlano = "";

		digitoPlano = String.copyValueOf(digito[0]) + String.copyValueOf(digito[1]) + String.copyValueOf(digito[2]);

		switch (digitoPlano) {
		case "     |  |":
			d = "1";
			break;
		case " _  _||_ ":
			d = "2";
			break;
		case " _  _| _|":
			d = "3";
			break;
		case "   |_|  |":
			d = "4";
			break;
		case " _ |_  _|":
			d = "5";
			break;
		case " _ |_ |_|":
			d = "6";
			break;
		case " _   |  |":
			d = "7";
			break;
		case " _ |_||_|":
			d = "8";
			break;
		case " _ |_| _|":
			d ="9";
			break;
		case " _ | ||_|":
			d = "0";
			break;
		default:
			d = "?";
		}

		return d;

	}
}
