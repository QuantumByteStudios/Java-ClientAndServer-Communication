public class beautification {
  public static void delayTextEffect(String text) {
    for (int i = 0; i < text.length(); i++) {
      char printIt = text.charAt(i);
      System.out.print(printIt);
      utilities.sleep(50);
    }
  }
}
