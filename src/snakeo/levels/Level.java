/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo.levels;

import images.ResourceTools;
import java.awt.Color;
import java.util.ArrayList;
import snakeo.Barrier;
import snakeo.CellDataProviderIntf;

/**
 *
 * @author panpjp
 */
public class Level {
    public static final int TEXTURE_NONE = 0;
    public static final int TEXTURE_GRASS = 1;
    public static final int TEXTURE_GRASS_DIRT = 2;
    public static final int TEXTURE_VOID = 3;
    public static final int TEXTURE_BARRIER = 4;
    
    private int[][] level1 = 
    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    
    {
        barriers = new ArrayList<>();
        ArrayList<Object> drawtx = new ArrayList<>();
        
    }

    public Level(int level) {
        this.level = level;
    }

    private final ArrayList<Barrier> barriers;


    private int level = 0;
//    private int itemCount;

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
    }

    /**
     * @return the barriers
     */
    public ArrayList<Barrier> getBarriers() {
        barriers.clear();

//<editor-fold defaultstate="collapsed" desc="Level 1">
        if (level == 1) {
//            barriers.add(new );
            barriers.add(new Barrier(2, 1, Color.yellow, (CellDataProviderIntf) this, false));
            barriers.add(new Barrier(2, 2, Color.yellow, (CellDataProviderIntf) this, false));
            barriers.add(new Barrier(2, 3, Color.yellow, (CellDataProviderIntf) this, false));

//            ...
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Level 2">
        } else if (level == 2) {
//            ...
//</editor-fold>
        }

        return barriers;
    }

    public void getDrawTx() {
        ArrayList<Object> drawtx = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
//            drawtx.add(new DrawTx(1, i,
//                    ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"),
//                    (CellDataProviderIntf) this));
        }
            //<editor-fold defaultstate="collapsed" desc="1, y">
/*            drawtx.add(new DrawTx(1, 1, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 2, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 3, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 4, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 5, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 6, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 7, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 8, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 9, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 11, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 12, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 13, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 14, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 15, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 16, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 17, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 18, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 19, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 20, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 21, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 22, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 23, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 24, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 25, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 26, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 27, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 28, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 29, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
            drawtx.add(new DrawTx(1, 30, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this)); */
//</editor-fold>
            //<editor-fold defaultstate="collapsed" desc="2, y">
//            drawtx.add(new DrawTx(2, 1, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 2, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 3, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 4, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 5, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 6, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 7, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 8, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 9, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 11, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 12, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 13, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 14, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 15, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 16, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 17, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 18, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 19, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 20, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 21, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 22, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 23, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 24, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 25, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 26, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 27, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 28, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 29, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(1, 10, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//            drawtx.add(new DrawTx(2, 30, ResourceTools.loadImageFromResource("snakeo/graphics/map/ground/grass.png"), (CellDataProviderIntf) this));
//</editor-fold>
    }
}


