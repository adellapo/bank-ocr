
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

	public int decodificar() {

		int nro = 0;
		String digitoPlano = "";

		digitoPlano = String.copyValueOf(digito[0]) + String.copyValueOf(digito[1]) + String.copyValueOf(digito[2]);

		switch (digitoPlano) {
		case "     |  |":
			nro = 1;
			break;
		case " _  _||_ ":
			nro = 2;
			break;
		case " _  _| _|":
			nro = 3;
			break;
		case "   |_|  |":
			nro = 4;
			break;
		case " _ |_  _|":
			nro = 5;
			break;
		case " _ |_ |_|":
			nro = 6;
			break;
		case " _   |  |":
			nro = 7;
			break;
		case " _ |_||_|":
			nro = 8;
			break;
		case " _ |_| _|":
			nro =9;
			break;
		case " _ | ||_|":
			nro = 0;
			break;
		default:
			nro = -1;
		}

		return nro;

	}
}
