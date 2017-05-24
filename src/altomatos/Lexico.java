package altomatos;

import java.util.ArrayList;
import java.util.List;

public class Lexico {
   private final List<Tokem> lista = new ArrayList<>();
   int estadoAtual = 0;
   private final String codFonte;
   
   private static int i;
   private static String  temp;
   private static char car;
   
   public Lexico(String str){
      this.codFonte = str;
   }
   
   
   public void analizarFonte(){
      temp = "";
      
      for1: for(i=0; i<codFonte.length(); i++){
         car = codFonte.charAt(i);
         
         switch(this.estadoAtual){
            case(0):{   
               if(car==' ' || car=='\n' || car=='\t'){
                  break;
               }
               if(car==';' || car==',' || car=='.' || car=='+' || car=='*' || car=='('
                     || car==')' || car=='=' || car=='{' || car=='}'){
                  irPara1();
                  break;
               }
               
               if(car==':' || car=='>'){
                  irPara2();
                  break;
               }
               
               if(car=='<'){
                  irPara3();
                  break;
               }
               
               if(car=='-'){
                  irPara4();
                  break;
               }
               if(Ultilit.isNumeric(car)){
                  irPara5();
                  break;
               }
               if(car=='@'){
                  irPara8();
                  break;
               }
               if(car=='/'){
                  irPara11();
                  break;
               }
               else{
                  break for1;
               }
            }
            
            case(1):{
               addReiniciar(Tokem.SE);
               break;
            }
            
            case(2):{               
               if(car=='='){
                  irPara1();
                  break;
               }
               else{
                  addReiniciar(Tokem.SE);
                  break;
               }
            }
            
            case(3):{
               if(car=='>' || car=='='){
                  irPara1();
                  break;
               }else{
                  addReiniciar(Tokem.SE);
                  break;
               }
            }
            
            case(4):{
               if(Ultilit.isNumeric(car)){
                  irPara5();
                  break;
               }else{
                  addReiniciar(Tokem.SE);
                  break;
               }
            }
            
            case(5):{
               if(Ultilit.isNumeric(car)){
                  irPara5();
                  break;
               }
               if(car==','){
                  irPara6();
                  break;
               }
               else{
                  addReiniciar(Tokem.NUM);
                  break;
               }
            }
            
            case(6):{
               if(Ultilit.isNumeric(car)){
                  irPara7();
                  break;
               }else{
                  addReiniciar2(Tokem.NUM);
                  break;
               }
            }
            
            case(7):{
               if(Ultilit.isNumeric(car)){
                  irPara7();
                  break;
               }else{
                  addReiniciar(Tokem.NUM);
                  break;
               }
            }
            
            case(8):{
               if(car=='@'){
                  irPara9();
                  break;
               }else{
                  addReiniciar(Tokem.SE);
                  break;
               }
            }
            
            case(9):{
               if(car=='\n'){
                  irPara10();
                  break;
               }else{
                  irPara9();
                  break;
               }
            }
            case(10):{
               addReiniciar(Tokem.COM1);
               break;
            }
            case(11):{
               if(car=='/'){
                  irPara12();
                  break;
               }else{
                  addReiniciar(Tokem.SE);
                  break;
               }
            }
            case(12):{
               if(car=='/'){
                  irPara13();
                  break;
               }else{
                  irPara12();
                  break;
               }
            }
            case(13):{
               if(car=='/'){
                  irPara14();
                  break;
               }else{
                  irPara12();
                  break;
               }
            }
            case(14):{
               addReiniciar(Tokem.COMN);
               break;
            }
         }
      }
   }
   
   @Override
   public String toString (){
      String t = "";
      for(Tokem lista1 : this.lista) {
         t+=lista1+"\n";
      }
      return t;
   }
   
   
   private void addReiniciar(int tipoTokem){
      lista.add(new Tokem(tipoTokem, temp));
      i--;
      temp="";
      this.estadoAtual=0;
   }
   
   private void addReiniciar2(int tipoTokem){
      lista.add(new Tokem(tipoTokem, temp.substring(0, temp.length()-1)));
      i-=2;
      temp="";
      this.estadoAtual=0;
   }
   
   private void irPara1(){
      temp += car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
         estadoAtual=1;
      }else{
         estadoAtual=1;
      }
   }
   
   private void irPara2(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
         estadoAtual=2;
      }else{
         estadoAtual=2;
      }
   }
   
   private void irPara3(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
      }else{
         estadoAtual=3;
      }
   }
   
   private void irPara4(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
         estadoAtual=4;
      }else{
         estadoAtual=4;
      }
   }
   
   private void irPara5(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.NUM, temp));
         estadoAtual=5;
      }else{
         estadoAtual=5;
      }
   }
   
   private void irPara6(){
      if(i==codFonte.length()-1){
         addReiniciar(Tokem.NUM);
      }else{
         temp+=car;
         estadoAtual=6;
      }
   }
   
   private void irPara7(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.NUM, temp));
         estadoAtual=7;
      }else{
         estadoAtual=7;
      }
   }
   
   private void irPara8(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
         estadoAtual=8;
      }else{
         estadoAtual=8;
      }
   }
   
   private void irPara9(){
      temp+=car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.COM1, temp));
         estadoAtual=9;
      }else{
         estadoAtual=9;
      }
   }
   
   private void irPara10(){
      temp += car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.COM1, temp));
         estadoAtual=10;
      }else{
         estadoAtual=10;
      }
   }
   
   private void irPara11(){
      temp += car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.SE, temp));
         estadoAtual=11;
      }else{
         estadoAtual=11;
      }
   }
   
   private void irPara12(){
      temp += car;
      if(i==codFonte.length()-1){
         System.err.println("Erro comentário");
      }else{
         estadoAtual=12;
      }
   }
   
   private void irPara13(){
      temp += car;
      if(i==codFonte.length()-1){
         System.err.println("Erro comentário");
      }else{
         estadoAtual=13;
      }
   }
   
   private void irPara14(){
      temp += car;
      if(i==codFonte.length()-1){
         this.lista.add(new Tokem(Tokem.COMN, temp));
      }else{
         estadoAtual=14;
      }
   }
   
   
}
