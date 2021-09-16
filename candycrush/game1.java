import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class game1 extends Canvas implements Runnable{
    public static final int WIDTH = 288, HEIGHT = 288;
    public static final int SCALE = 2;

    public static final int FPS = 1000/60;
    
    public Tabuleiro TABULEIRO;

    public BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);

    public game1(){
        this.setPreferredSize(new Dimension(WIDTH*SCALE,HEIGHT*SCALE));
        TABULEIRO = new Tabuleiro();
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("Candy Crush");
        game1 Game = new game1();
        frame.add(Game);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(Game).start();
    }

    public void update(){
        System.out.println("aaa");
    }

    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }  

        Graphics g = image.getGraphics();
         g.setColor(Color.CYAN);
         g.fillRect(0, 0, WIDTH, HEIGHT);
         TABULEIRO.render(g);

         g = bs.getDrawGraphics();
         g.drawImage(image, 0, 0, null);
        bs.show();

    }

    public void run(){
        while(true){
            update();
            render();
            try{
            Thread.sleep(FPS);
            } catch(InterruptedException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}