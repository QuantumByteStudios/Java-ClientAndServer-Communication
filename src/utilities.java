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

  static boolean askUserYN() {
    Scanner sc = new Scanner(System.in);
    String userInput;
    System.out.print("Please Enter Your Choice (Y or N): ");
    userInput = sc.nextLine();

    if (userInput.length() > 1) {
      System.out.println("Error: Enter a valid input!");
    } else {
      char ip = userInput.charAt(0);
      if (ip == 'Y' || ip == 'y') {
        return true;
      } else if (ip == 'N' || ip == 'n') {
        return false;
      } else {
        System.out.println("Error: Enter a valid input!");
      }
    }
    return false;
  }

}