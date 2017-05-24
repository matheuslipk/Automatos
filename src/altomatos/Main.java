package altomatos;

public class Main {
   public static void main(String[] args) {
      Lexico l = new Lexico("//@matheus ara/ de alcantara//");
      l.analizarFonte();
      System.out.println(l);
   }
}