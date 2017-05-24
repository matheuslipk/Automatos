package altomatos;

public class Main {
   public static void main(String[] args) {
      Lexico l = new Lexico("//@matheus \nara/ \n\n\nde alcantara// \n123 , 67/");
      l.analizarFonte();
      System.out.println(l);
   }
}