/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo.levels;

import grid.Grid;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import snakeo.Barrier;
import snakeo.CellDataProviderIntf;

/**
 *
 * @author panpjp
 */
public class Level {

    
    {
        barriers = new ArrayList<Barrier>();
    }
    
    public Level(int level) {
        this.level = level;
    }
    
    private ArrayList<Barrier> barriers;
    
    private int level = 0;
//    private int itemCount;
    
    public int getItemCount(){
        if (getLevel() == 1) {
            return 10;
        } else if (getLevel() == 2) {
            return 15;
        } else {
            return 5;
        }
    }
    
    public int moveDelay(){
        switch (getLevel()) {
            case 1 : 
                return 5;
            case 2 : 
                return 4;
            
            default:
            case 10 : 
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
        
        if (level == 1) {
//            barriers.add(new );
//            ...
        }else if (level == 2){
//            ...
        }
        
        return barriers;
    }
    
    
}
