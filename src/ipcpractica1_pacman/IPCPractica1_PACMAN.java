/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipcpractica1_pacman;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author wendi
 */
public class IPCPractica1_PACMAN {

    /**
     * @param args the command line arguments
     */
   String nombre,trampa,icono,fila6,ic;
   
   int tamaño1,tamaño2,comida,paredes,columna,fila,iconos;
   
   int f=0,c=0;
   char[][]matriz;
    Scanner sn = new Scanner(System.in);
    Random random=new Random();
    Scanner da=new Scanner(System.in);
           boolean salir = false;
    public static void main(String[] args) {
      IPCPractica1_PACMAN practica=new IPCPractica1_PACMAN();
        practica.Menú();
       // practica.matriz();
    }
      public  void IniciarJuego(){
         
        System.out.println("Ingrese nombre de jugador");
   nombre=da.next();
        System.out.println("Indique tamaño de tablero");
        tamaño1=Integer.parseInt(da.next());
        tamaño2=Integer.parseInt(da.next());
//        System.out.println("Indique cantidad de comida");
//         comida= Integer.parseInt(da.next());
//        System.out.println("Indique cantidad de paredes");
//          paredes=Integer.parseInt(da.next());
//        System.out.println("Indique cantidad de trampas");
//          trampa=da.next();
//        System.out.println("Elija icono");
//          icono=da.next();
iconos();
        System.out.print("Seleccione un ICONO"+" "+nombre+"\n");
        iconos=Integer.parseInt(da.next());
         switch (iconos) {
                    case 1:
                       ic="¶";
                        break;
                    case 2:
                         ic="¥";
                        break;
                    case 3:
                        ic="¤";
                        break;
                    case 4:
                         ic="♥";
                        break;
                    case 5:
                        ic="♦";
                        break;
                        case 6:
                       ic="♣";
                        break;
                    case 7:
                         ic="♠";
                        break;
                    case 8:
                       ic="†";
                        break;
                        case 9:
                         ic="֎";
                        break;
                    case 10:
                        ic="֏";
                        break;
                    default:
                        System.out.println("No ha seleccionado ningún icono disponible");

                }
         matriz(tamaño1,tamaño2,comida,paredes,nombre);

          
    }
     public  void Menú(){
         

       int opcion; //Guardaremos la opcion del usuario
        
       while(!salir){
            System.out.println("PACMAN - IPC 1 - 2022"+"\n"+"---------------------");
           System.out.println("1. Iniciar Juego");
           System.out.println("2. Tabla de posiciones");
           System.out.println("3. Salir"+"\n"+"---------------------");
            
           try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        IniciarJuego();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                
            }
                     
        }
     }
     public void matriz(int a,int b,int comid,int pared,String nombre){   
         char[]simbolos={'@','#','?','X',' '};
matriz=new char[a][b];

for( f=0;f<a ;f++){
    System.out.print("|");
    for( c=0;c<b;c++){
        matriz[f][c]=simbolos[(int)(Math.random()*5)];
        System.out.print(" " +matriz[f][c]); 
    } 
         System.out.print("|");
         System.out.println();  
}

 
    System.out.println("Indicar Movimiento");
        columna=Integer.parseInt(da.next());
        fila=Integer.parseInt(da.next());
        for( f=0;f<a ;f++){
    System.out.print("|");
    for( c=0;c<b;c++){
        matriz[columna][fila]=ic.charAt(0);
        System.out.print(" " +matriz[f][c]); 
    } 
         System.out.print("|");
         System.out.println();    
    }
            movimiento(matriz,nombre);      
     }
     public void movimiento(char [][]matriz,String nombre){
                   String Respuesta="";
              int d=0,iz=0;
          int puntos=0;
          int vida=3;
          char com='@';
   
 do{
        System.out.println("Posición");
        fila6=da.next();
        matriz[fila+iz][columna+d]=' ';
          if(fila6.equalsIgnoreCase("6")||fila6.equalsIgnoreCase("d")){
              if(matriz[fila+iz][columna+d+1]=='@'||matriz[fila+iz][columna+d+1]=='?'||matriz[fila+iz][columna+d+1]=='X'||matriz[fila+iz][columna+d+1]==' '){
              if(matriz[fila+iz][columna+d+1]=='@'){
                    puntos=puntos+5;
                }if(matriz[fila+iz][columna+d+1]=='?'){
                    puntos=puntos+10;
                }if(matriz[fila+iz][columna+d+1]=='X'){
                    vida=vida-1;
                }
                 matriz[fila+iz][columna+d+1]=ic.charAt(0);
                  d++;
              }else if(matriz[fila+iz][columna+d+1]=='#'){
                  System.out.print("No puede avanzar");

              }
               
  
          }
          if(fila6.equalsIgnoreCase("4")||fila6.equalsIgnoreCase("a")){
                if(matriz[fila+iz][columna+d-1]=='@'||matriz[fila+iz][columna+d-1]=='?'||matriz[fila+iz][columna+d-1]=='X'||matriz[fila+iz][columna+d-1]==' '){
              if(matriz[fila+iz][columna+d-1]=='@'){
                    puntos=puntos+5;
                }if(matriz[fila+iz][columna+d-1]=='?'){
                    puntos=puntos+10;
                }if(matriz[fila+iz][columna+d-1]=='X'){
                    vida=vida-1;
                }
            matriz[fila+iz][columna+d-1]=ic.charAt(0);
            d--;
                }else if(matriz[fila+iz][columna+d-1]=='#'){
                  System.out.print("No puede avanzar");
                   }
              
          }
            
          if(fila6.equalsIgnoreCase("8")||fila6.equalsIgnoreCase("w")){
               if(matriz[fila+iz-1][columna+d]=='@'||matriz[fila+iz-1][columna+d]=='?'||matriz[fila+iz-1][columna+d]=='X'||matriz[fila+iz-1][columna+d]==' '){
              if(matriz[fila+iz-1][columna+d]=='@'){
                    puntos=puntos+5;
                }if(matriz[fila+iz-1][columna+d]=='?'){
                    puntos=puntos+10;
                }if(matriz[fila+iz-1][columna+d]=='X'){
                    vida=vida-1;
                }
            matriz[fila+iz-1][columna+d]=ic.charAt(0);
            iz--;
               }else if(matriz[fila+iz-1][columna+d]=='#'){
                  System.out.print("No puede avanzar");
              }
            
          }
          if(fila6.equalsIgnoreCase("2")||fila6.equalsIgnoreCase("x")){
               if(matriz[columna+iz+1][fila+d]=='@'||matriz[columna+iz+1][fila+d]=='?'||matriz[columna+iz+1][fila+d]=='X'||matriz[columna+iz+1][fila+d]==' '){
              if(matriz[columna+iz+1][fila+d]=='@'){
                    puntos=puntos+5;
                }if(matriz[columna+iz+1][fila+d]=='?'){
                    puntos=puntos+10;
                }if(matriz[columna+iz+1][fila+d]=='X'){
                   vida=vida-1;
                }
              matriz[columna+iz+1][fila+d]=ic.charAt(0);
              iz++;
               }else if(matriz[fila+iz+1][columna+d]=='#'){
                  System.out.print("No puede avanzar");
              }
              
                      }
           if(fila6.equalsIgnoreCase("m")){
               System.out.println("PAUSA");
           }

             System.out.println("Jugador"+" "+nombre+" "+"Puntos"+" "+puntos+" "+"Vidas"+" "+vida);
           for( f=0;f<matriz.length;f++){
              System.out.print("|");
              for( c=0;c<matriz[0].length;c++){
                  System.out.print(" " +matriz[f][c]);  
              }
                System.out.print("|");
         System.out.println();    
          } 
          
           }while(vida>=0);
          
  System.out.println("Jugador"+" "+nombre+" "+"Vidas"+" "+vida+" "+"YA NO PUEDE SEGUIR JUGANDO");
     }
 public void iconos(){
     System.out.println("-----------");
          System.out.println("1.---¶"+"\n"+"2.---¥"+"\n"+"3.---¤"+"\n"+"4.---♥"+"\n"+"5.---♦"+"\n"+"6.---♣"+"\n"+"7.---♠"+"\n"+"8.---†"+"\n"+"9.---֎"+"\n"+"10.---֏");
System.out.println("-----------");
 }
}
