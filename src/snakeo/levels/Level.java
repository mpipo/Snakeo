/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo.levels;

import images.ImageManager;
import images.ResourceTools;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import snakeo.Barrier;
import snakeo.CellDataProviderIntf;

/**
 *
 * @author panpjp
 */
public final class Level {

    public void draw(Graphics graphics) {
        for (int row = 0; row < levelMap.length; row++) {
            for (int column = 0; column < levelMap[row].length; column++) {
                graphics.drawImage(imageManager.getImage(imageNames.get(levelMap[row][column])), 
                        cellData.getSystemCoordX(column, row), 
                        cellData.getSystemCoordY(column, row), 
                        cellData.getCellWidth(), 
                        cellData.getCellHeight(), null);
            }
        }
    }

//<editor-fold defaultstate="collapsed" desc="Static Data">
    public static final int TEXTURE_NONE = 0;
    public static final int TEXTURE_GRASS = 1;
    public static final int TEXTURE_GRASS_DIRT = 2;
    public static final int TEXTURE_VOID = 3;
    public static final int TEXTURE_WATER = 4;
    public static final int TEXTURE_BRIDGE_BASE = 5;

    public static final String TEXTURE_NAME_NONE = "NONE";
    public static final String TEXTURE_NAME_GRASS = "GRASS";
    public static final String TEXTURE_NAME_GRASS_DIRT = "GRASS_DIRT";
    public static final String TEXTURE_NAME_VOID = "VOID";
    public static final String TEXTURE_NAME_WATER = "WATER";
    public static final String TEXTURE_NAME_BRIDGE_BASE = "BRIDGE_BASE";
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private final CellDataProviderIntf cellData;
    private final ArrayList<Barrier> barriers;
    private final HashMap<Integer, String> imageNames;
    private final ImageManager imageManager;
    private int level = 0;
    private int[][] levelMap;

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
        
        if (level == 1) {
            levelMap = levelMap01_1;
        } else {
            levelMap = levelMapNone;
        }
        
    }

    public int getItemCount() {
        if (getLevel() == 1) {
            return 10;
        } else if (getLevel() == 2) {
            return 15;
        } else {
            return 5;
        }
    }

    public int moveDelay() {
        switch (getLevel()) {
            case 1:
                return 5;
            case 2:
                return 4;

            default:
            case 10:
                return 1;
        }
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Level Maps">
    private int[][] levelMapNone = {{}};
    
    private int[][] levelMap01_1 = 
           {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 3, 2, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}};

//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Constructors">
    {
        barriers = new ArrayList<>();
        
        imageManager = new ImageManager();
        imageManager.addImage(TEXTURE_NAME_NONE, ResourceTools.loadImageFromResource("snakeo/graphics/map/void/null.png"));
        imageManager.addImage(TEXTURE_NAME_GRASS, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"));
        imageManager.addImage(TEXTURE_NAME_GRASS_DIRT, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass_dirt_down.png"));
        imageManager.addImage(TEXTURE_NAME_VOID, ResourceTools.loadImageFromResource("snakeo/graphics/map/void/void.png"));
        imageManager.addImage(TEXTURE_NAME_WATER, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/water.png"));
        imageManager.addImage(TEXTURE_NAME_BRIDGE_BASE, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/bridge_wood.png"));

        imageNames = new HashMap<>();
        imageNames.put(TEXTURE_NONE, TEXTURE_NAME_NONE);
        imageNames.put(TEXTURE_GRASS, TEXTURE_NAME_GRASS);
        imageNames.put(TEXTURE_GRASS_DIRT, TEXTURE_NAME_GRASS_DIRT);
        imageNames.put(TEXTURE_VOID, TEXTURE_NAME_VOID);
        imageNames.put(TEXTURE_WATER, TEXTURE_NAME_WATER);
        imageNames.put(TEXTURE_BRIDGE_BASE, TEXTURE_NAME_BRIDGE_BASE);
     
        levelMap = levelMapNone;
    }

    public Level(int level, CellDataProviderIntf cellData) {
        this.cellData = cellData;
//        this.level = level;
        setLevel(level);
    }
    
    barriers.add(new Barrier(0, 0, Color.GREEN, this, false));
//</editor-fold>

}
