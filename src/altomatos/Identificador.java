package altomatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Identificador {
   
   public static List<String> listarIdentificadores(String str){
      List<String> lista = new ArrayList<>();  
      int estadoAtual = 0;
      String temp = "";
      Scanner texto = new Scanner(str);
      
      while(texto.hasNext()){
         String str2 = texto.next();
         sairfor: for(int i=0; i<str2.length(); i++){
            char caracter = (str2.charAt(i));

            switch(estadoAtual){
               case(0):{
                  if(Ultilit.isLetra(caracter)){
                     estadoAtual = 1;
                     temp+=caracter;
                     break;
                  }else{
                     temp="";
                     estadoAtual = 0;
                     break sairfor;
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
                  }
                  temp="";
                  break sairfor;
               }
               case(2):{
                  if(Ultilit.isLetra(caracter) || Ultilit.isNumeric(caracter)){
                     estadoAtual = 2;
                     temp+=caracter;
                     break;
                  }
                  temp="";
                  break sairfor;
               }
               case(3):{
                  if(Ultilit.isLetra(caracter) || Ultilit.isNumeric(caracter)){
                     estadoAtual = 2;
                     temp+=caracter;
                     break;
                  }
                  temp="";
                  break sairfor;
               }
            }
            
         }
         
         if (temp.length()>0) lista.add(temp);
         temp="";
      }
      return lista;
   }
   
}
