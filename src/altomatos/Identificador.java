package altomatos;

import java.util.ArrayList;
import java.util.List;

public class Identificador {
   
   public static List<String> listarIdentificadores(String str){
      List<String> lista = new ArrayList<>();  
      int estadoAtual = 0;
      String temp = "";
      
      for(int i=0; i<str.length(); i++){
         char caracter = (str.charAt(i));
         
         switch(estadoAtual){
            case(0):{
               if(Ultilit.isLetra(caracter)){
                  estadoAtual = 1;
                  temp+=caracter;
                  break;
               }else{
                  temp="";
                  estadoAtual = 0;
                  break;
               }
            }
            case(1):{
               if(Ultilit.isLetra(caracter) || Ultilit.isNumeric(caracter)){
                  estadoAtual = 2;
                  temp+=caracter;
                  break;
               }
               
               if(caracter=='_'){
                  estadoAtual = 3;
                  temp+=caracter;
                  break;
               }else{
                  lista.add(temp);
                  temp="";
                  estadoAtual = 0;
                  break;
               }
            }
            case(2):{
               if(Ultilit.isLetra(caracter) || Ultilit.isNumeric(caracter)){
                  estadoAtual = 2;
                  temp+=caracter;
                  break;
               }else{
                  lista.add(temp);
                  temp="";
                  estadoAtual = 0;
                  break;
               }
            }
            case(3):{
               if(Ultilit.isLetra(caracter) || Ultilit.isNumeric(caracter)){
                  estadoAtual = 2;
                  temp+=caracter;
                  break;
               }else{
                  lista.add(temp);
                  temp="";
                  estadoAtual = 0;
                  break;
               }
            }
         }
         
      }
      if (temp.length()>0) lista.add(temp);
      
      return lista;
   }
   
}
