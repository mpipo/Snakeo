/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author panpjp
 */
public class Barrier {
    public Barrier(int x, int y, Color color, CellDataProviderIntf cellData, boolean breakable){
        this.x = x;
        this.y = y;
        this.color = color;
        this.cellData = cellData;
        this.breakable = breakable;
    }

    private int x, y;
    private Color color;
    private boolean breakable = false;
    private CellDataProviderIntf cellData;

    
    public void draw(Graphics graphics){
        graphics.setColor(color);
        graphics.fill3DRect(cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(),
                true);
    }
    
    public Point getLocation(){
        return new Point(x, y);
    }
    public int getX() {
        return x;
    }
    public int setX(int x) {
        this.x = x;
        return 0;
    }
    public int getY() {
        return y;
    }
    public int setY(int y) {
        this.y = y;
        return 0;
    }
}
