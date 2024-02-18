import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
	Socket cliente;
	int numcliente;

	public Server(Socket s, int numcliente) {
		cliente = s;
		this.numcliente = numcliente;
	}

	@Override
	public void run() {
		try (DataInputStream sIn = new DataInputStream(cliente.getInputStream())) {
			DataOutputStream sOut = new DataOutputStream(cliente.getOutputStream());
			try {

				sOut.writeUTF("Eres el cliente numero " + numcliente);

			} catch (IOException e) {
				System.out.println("Conexion Cerrada");
			} finally { // aquí realizamos todos los cierres, de flujos y del socket cliente
				try {
					if (sIn != null)
						sIn.close();
				} catch (IOException ex) {
				}
				try {
					if (sOut != null)
						sOut.close();
				} catch (IOException ex) {
				}
				try {
					if (cliente != null)
						cliente.close();
				} catch (IOException ex) {
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int ncliente = 0;
		try {
			ServerSocket servidor = new ServerSocket(6000);
			while (true) {
				Socket sCliente = servidor.accept();
				System.out.println("Conexión establecida, atendiendo cliente...");
				ncliente++;
				Server servidorhilo = new Server(sCliente, ncliente);
				servidorhilo.start();
				System.out.println("Clientes: " + ncliente);
				System.out.println("Cliente " + ncliente + " direccion IP: " + sCliente.getInetAddress());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}