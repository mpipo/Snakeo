/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

/**
 *
 * @author panpjp
 */
public class Item {


    public void draw(Graphics graphics) {
        graphics.drawImage(image,
                cellData.getSystemCoordX(x, y),
                cellData.getSystemCoordY(x, y),
                cellData.getCellWidth(),
                cellData.getCellHeight(),
                null);
    }

    public Item(int x, int y, String type,
            CellDataProviderIntf cellData) {
        this.x = x;
        this.y = y;
        this.cellData = cellData;

        this.type = type;
        if (type.equals(ITEM_TYPE_POISON)) {
            this.image = ResourceTools.loadImageFromResource("snakeo/items/mp_up/225x300.png");
            itemName = ITEM_NAME_POISON;
        } else if (type.equals(ITEM_TYPE_POISON)) {
            this.image = ResourceTools.loadImageFromResource("snakeo/items/hp_up/225x300.png");
            itemName = ITEM_NAME_HP;
        } 
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    public static final String ITEM_TYPE_POISON = "POISON";
    public static final String ITEM_TYPE_HP= "HP";
    
    public static final String ITEM_NAME_POISON = "Poison Potion";
    public static final String ITEM_NAME_HP = "HP Potion";
    
    private int x, y;
    private String type;
    private Image image;
     private String itemName;
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
        return itemName;
    }
    
//</editor-fold>

}