import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;
import java.io.File;
import java.util.Scanner;

public class Server{
	public static void main(String[] args){
		try{
			System.out.println("Creando socket servidor");
			ServerSocket serverSocket = new ServerSocket();
			System.out.println("Realizando el bind");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			serverSocket.bind(addr);

			System.out.println("Aceptando conexiones");
			Socket newSocket = serverSocket.accept();
			System.out.println("Conexion recibida");

			InputStream is = newSocket.getInputStream();
			OutputStream os = newSocket.getOutputStream();
			//byte[] mensaje = new byte[25];
			String mensaje;
			Scanner input = new Scanner(System.in);

			File file = new File("Mensaje");
			input = new Scanner(file);
			input.useDelimiter("\\Z");
			//System.out.println(input.next());

			mensaje = input.next();

			os.write(mensaje.getBytes());
			//is.read(mensaje);
			//System.out.println("Mensaje recibido: " + new String(mensaje));

			System.out.println("Cerrando el nuevo socket");
			newSocket.close();

			System.out.println("Cerrando el socket servidor");
			serverSocket.close();

			System.out.println("Terminado");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
