package altomatos;

public class Tokem {
   
   private final int tipoTokem;
   private final String descTipoTookem;
   private String tokem;
   
   public static final int SE = 1;
   public static final int NUM = 2;
   public static final int COM1 = 3;
   public static final int COMN = 4;
   public static final int ID = 5;
   public static final int PR = 6;
   public static final int INV = 7;
   
   public Tokem(int tipo, String tokem){
      this.tipoTokem = tipo;
      this.descTipoTookem = getTipoTokem(tipo);
      this.tokem = tokem;
   }
   
   public String getTokem() {
      return tokem;
   }

   public void setTokem(String tokem) {
      this.tokem = tokem;
   }
   
   @Override
   public String toString(){
      return String .format("%s   (%s)", this.tokem, this.descTipoTookem);
   }
   
   private static String getTipoTokem(int tipo){
      if(tipo==1){
         return "Símbolo especial";
      }
      if(tipo==2){
         return "Número";
      }
      if(tipo==3){
         return "Comentário de uma linha";
      }
      if(tipo==4){
         return "Comentário de várias linhas";
      }
      if(tipo==5){
         return "Identificador";
      }
      if(tipo==6){
         return "Palavra reservada";
      }else{
         return "Caracter não esperado";
      }
   }
   
   
   
   public static void main(String[] args) {
      Tokem t = new Tokem(Tokem.SE, "tokem");
      System.out.println(t);
   }

   
}
