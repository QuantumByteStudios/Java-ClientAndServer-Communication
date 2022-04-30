import java.net.*;
import java.io.*;

public class Client {
  // initialize socket and input output streams
  private Socket socket = null;
  private DataInputStream input = null;
  private DataOutputStream out = null;

  // constructor to put ip address and port
  public Client(String address, int port) {

    beautification clientBeautification = new beautification();
    ConsoleColors clientConsoleColors = new ConsoleColors();

    // establish a connection
    try {
      socket = new Socket(address, port);
      clientBeautification.delayTextEffect(clientConsoleColors.GREEN + "Connected" + clientConsoleColors.RESET + "\n");

      // takes input from terminal
      input = new DataInputStream(System.in);

      // sends output to the socket
      out = new DataOutputStream(socket.getOutputStream());
    } catch (UnknownHostException u) {
      System.out.println(u);
    } catch (IOException i) {
      System.out.println(i);
    }

    // string to read message from input
    String line = "";

    // keep reading until "Over" is input
    while (!line.equals("/exit")) {
      try {
        System.out.print("Enter Message: ");
        line = input.readLine();
        out.writeUTF(line);
      } catch (IOException i) {
        System.out.println(i);
      }
    }

    // close the connection
    try {
      input.close();
      out.close();
      socket.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String args[]) {

    // Creating Basic Objects
    utilities serverInstance = new utilities();
    // Objects End

    // Initial Methods Invoke
    serverInstance.clear();
    // Initial Methods Invoke End

    // Client Object Creation
    Client client = new Client("localhost", 5000);
  }
}
