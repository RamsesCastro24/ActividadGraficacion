/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficacionrep;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Ramses
 */
public class Dibujar extends JPanel {
     //Ventana  
    private JFrame ventana;
    //contenedor
    private Container contenedor;

    //cordenadas
    private int cordenadax, cordenaday;

    //definiendo hilo de ejecucion
    private Thread hilo;
int cont;
    private final int[] figura = {
//        0x00000000,
//0x000001e0,
//0x00000210,
//0xfffff5e8,
//0xfffffa14,
//0xfffff402,
//0xfffff801,
//0xfffff801,
//0xfffff402,
//0xfffffa14,
//0xfffff5e8,
//0xfffff210,
//0x000001e0
            
            
           0x00800000,
0x00C80000,
0x00AC8000,
0x009AC800,
0x0091AC80,
0xFF911AC4,
0x001111AA,
0x00111111,
0xFF9111AA,
0x009119C4,
0x0091AC80,
0x009AC800,
0x00AC8000,
0x00C80000
 
//        
//      0x0000F800,
//0x00010800,
//0x00021007,
//0x00042009,
//0x00084011,
//0x0FF07FE1,
//0xF0000001,
//0x84249201,
//0xF0000001,
//0x0FF07FE1,
//0x00084011,
//0x00042009,
//0x00021007,
//0x00010800,
//0x0000F800
  
//        0x0007E000,
//0x000FF000,
//0x001FF100,
//0x003FF300,
//0x007FF700,
//0x00FFFF00,
//0x01FFFF10,
//0x03FFFF30,
//0x07FFFF70,
//0x0FFFFFF0,
//0x1FFFFFF1,
//0x3FFFFFF3,
//0x7FFFFFF7,
//0xFFFFFFFF

        
        
//        0x00000000,
//0x80000000,
//0xE0000000,
//0xF0000000,
//0xF8000000,
//0xFE800000,
//0xFFE00000,
//0xFFE00000,
//0xFFE00000,
//0x9FE00000,
//0x0FF80000,
//0x07F80000,
//0x039F0000,
//0x039FF000,
//0x039EFFE2,
//0x039EFFFA,
//0x0380727F,
//0x0380727F,
//0x0380727F,
//0x039EFFFA,
//0x039EFFE2,
//0x039FF000,
//0x039F0000,
//0x07F80000,
//0x0FF80000,
//0x9FE00000,
//0xFFE00000,
//0xFFE00000,
//0xFFE00000,
//0xFE800000,
//0xF8000000,
//0xF0000000,
//0xE0000000,
//0x80000000,
//0x00000000
//        
        
            
            
            

        
 //el del profe       
//        0x00080,
//        0x000c0,
//        0x000e0,
//        0x000f0,
//        0xffff8,
//        0xffffc,
//        0xffffe,
//        0xfffff,
//        0xffffe,
//        0xffffc,
//        0xffff8,
//        0x000f0,
//        0x000e0,
//        0x000c0,
//        0x00080
    };
    //mascara
    private final int mascara = 0x80000000;

    //anacho en bits
    private final int anchoBits = 32;

    public Dibujar() {
        //inicializar ventana
        ventana = new JFrame("Dibujando icono");
        //Definifr tamaño de Ventana
        ventana.setSize(800, 600);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);

        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        //agregar contenedor a la ventana

        contenedor.add(this, BorderLayout.CENTER);

        //Definiendo hilo
        this.hilo = new Thread();

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

//         graphics.setColor(Color.red);
//         graphics.drawLine(0, 0, 100, 100);
//
//this.cordenadax= (int) (Math.random() * 500);
//this.cordenaday=(int) (Math.random() * 500);
        System.out.println(cordenadax);
        System.out.println(cordenaday);
        //iterador de la figura
        for (int i = 0; i < this.figura.length; i++) {

            //iterador para el ancho en bits de la figura
            for (int j = 0; j < this.anchoBits; j++) {
                int temp = this.figura[i] & (this.mascara >>> j);

                if (temp!=0){
                    graphics.drawLine(
                            this.cordenaday + j,
                            this.cordenadax + i,
                            this.cordenaday + j,
                            this.cordenadax + i);
                }
            }
            
        }
         
         
             
    }

   
    public void Dibuja() {
        
        
        
        this.cordenadax= (int) (Math.random() * ventana.getWidth()- anchoBits);
        this.cordenaday=(int) (Math.random() * ventana.getHeight()-60);
        int cambio = (int) (Math.random()*4);
        movimiento(cambio);
        
        while(cont<10){
            System.out.println("TERIMINO");
            System.exit(0);
            
        }
        
        
//        for (;;) {
//            try{
//                this.cordenaday=this.cordenaday-cambio+10;
//                this.cordenadax=this.cordenadax-cambio+10;
//                this.hilo.sleep(250);
//                paint(getGraphics());
//               
//            }catch(Exception e){
//                System.out.println(e.getMessage());
//            }
            
//         
    }
        
    
    public void movimiento(int au){
        if (au==0) {
            do {
                try {
                    this.cordenadax=this.cordenadax-10;
                   this.hilo.sleep(250);
                   paint(getGraphics()); 
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } while (this.cordenadax>0);
            paint(getGraphics());
            
            
            
            
        }
        else if(au==1){
             do {
                try {
                    this.cordenaday=this.cordenaday-10;
                    this.hilo.sleep(250);
                    paint(getGraphics()); 
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } while (this.cordenaday>0);
            paint(getGraphics());
            
            
            
        }
        else if(au==2){
             do {
                try {
                    this.cordenaday=this.cordenaday + 10;
                this.hilo.sleep(250);
                    paint(getGraphics()); 
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } while (this.cordenaday < ventana.getHeight()- 45);
            paint(getGraphics());
            
            
            
        }
        else{
            
             do {
                try {
                    this.cordenadax=this.cordenadax+10;
                this.hilo.sleep(250);
                paint(getGraphics()); 
                    
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } while (this.cordenadax < ventana.getWidth()-anchoBits);
            paint(getGraphics());
            
        }
        cont++;
        
    }
            
        
        
    }
