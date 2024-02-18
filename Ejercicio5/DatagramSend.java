import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSend {
  public static void main(String[] args) {
    try {
      System.out.println("Creando socket datagram");
      DatagramSocket datagramSocket = new DatagramSocket();

      System.out.println("Enviando mensaje");
      String mensaje = "mensaje desde el emisor";

      InetAddress addr = InetAddress.getByName("localhost");
      DatagramPacket datagram = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);
      datagramSocket.send(datagram);
      System.out.println("Mensaje Enviado");

      

    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
