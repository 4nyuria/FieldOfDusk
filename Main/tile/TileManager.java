package Main.tile;
import Main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;


public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int mapTileNum[][];
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[38]; //este número depende de la cantidad de tiles que tengamos
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/Res/maps/worldmap.txt");


    }

    public TileManager() {
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public void getTileImage() { //cargar las imágenes de los tiles
        try {
     
    
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/000.png"));

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));
        
        tile[2] = new Tile();
        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png")); 
      
        tile[3] = new Tile();
        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png"));
        
        tile[4] = new Tile();
        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/004.png"));

        tile[5] = new Tile();
        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/005.png"));

        tile[6] = new Tile();
        tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/006.png"));
        
        tile[7] = new Tile();
        tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/007.png")); 
      
        tile[8] = new Tile();
        tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/008.png"));
        
        tile[9] = new Tile();
        tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/009.png"));
        
        tile[10] = new Tile();
        tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/010.png"));

        tile[11] = new Tile();
        tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/011.png"));
        
        tile[12] = new Tile();
        tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/012.png")); 
      
        tile[13] = new Tile();
        tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/013.png"));
        
        tile[14] = new Tile();
        tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/014.png"));

        tile[15] = new Tile();
        tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/015.png"));

        tile[16] = new Tile();
        tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/016.png"));
        
        tile[17] = new Tile();
        tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/017.png")); 
      
        tile[18] = new Tile();
        tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/018.png"));
        
        tile[19] = new Tile();
        tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/019.png"));
        
        tile[20] = new Tile();
        tile[20].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/020.png"));

        tile[21] = new Tile();
        tile[21].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/021.png"));
        
        tile[22] = new Tile();
        tile[22].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/022.png")); 
      
        tile[23] = new Tile();
        tile[23].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/023.png"));
        
        tile[24] = new Tile();
        tile[24].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/024.png"));

        tile[25] = new Tile();
        tile[25].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/025.png"));

        tile[26] = new Tile();
        tile[26].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/026.png"));
        
        tile[27] = new Tile();
        tile[27].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/027.png")); 
      
        tile[28] = new Tile();
        tile[28].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/028.png"));
        
        tile[29] = new Tile();
        tile[29].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/029.png"));
        
        tile[30] = new Tile();
        tile[30].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/030.png"));

        tile[31] = new Tile();
        tile[31].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/031.png"));
        
        tile[32] = new Tile();
        tile[32].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/032.png")); 
      
        tile[33] = new Tile();
        tile[33].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/033.png"));
        
        tile[34] = new Tile();
        tile[34].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/034.png"));

        tile[35] = new Tile();
        tile[35].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/035.png"));

        tile[36] = new Tile();
        tile[36].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/036.png"));
        
        tile[37] = new Tile();
        tile[37].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/037.png")); 
     
        //Cargar más tiles según sea necesario
         } catch (IOException e) {
          e.printStackTrace();
        }
    }
    
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public void loadMap(String filePath) {
        BufferedReader br = null;
        try {
            // Aca cargaríamos el mapa desde un archivo de texto o similar
            InputStream is = getClass().getResourceAsStream(filePath);
            br = new BufferedReader(new InputStreamReader(is));
           
             if (is == null) {
            System.err.println("Mapa no encontrado: " + filePath);
            return;
            }

            int col = 0;
            int row = 0;
            
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                if (line == null) break;
               
                while (col < gp.maxWorldCol) {
                  
                    String numbers[] = line.split(" ");
                  
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[row][col] = num;
                    col++;
                } 
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;
                }
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void draw(Graphics2D g2) {
       //aquí dibujamos los tiles en pantalla
       int worldCol = 0;
       int worldRow = 0;

       
       while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {
        //esto es para el mapeo numerico del mapa
       
         int tileNum = mapTileNum[worldRow][worldCol];

         int worldX = worldCol * gp.tileSize;
         int worldY = worldRow * gp.tileSize;

         int screenX = worldX - gp.player.worldX + gp.player.screenX;
         int screenY = worldY - gp.player.worldY + gp.player.screenY;   
         
         if (worldX + gp.tileSize > gp.player.worldX - gp.player.screenX - gp.tileSize &&
             worldX - gp.tileSize < gp.player.worldX + gp.player.screenX + gp.tileSize &&
             worldY + gp.tileSize > gp.player.worldY - gp.player.screenY - gp.tileSize &&
             worldY - gp.tileSize < gp.player.worldY + gp.player.screenY + gp.tileSize) {

                 g2.drawImage( tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);

             }

           worldCol++;

           if (worldCol == gp.maxWorldCol) {
               worldCol = 0;
               worldRow++;
           }
       }
    }

}


