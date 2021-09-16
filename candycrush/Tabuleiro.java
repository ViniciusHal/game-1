import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;

public class Tabuleiro {
    public static final int WIDTH = 6,HEIGHT = 6;
    public static int[][] TABULEIRO;

    public static int DOCE_0 = 0,DOCE_1 = 1,DOCE_2 = 2;

    public Tabuleiro(){
        TABULEIRO = new int [WIDTH][HEIGHT];

        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                TABULEIRO[x][y] = new Random().nextInt(3);
            }
        }

    }

    public void render(Graphics g){
        for(int x = 0; x < WIDTH; x++){
            for(int y = 0; y < HEIGHT; y++){
                g.setColor(Color.white);
                g.drawRect(x*48, y*48, 48, 48);
            }
        }
    }

}
