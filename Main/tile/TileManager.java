package Main.tile;

import java.io.IOException;

import javax.imageio.ImageIO;

import Main.GamePanel;

public class TileManager {
    GamePanel gp;
    tile[] tile;
    
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new tile[10]; //este número depende de la cantidad de tiles que tengamos
      
        getTileImage();

         // Inicializar el mapa con el tile base
         mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
          for (int col = 0; col < gp.maxWorldCol; col++) {
                for (int row = 0; row < gp.maxWorldRow; row++) {
                 mapTileNum[col][row] = 0; // todo pasto por ahora
             }
            }
    }
    public void getTileImage() { //cargar las imágenes de los tiles
    try {
     
    
        tile[0] = new tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));

        tile[1] = new tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png"));
        
        tile[2] = new tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png")); 
        

        //Cargar más tiles según sea necesario
    } catch (IOException e) {
        e.printStackTrace();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
    }

}
}

