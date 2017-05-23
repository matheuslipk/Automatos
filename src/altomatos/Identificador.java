package altomatos;

import java.util.ArrayList;
import java.util.List;

public class Identificador {
   
   public static List<String> listarIdentificadores2(String str){
      List<String> lista = new ArrayList<>();  
      int estadoAtual = 0;
      String temp = "";
         
      for1:for(int i=0; i<str.length(); i++){
         char car = (str.charAt(i));

         switch(estadoAtual){
            case(0):{
               if(Ultilit.isLetra(car)){
                  estadoAtual = 1;
                  temp+=car;
                  break;
               }else{
                  break for1;
               }
            }
            case(1):{
               if(Ultilit.isLetra(car) || Ultilit.isNumeric(car)){
                  estadoAtual = 2;
                  temp+=car;
                  break;
               }
               if(car=='_'){
                  estadoAtual = 3;
                  temp+=car;
                  break;
               }
               if(car==' '){
                  lista.add(temp);
                  temp="";
                  estadoAtual=0;
                  break;
               }else{
                  break for1;
               }
            }
            case(2):{
               if(Ultilit.isLetra(car) || Ultilit.isNumeric(car)){
                  estadoAtual = 2;
                  temp+=car;
                  break;
               }
               if(car==' '){
                  lista.add(temp);
                  temp="";
                  estadoAtual=0;
                  break;
               }
               else{
                  break for1;
               }
            }
            case(3):{
               if(Ultilit.isLetra(car) || Ultilit.isNumeric(car)){
                  estadoAtual = 2;
                  temp+=car;
                  break;
               }else{
                  break for1;
               }
            }
         }

      }
      
      return lista;
   }
   
}
