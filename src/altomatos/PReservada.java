package altomatos;

import java.util.ArrayList;
import java.util.List;

public class PReservada {
   private static final List<String> PR = new ArrayList<>();
   
   private static void PreencherList(){
      PR.add("se");
      PR.add("ou");
      PR.add("entao");
      PR.add("para");
      PR.add("int");
      PR.add("double");
      PR.add("caracter");
      PR.add("classe");
      PR.add("faça");
      PR.add("publico");
      PR.add("privado");
      PR.add("string");
      PR.add("estatico");
      PR.add("senao");
      PR.add("main");
   }
   
   public static List<String> getPR(){
      PreencherList();
      return PR;
   }
}
