
public class Cuenta {

	private String cuenta;

	public Cuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public boolean esValida() {

		if (sumaRecursiva(cuenta.length(), cuenta.toCharArray()) % 11 == 0) {
			return true;
		} else {
			return false;
		}

	}

	private int sumaRecursiva(int n, char digitos[]) {

		if (n == 0) {
			return 0;
		} else {
			int digito = Integer.valueOf(String.valueOf(digitos[digitos.length - n]));
			return (digito * n) + sumaRecursiva(n - 1, digitos);
		}
	}
}
