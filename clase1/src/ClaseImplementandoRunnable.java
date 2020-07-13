public class ClaseImplementandoRunnable implements Runnable {

  private final String description;
  private final String name;

  public ClaseImplementandoRunnable(String description, String name) {
    this.description = description;
    this.name = name;
  }

  @Override
  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(description + ": Este es el thread implementando runnable " + getName());
    }
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }
}
