package altomatos;
import java.util.List;

public class Main {
   public static void main(String[] args) {
      List<String> l = Identificador.listarIdentificadores2("aluno mat_a a");
      for(int i=0; i<l.size(); i++){
         System.out.println(l.get(i));
      }
   }
}