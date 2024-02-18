import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Datagram2{
  public static void main(String[] args) {
    try {
      System.out.println("Creando socket datagram");
      InetSocketAddress addr = new InetSocketAddress("localhost", 5556);
      DatagramSocket datagramSocket = new DatagramSocket(addr);

      /*System.out.println("Recibiendo mensaje");
      byte[] mensaje = new byte[25];
      DatagramPacket datagrama1 = new DatagramPacket(mensaje, 25);
      datagramSocket.receive(datagrama1);
      System.out.println("Mensaje Recibido: " + new String(mensaje));*/
      


      String mensaje = "token";

      System.out.println("Enviando Mensaje");
      InetAddress addr2 = InetAddress.getByName("localhost");
      DatagramPacket datagrama2 = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr2, 5555);
      datagramSocket.send(datagrama2);
      System.out.println("Mensaje Enviado");
    
      byte[] mensaje2 = new byte[25];
      DatagramPacket datagrama1;

      while(true){
        System.out.println("Recibiendo mensaje");
        datagrama1 = new DatagramPacket(mensaje2, 25);
        datagramSocket.receive(datagrama1);
        System.out.println("Mensaje Recibido: " + new String(mensaje2));

        if(new String(mensaje2).contains("recibido")){
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
