package main.tile;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import main.GamePanel;


public class TileManager {
    
	GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];
    boolean drawPath = false;
    ArrayList<String> fileNames = new ArrayList<>();
    ArrayList<String> collisionStatus =new ArrayList<>();
    
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public TileManager(GamePanel gp) {
        this.gp = gp;
        // Para leer TILE DATA FILE - a esto debo cambiarle la ruta después para que quede ordenado
        InputStream is = getClass().getResourceAsStream("/Res/maps/tiledata.txt"); 
        BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
        
        //para sacar el nombre de las tiles y las coalisiones desde el archivo
        String line; 
        
        try {
        	while((line = br.readLine()) != null) {
        		fileNames.add(line);
        		collisionStatus.add(br.readLine());
        	}
        		br.close();
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        tile = new Tile[fileNames.size()]; 
        /*Este numero representa la cantidad de tiles que tengamos,
         * una vez esta el array de tilefile se cambia a inicializar segun el mismo
         */
        getTileImage();
        // para maxWorldCol & Row
        is = getClass ().getResourceAsStream("/Res/maps/mapexample.txt");
        br = new BufferedReader (new InputStreamReader(is));
        
        try {
        	String line2 = br.readLine();
        	String maxTile[] = line2.split(" ");
        	
        	gp.maxWorldCol = maxTile.length;
        	
        	// Contar el número de filas
        	int rowCount = 1; // ya leímos una línea
        	while(br.readLine() != null) {
        		rowCount++;
        	}
        	gp.maxWorldRow = rowCount;
            mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        	
            br.close();
            
        }catch(IOException e) {
        	System.out.println("Exception!*");
        }
        
        loadMap("/Res/maps/mapexample.txt",0);

       
       /*Esto leía el mapa al inicio
        loadMap("/Res/maps/worldmap.txt"); //acá lee el mapa <-------
        */
    }
    public void getTileImage( ) {
    	for(int i =0; i < fileNames.size(); i++) {
    		String fileName;
    		boolean collision;
    		// para obtener el file name
    		fileName = fileNames.get(i);
    		
    		//para obtener el estado de coalision
    		if(collisionStatus.get(i).equals("true")) {
    			collision = true;
    		}
    		else {
    			collision = false;
    		}
    		setup(i, fileName, collision);
    	}
    	System.out.println("Tiles cargados: " + fileNames.size());
    }
/*
 Esto es para cargar las tile 1x1, pero es preferible usarla al inicio como
 para ver si el codigo funciona, ya despues hay que utilizar un bucle
    @SuppressWarnings("CallToPrintStackTrace")
    public void getTileImage() { //cargar las imágenes de los tiles, reemplazado por array
    	try {
        tile[0] = new Tile();
        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/000.png"));
        tile[0].collision = true;

        tile[1] = new Tile();
        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/001.png"));

         } catch (IOException e) {
          e.printStackTrace();
        }
    }

*/    	
    public void setup(int index, String imageName, boolean collision) {
    	//UtilityTool uTool = new UtilityTool(); 
    	
    	try {
    		tile[index] = new Tile();
    		tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Res/tiles/"+ imageName));
    	//	tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize); 
    		tile[index].collision = collision;
    		
    		if (tile[index].image == null) {
    			System.err.println("Error: Imagen nula para tile " + index + ": " + imageName);
    		}
    		
    		}catch(IOException e) {
    			System.err.println("Error cargando tile " + index + ": " + imageName);
    			e.printStackTrace();
    		}
    }
    @SuppressWarnings({"CallToPrintStackTrace", "UseSpecificCatch"})
    public void loadMap(String filePath, int map) {
        BufferedReader br = null;
        try {
            // Aca cargaríamos el mapa desde un archivo de texto o similar
            InputStream is = getClass().getResourceAsStream(filePath);
            br = new BufferedReader(new InputStreamReader(is));
           
             if (is == null) {
            System.err.println("Mapa no encontrado: " + filePath);
            return;
            }

            int row = 0;
            
            while (row < gp.maxWorldRow) {
                String line = br.readLine();
                if (line == null) break;
               
                String numbers[] = line.split(" ");
                
                for (int col = 0; col < gp.maxWorldCol && col < numbers.length; col++) {
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                }
                row++;
            } 
            
            System.out.println("Mapa cargado: " + gp.maxWorldCol + "x" + gp.maxWorldRow);
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
       
         int tileNum = mapTileNum[worldCol][worldRow];

         int worldX = worldCol * gp.tileSize;
         int worldY = worldRow * gp.tileSize;

         int screenX = worldX - gp.player.worldX + gp.player.screenX;
         int screenY = worldY - gp.player.worldY + gp.player.screenY;   
         
         // Dibujar si está dentro de la pantalla (simplificado)
         if (screenX > -gp.tileSize && screenX < gp.screenWidth &&
             screenY > -gp.tileSize && screenY < gp.screenHeight) {
             
             if (tile[tileNum] != null && tile[tileNum].image != null) {
                 g2.drawImage(tile[tileNum].image, screenX, screenY, gp.tileSize, gp.tileSize, null);
             } else {
                 // Debug: dibujar un rectángulo si la imagen es nula
                 g2.setColor(java.awt.Color.CYAN);
                 g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize);
             }
         }

         worldCol++;

         if (worldCol == gp.maxWorldCol) {
             worldCol = 0;
             worldRow++;
         }
       }
    }

}


