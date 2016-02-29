/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// POISON POTION
package snakeo;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author panpjp
 */
public class Item1 {

    public void draw(Graphics graphics) {
        // uses mp_potion texture since someone deleted the pxm files so I can't edit it
        graphics.drawImage(ResourceTools.loadImageFromResource("snakeo/items/mp_up/225x300.png"),
                cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(),
                null);
    }

    public Item1(int x, int y, CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.cellData = cellData;
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x, y;
    private String type;
    private Image image;
    private final CellDataProviderIntf cellData;

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }
    public Point getLocation() {
        return new Point(x, y);
    }
    public String getItemName() {
        return "Poison Potion";
    }
//</editor-fold>

}
