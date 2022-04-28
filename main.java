import java.io.*;

// Main Class
public class main {
  public static void main(String[] args) {

    // Creating Basic Objects
    systemUtilities currentInstance = new systemUtilities();
    // Objects End

    // Initial Methods Invoke
    currentInstance.clear();
    // Initial Methods Invoke End

    System.out.println("Java Console Chat App");
  }
}

class systemUtilities {

  public static void clear() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {
    }
  }

  public static void systemInvoke(String command) {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", command).inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec(command);
    } catch (IOException | InterruptedException ex) {
    }
  }

}