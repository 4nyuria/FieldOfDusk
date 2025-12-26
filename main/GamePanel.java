package main;

import main.tile.TileManager;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    // screen settings
    final int originalTileSize = 16; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    // Mapa del mundo (lo usa TileManager)
    public int[][] mapTileNum;

    //world settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize * maxWorldCol;           
    public final int worldHeight = tileSize * maxWorldRow;

    //FPS
    int FPS = 60;
    
    // Referencia al TileManager
    public TileManager tileM = new TileManager(this);
    
    Thread gameThread;
    //sobre la coalision
    public CollisionChecker cChecker = new CollisionChecker(this);
    //player


    KeyHandler keyH = new KeyHandler();
    public Player player = new Player(this, keyH);

    public GamePanel() {
      
         this.setPreferredSize(new Dimension(screenWidth, screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true); // to receive key input
    }
   
    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
   
    public void run() {

        double drawInterval = 1000000000/FPS; // 0.01666 seconds
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        long drawCount = 0;
        while(gameThread != null) {
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime; 
            if (delta >= 1) {
                // 1 update: update information such as character positions
                update();
                // 2 draw: draw the screen with the updated information
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }
   
    public void update() {

        player.update();

    }
  
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
     
        java.awt.Graphics2D g2 = (java.awt.Graphics2D)g;
        tileM.draw(g2); //esto son como capas, primero se dibujan los tiles
        player.draw(g2);
        
        g2.dispose();

        
    }
}
