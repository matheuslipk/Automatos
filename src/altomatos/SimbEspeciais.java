package altomatos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author root
 */
public class SimbEspeciais {
   public static List<String> listarSimbEspeciais(String str){
      List<String> lista = new ArrayList<>();  
      int estadoAtual = 0;
      String temp="";
      for(int i=0; i<str.length(); i++){
         char car = str.charAt(i);
         
         switch(estadoAtual){
            case (0):{
               if(car==':'){
                  temp+=car;
                  estadoAtual=1;
                  if(i==str.length()-1)lista.add(temp);
                  break;
               }
               if(car=='<'){
                  temp+=car;
                  estadoAtual=3;
                  if(i==str.length()-1)lista.add(temp);
                  break;
               }
               if(car=='>'){
                  temp+=car;
                  estadoAtual=5;
                  if(i==str.length()-1)lista.add(temp);
                  break;
               }  
               if(car==';' || car==',' || car=='.' || car=='+' || car=='-' || car=='*'
                        || car=='/' || car=='(' || car==')' || car=='{' || car=='}' || car=='@' ){
                  temp+=car;
                  lista.add(temp);
                  if(i==str.length()-1)lista.add(temp);
                  temp="";
                  break;
               }
            }
            case(1):{
               if(car=='='){
                  temp+=car;
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  break;
               }else{
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  i--;
                  break;
               }
            }
            case(3):{
               if(car=='>' || car=='='){
                  temp+=car;
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  break;
               }else{
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  i--;
                  break;
               }
            }
            
            case(5):{
               if(car=='='){
                  temp+=car;
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  break;
               }else{
                  lista.add(temp);
                  estadoAtual=0;
                  temp="";
                  i--;
                  break;
               }
            }
            
         }
      }
      
      return lista;
   }
   
   public static boolean isSimbEspeciais(char car){
      
      if(car==';' || car==',' || car=='.' || car=='+' || car=='-' || car=='*'
            || car=='/' || car=='(' || car==')' || car=='{' || car=='}' || car=='@' 
            || car==':' || car=='<' || car=='>' || car=='=' ){
         return true;
      }
      
      else{
         return false;
      }
           
   }
   
}
