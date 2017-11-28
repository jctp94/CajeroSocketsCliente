import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainCliente {

	public static void main(String[] args) throws Exception {
		ConexCliente concliente = new ConexCliente();
		BufferedReader teclado;
		teclado = new BufferedReader(new InputStreamReader(System.in));
		String msg = "";
		// concliente.registrarUsuario(2);
		while (true) {
			System.out.println("Bienvenido");
			System.out.println("Digita 1 para crear una cuenta");
			System.out.println("Digita 2 para iniciar sesión");
			System.out.println("Digita 3 para hacer una consignación");
			try {
				int eleccion = Integer.parseInt(teclado.readLine());
				if (eleccion != 1 && eleccion != 2 && eleccion != 3) {
					throw new Exception("Seleccione un valor valido");
				}
				switch (eleccion) {
				case 1:
					msg = concliente.conectarServidor(1, "");
					if (!msg.equals("no")) {
						System.out.println(msg);
					} else {
						System.out.println("No se puede registrar el usuario");
					}
					break;
				case 2:
					msg = concliente.conectarServidor(3, "");
					if (!msg.equals("no")) {
						System.out.println(msg);
						String usu = msg.split(" ")[0];
						System.out.println("Digite 1 para hacer un retiro");
						System.out.println("Digite 2 para cambiar contraseña");
						System.out.println("Digite 3 para salir");
						eleccion = Integer.parseInt(teclado.readLine());
						if (eleccion == 1) {
							msg = concliente.conectarServidor(4, usu);
							if (!msg.equals("no")) {
								System.out.println("Retiro realizado con exito, nuevo saldo: " + msg);
							} else {
								System.out.println("No posees este monto para retirar");
							}
						} else if(eleccion == 2) {
							msg = concliente.conectarServidor(6, usu);
							System.out.println(msg);
						}else if (eleccion == 3) {
							break;
						}
					} else {
						System.out.println("Usuario no encontrado");
					}
					break;
				case 3:
					msg = concliente.conectarServidor(5, "");
					if (!msg.equals("no")) {
						System.out.println(msg);
					} else {
						System.out.println("Usuario no encontrado");
					}
					break;
				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}

	}

}
