import java.net.*;
import java.io.*;
import java.util.*;

public class Client {
  // initialize socket and input output streams
  private Socket socket = null;
  private DataOutputStream out = null;
  private InputStreamReader r = new InputStreamReader(System.in);
  private BufferedReader br = new BufferedReader(r);

  // constructor to put ip address and port
  public Client(String address, int port) {

    beautification clientBeautification = new beautification();
    ConsoleColors clientConsoleColors = new ConsoleColors();

    // establish a connection
    try {
      socket = new Socket(address, port);
      clientBeautification
          .delayTextEffect(
              clientConsoleColors.GREEN + "Connected IP: " + address + "Port: " + port + clientConsoleColors.RESET
                  + "\n");

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
        line = br.readLine();
        out.writeUTF(line);
      } catch (IOException e) {
        System.out.println(e.getMessage());
      } catch (NullPointerException i) {
        System.out.println(i.getMessage());
      }
    }

    // close the connection
    try {
      br.close();
      out.close();
      socket.close();
    } catch (IOException i) {
      System.out.println(i);
    }
  }

  public static void main(String args[]) {

    String ipAddress = args[0];
    int portNumber = Integer.parseInt(args[1]);
    // Creating Basic Objects
    utilities serverInstance = new utilities();
    // Objects End

    // Initial Methods Invoke
    serverInstance.clear();
    // Initial Methods Invoke End

    // Client Object Creation
    Client client = new Client(ipAddress, portNumber);
  }
}
