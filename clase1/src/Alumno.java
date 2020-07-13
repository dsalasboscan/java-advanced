public class Alumno implements Runnable {

  private String mensaje;

  public Alumno(String nombre) {
    mensaje = "Hola, soy " + nombre + " y este es mi mensaje";
  }

  @Override
  public void run() {
    for (int i = 1; i < 6; i++) {

      String msg = mensaje + i;

      System.out.println(msg);

    }
  }
}
