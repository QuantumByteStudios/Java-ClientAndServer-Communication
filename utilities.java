import java.io.*;
import java.util.Scanner;

public class utilities {

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

  public static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }

}