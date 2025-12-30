package main;

import entity.Entity;

public class CollisionChecker {
    
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    private int clamp(int value, int min, int max) {
    if (value < min) return min;
    if (value > max) return max;
    return value;
    }


   public void checkTile(Entity entity) {

    int leftX   = entity.worldX + entity.solidArea.x;
    int rightX  = entity.worldX + entity.solidArea.x + entity.solidArea.width;
    int topY    = entity.worldY + entity.solidArea.y;
    int bottomY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

    int leftCol   = leftX / gp.tileSize;
    int rightCol  = rightX / gp.tileSize;
    int topRow    = topY / gp.tileSize;
    int bottomRow = bottomY / gp.tileSize;

    int tileNum1, tileNum2;

    switch (entity.direction) {

        case "up" -> {
            topRow = (topY - entity.speed) / gp.tileSize;
            if (topRow < 0) { entity.collisionOn = true; return; }

            tileNum1 = gp.tileM.mapTileNum[leftCol][topRow];
            tileNum2 = gp.tileM.mapTileNum[rightCol][topRow];
        }

        case "down" -> {
            bottomRow = (bottomY + entity.speed) / gp.tileSize;
            if (bottomRow >= gp.maxWorldRow) { entity.collisionOn = true; return; }

            tileNum1 = gp.tileM.mapTileNum[leftCol][bottomRow];
            tileNum2 = gp.tileM.mapTileNum[rightCol][bottomRow];
        }

        case "left" -> {
            leftCol = (leftX - entity.speed) / gp.tileSize;
            if (leftCol < 0) { entity.collisionOn = true; return; }

            tileNum1 = gp.tileM.mapTileNum[leftCol][topRow];
            tileNum2 = gp.tileM.mapTileNum[leftCol][bottomRow];
        }

        case "right" -> {
            rightCol = (rightX + entity.speed) / gp.tileSize;
            if (rightCol >= gp.maxWorldCol) { entity.collisionOn = true; return; }

            tileNum1 = gp.tileM.mapTileNum[rightCol][topRow];
            tileNum2 = gp.tileM.mapTileNum[rightCol][bottomRow];
        }

        default -> { return; }
    }

    if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
        entity.collisionOn = true;
    }
}
}
