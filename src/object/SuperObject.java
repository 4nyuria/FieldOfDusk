package object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import main.GamePanel;

public class SuperObject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldX, worldY;
	
	public void draw(Graphics2D g2, GamePanel gp) {
        int screenX = worldX - gp.player.worldX + gp.player.screenX;
        int screenY = worldY - gp.player.worldY + gp.player.screenY;   
        
        // Dibujar si está dentro de la pantalla (simplificado)
        if (screenX > -gp.tileSize && screenX < gp.screenWidth &&
            screenY > -gp.tileSize && screenY < gp.screenHeight) {
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            } 
        }
}