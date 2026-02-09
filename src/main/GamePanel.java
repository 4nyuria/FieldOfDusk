package main;

import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import main.tile.TileManager;
import object.SuperObject;

public class GamePanel extends JPanel implements Runnable {
    // screen settings
    final int originalTileSize = 32; //16x16 tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; 
    public final int screenHeight = tileSize * maxScreenRow; 
    // Mapa del mundo (lo usa TileManager)
    public int[][] mapTileNum;

    //world settings
    /*al incio cold y row tienen valores fijos y es una public final
    luego del bucle y array se eliminan valores y se saca final
    */
    public int maxWorldCol;
    public int maxWorldRow;
    
    public int worldWidth = tileSize * maxWorldCol;           
    public int worldHeight = tileSize * maxWorldRow;
    
    int FPS = 60;
   
    public TileManager tileM;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[10]; //cantidad de objetos para mostrar al mismo tiempo en pantalla
    
    
    int playerposX;
	int playerSpeed;
	int playerposY;
	
	
    
    public GamePanel() {
      
         this.setPreferredSize(new Dimension(screenWidth, screenHeight));
         this.setBackground(Color.black);
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true); // to receive key input

            tileM = new TileManager(this);
    }
   
    public void setupGame() {
    	aSetter.setObject();
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
        //Straight Movement
        if(keyH.upPressed &! (keyH.leftPressed || keyH.rightPressed)) {
            playerposY -= playerSpeed;
        }
        else if(keyH.downPressed &! (keyH.leftPressed || keyH.rightPressed)) {
            playerposY += playerSpeed;
        }
        else if(keyH.leftPressed &! (keyH.upPressed || keyH.downPressed)) {
            playerposX -= playerSpeed;
        }
        else if(keyH.rightPressed &! (keyH.upPressed || keyH.downPressed)) {
            playerposX += playerSpeed;
        }
            
		
    }
  
    @Override
    public void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        java.awt.Graphics2D g2 = (java.awt.Graphics2D)g;
      //tiles
        tileM.draw(g2); //esto son como capas, primero se dibujan los tiles
      //objects
        for(int i =0; i < obj.length;i++){
        	if (obj[i] !=null) {
        		obj[i].draw(g2, this);
        	}
        }
      //player
        player.draw(g2);
        
        g2.dispose();

        
    }
}
