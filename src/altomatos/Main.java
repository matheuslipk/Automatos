package altomatos;

public class Main {
   public static void main(String[] args) {
      Lexico l = new Lexico("se a_a1@@@# matheus");
      l.analizarFonte();
      System.out.println(l);
   }
}