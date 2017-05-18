package altomatos;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      List<String> l = Identificador.listarIdentificadores("ab1ab a_a asa1");
      for(int i=0; i<l.size(); i++){
         System.out.println(l.get(i));
      }
      
      
      
   }
}