package altomatos;

public class Ultilit {
   public static boolean isNumeric(char a){
      String c = Character.toString(a);
      return c.charAt(0)>=48 && c.charAt(0)<=57;         
   }
   
   public static boolean isLetra(char a){
      String c = Character.toString(a);
      
      if(c.charAt(0)>=65 && c.charAt(0)<=90){
         return true;
      }
      return c.charAt(0)>=97 && c.charAt(0)<=122;         
   }
   
   public static boolean isVazio(char a){
      return a=='\n' || a=='\t' || a==' ';
   }
}
