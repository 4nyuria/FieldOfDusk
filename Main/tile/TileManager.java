package Main.tile;
import Main.GamePanel;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;


public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10]; //este número depende de la cantidad de tiles que tengamos
      
        getTileImage();


    }
    public void getTileImage() { //cargar las imágenes de los tiles
        try {
     
    
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png"));
        
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png")); 
        

        //Cargar más tiles según sea necesario
         } catch (IOException e) {
          e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2) {
       //aquí dibujamos los tiles en pantalla, para leer desde un block de notas
       int col = 0;
       int row = 0;
       int x = 0;
       int y = 0;
       while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
           g2.drawImage(tile[1].image, x, y, gp.tileSize, gp.tileSize, null);
           col++;
           x += gp.tileSize;
           if (col == gp.maxScreenCol) {
               col = 0;
               x = 0;
               row++;
               y += gp.tileSize;
           }
       }
    }

}


