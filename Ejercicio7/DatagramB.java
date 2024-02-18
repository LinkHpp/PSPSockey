import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Datagram{
  public static void main(String[] args) {
    try {
      System.out.println("Creando socket datagram");
      InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
      DatagramSocket datagramSocket = new DatagramSocket(addr);

      System.out.println("Recibiendo mensaje");
      byte[] mensaje = new byte[25];
      DatagramPacket datagrama1 = new DatagramPacket(mensaje, 25);

      while(true){

        datagramSocket.receive(datagrama1);



        if(new String(mensaje).contains("token")){
          System.out.println("Mensaje Recibido: " + new String(mensaje));
      
          System.out.println("Enviando Mensaje");
      
          String mensaje2 = "recibido";

          InetAddress addr2 = InetAddress.getByName("localhost");
          DatagramPacket datagrama2 = new DatagramPacket(mensaje2.getBytes(), mensaje2.getBytes().length, addr2, 5556);
          datagramSocket.send(datagrama2);
          System.out.println("Mensaje Enviado");
          System.out.println("Cerrando el socket datagrama");


          datagramSocket.close();
          System.out.println("Terminado");
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
