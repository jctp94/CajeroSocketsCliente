import java.net.*;

import java.io.*;

/**
 *
 * 
 * 
 * @author Jorge V
 * 
 */

public class ConexCliente {

	final String HOST = "localhost";

	final int PUERTO = 2018;

	Socket cliente;

	BufferedReader entrada1, teclado;
	PrintStream salida;

	DataOutputStream mensaje;

	// Cliente

	public String conectarServidor(int eleccion, String u) /* ejecuta este metodo para correr el cliente */

	{

		try

		{

			cliente = new Socket(HOST, PUERTO); /* conectar a un servidor en localhost con puerto 5000 */
			teclado = new BufferedReader(new InputStreamReader(System.in));
			entrada1 = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new PrintStream(cliente.getOutputStream());
//			mensaje = new DataOutputStream(cliente.getOutputStream());
			String tec, msg="";
			switch (eleccion) {
			//Case 1 crear nueva cuenta
			case 1:
				salida.println(1);
				System.out.println("Por favor digita tu usuario");
				tec = teclado.readLine();
				salida.println(tec);
				System.out.println("Por favor digita tu clave");
				tec = teclado.readLine();
				salida.println(tec);
				System.out.println("Digita tipo de cuenta de ahorros o corriente");
				tec = teclado.readLine();
				salida.println(tec);
				System.out.println("Digita el saldo inicial de la cuenta");
				tec = teclado.readLine();
				salida.println(tec);
				msg = entrada1.readLine();
				break;
			// Consultar un usuario
			case 2:
				salida.println(2);
				System.out.println("Por favor confirma la contraseña");
				tec = teclado.readLine();
				salida.println(u +" "+ tec);
				msg = entrada1.readLine();
				if (msg.equals("no")) {
					msg = "El usuario no existe";
				}
			// Iniciar sesión
			case 3:
				salida.println(3);
				System.out.println("Por favor digita el usuario");
				tec = teclado.readLine();
				salida.println(tec);
				System.out.println("Por favor digita la contraseña");
				tec = teclado.readLine();
				salida.println(tec);
				msg = entrada1.readLine();
				break;
			//Hacer un retirof
			case 4:
				salida.println(4);
				System.out.println("Por favor digita el monto a retirar");
				tec = teclado.readLine();
				salida.println(u+ " "+tec);
				msg = entrada1.readLine();
				break;
			//Hacer una consignacion
			case 5:
				salida.println(5);
				System.out.println("Por favor digita el usuario de la cuenta a la que desea consignar");
				tec = teclado.readLine();
				salida.println(tec);
				System.out.println("Por favor digita el monto a consignar");
				tec = teclado.readLine();
				salida.println(tec);
				msg = entrada1.readLine();
				break;
			//Cambiar contraseña
			case 6:
				salida.println(6);
				System.out.println("Por favor digita la nueva contraseña");
				tec = teclado.readLine();
				salida.println(u+ " "+tec);
				msg = entrada1.readLine();
				break;
			default:
				break;
			}
			entrada1.close();
			salida.close();
			cliente.close();
			return msg;
		} catch (Exception e)

		{
			
			return "Errorcli: " + e.getMessage();

		}

	}

}