
public class Digito {

	int MAXFILAS = 4;
	int MAXCOLUMNAS = 3;
	char digito[][] = new char[4][3];

	public Digito() {
		// TODO Auto-generated constructor stub
	}

	public Digito(String line) {
		// TODO Auto-generated constructor stub
	}

	public void insertarCaracter(char caracter, int x, int y) {
		this.digito[x][y] = caracter == ' ' ? '.' : caracter;
	}

	public void imprimirDigito() {
		for (int i = 0; i < MAXFILAS; i++) {
			for (int j = 0; j < MAXCOLUMNAS; j++) {
				System.out.print((this.digito[i][j] == 0 ? '.' : this.digito[i][j] ));
			}
			System.out.println();
		}
	}
}
