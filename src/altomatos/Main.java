package altomatos;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      List<String> l = Identificador.listarIdentificadores("mathue_a__lo123456 asa");
      for(int i=0; i<l.size(); i++){
         System.out.println(l.get(i));
      }
   }
}
