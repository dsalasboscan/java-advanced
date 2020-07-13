public class ClaseExtendiendo extends Thread {

  private final String description;

  public ClaseExtendiendo(String nombre, String description) {
    super(nombre);
    this.description = description;
  }

  @Override
  public void run() {
    try {
      Thread.sleep(3000);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(description + ": Este es el thread extendiendo Thread " + getName());
    }
  }
}
