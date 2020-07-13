public class MainClass {

  public static void main(String[] args) {
    probarThreadExtension();
    probarThreadImplementacion();
    probarPreemptiveMethod();
  }

  private static void probarThreadExtension() {
    ClaseExtendiendo claseExtendiendo1 = new ClaseExtendiendo("Thread1", "T1");
    ClaseExtendiendo claseExtendiendo2 = new ClaseExtendiendo("Thread2", "T2");

    claseExtendiendo1.start();
    claseExtendiendo2.start();


    try {
      claseExtendiendo1.join();
      claseExtendiendo2.join();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

    System.out.println("TERMINO, uso join asi que esto se imprime despues de terminados los threads");
  }

  private static void probarThreadImplementacion() {
    ClaseImplementandoRunnable claseImplementandoRunnable1 = new ClaseImplementandoRunnable("T1", "Runnable1");
    ClaseImplementandoRunnable claseImplementandoRunnable2 = new ClaseImplementandoRunnable("T2", "Runnable2");

    Thread thread1 = new Thread(claseImplementandoRunnable1);
    thread1.start();

    Thread thread2 = new Thread(claseImplementandoRunnable2);
    thread2.start();

    System.out.println("Finalizo");

  }

  private static void probarPreemptiveMethod() {
    Thread juan = new Thread (new Alumno("Juan"));

    Thread pepe = new Thread (new Alumno ("Pepe"));

    Thread andres = new Thread (new Alumno ("Andres"));

    juan.start();

    pepe.start();

    andres.start();
  }
}
