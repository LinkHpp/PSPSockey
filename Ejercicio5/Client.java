import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.util.Scanner;

public class Client { // se llama así pero el cliente NO tienes hilos
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host;
		try {
			System.out.println("Introduzca la dirección a conectar (ej: 192.168.10.50): ");
			host = sc.nextLine();
			Socket cliente = new Socket(host, 6000);
			DataInputStream sIn = new DataInputStream(cliente.getInputStream());

			System.out.println(sIn.readUTF());

			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			cliente.close(); // aquí sólo llegamos si escribimos "bye"
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}