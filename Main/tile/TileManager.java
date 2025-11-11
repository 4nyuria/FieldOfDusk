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

        tile = new Tile[37]; //este número depende de la cantidad de tiles que tengamos
        mapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
        loadMap("/Res/maps/map01.txt");


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
        tile[6].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));
        
        tile[7] = new Tile();
        tile[7].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png")); 
      
        tile[8] = new Tile();
        tile[8].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png"));
        
        tile[9] = new Tile();
        tile[9].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/004.png"));
        
        tile[10] = new Tile();
        tile[10].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/000.png"));

        tile[11] = new Tile();
        tile[11].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));
        
        tile[12] = new Tile();
        tile[12].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png")); 
      
        tile[13] = new Tile();
        tile[13].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png"));
        
        tile[14] = new Tile();
        tile[14].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/004.png"));

        tile[15] = new Tile();
        tile[15].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/000.png"));

        tile[16] = new Tile();
        tile[16].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));
        
        tile[17] = new Tile();
        tile[17].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/002.png")); 
      
        tile[18] = new Tile();
        tile[18].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/003.png"));
        
        tile[19] = new Tile();
        tile[19].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/004.png"));
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
            
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();
                if (line == null) break;
               
                while (col < gp.maxScreenCol) {
                  
                    String numbers[] = line.split(" ");
                  
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                } 
                if (col == gp.maxScreenCol) {
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
       int col = 0;
       int row = 0;
       int x = 0;
       int y = 0;
       
       while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
        //esto es para el mapeo numerico del mapa
       
         int tileNum = mapTileNum[col][row];

           g2.drawImage( tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
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


