package altomatos;

import java.util.ArrayList;
import java.util.List;

public class PReservada {
   private static final List<String> PR = new ArrayList<>();
   
   private static void PreencherList(){
      PR.add("programa");
      PR.add("se");
      PR.add("entao");
      PR.add("senao");
      PR.add("enquanto");
      PR.add("faca");
      PR.add("ate");
      PR.add("repita");
      PR.add("inteiro");
      PR.add("real");
      PR.add("caractere");
      PR.add("case");
      PR.add("escolha");
      PR.add("fim");
      PR.add("procedimento");
      PR.add("funcao");
      PR.add("de");
      PR.add("para");
      PR.add("inicio");
   }
   
   public static List<String> getPR(){
      PreencherList();
      return PR;
   }
}
