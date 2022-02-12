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
   String nombre,trampa,icono;
   int tamaño1,tamaño2,comida,paredes,columna,fila,fila6;
    Scanner sn = new Scanner(System.in);
    Random random=new Random();
    Scanner da=new Scanner(System.in);
    public static void main(String[] args) {
      IPCPractica1 practica=new IPCPractica1();
        practica.Menú();
       // practica.matriz();
    }
      public  void IniciarJuego(){
         
        System.out.println("Ingrese nombre de jugador");
   nombre=da.next();
        System.out.println("Indique tamaño de tablero");
        tamaño1=Integer.parseInt(da.next());
        tamaño2=Integer.parseInt(da.next());
        System.out.println("Indique cantidad de comida");
         comida= Integer.parseInt(da.next());
        System.out.println("Indique cantidad de paredes");
          paredes=Integer.parseInt(da.next());
//        System.out.println("Indique cantidad de trampas");
//          trampa=da.next();
//        System.out.println("Elija icono");
//          icono=da.next();
        System.out.print("Jugador"+" "+nombre+"\n");
         matriz(tamaño1,tamaño2,comida,paredes);
         

          
    }
     public  void Menú(){
         
       boolean salir = false;
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
     public void matriz(int a,int b,int comid,int pared){   
         char[]simbolos={'@','#','?','X',' '};
         int f,c=0,co=0,pa=0;
         int posx=0,posy=0;
         char jugador;
char[][]matriz=new char[a][b];

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
        matriz[columna][fila]='W';
        System.out.print(" " +matriz[f][c]); 
    } 
         System.out.print("|");
         System.out.println();    
    }

          String Respuesta="";
          do{
            System.out.println("Posición");
        fila6=Integer.parseInt(da.next());
        
          if(fila6==6||fila6=='d'){
          for( f=0;f<a;f++){
              System.out.print("|");
              for( c=0;c<b;c++){
                matriz[f][c+1]='W';
                  System.out.print(" " +matriz[f][c]);  
              }
                System.out.print("|");
         System.out.println();    
          }
          }if(fila6==4||fila6=='a'){
          for( f=0;f<a;f++){
              System.out.print("|");
              for( c=0;c<b;c++){
                matriz[f][c-1]='W';
                
                  System.out.print(" " +matriz[f][c]);  
              }
                System.out.print("|");
         System.out.println();    
          }
          }
          if(fila6==8||fila6=='w'){
          for( f=0;f<matriz.length;f++){
              System.out.print("|");
              for( c=0;c<matriz.length;c++){
                matriz[columna-1][fila]='W';
                  System.out.print(" " +matriz[f][c]);  
              }
                System.out.print("|");
         System.out.println();    
          }
          }if(fila6==2||fila6=='x'){
          for( f=0;f<matriz.length;f++){
              System.out.print("|");
              for( c=0;c<matriz.length;c++){
                matriz[columna+1][fila]='W';
                  System.out.print(" " +matriz[f][c]);  
              }
                System.out.print("|");
         System.out.println();    
          }
 

           
          }
          }while(true);
     }
    
}
