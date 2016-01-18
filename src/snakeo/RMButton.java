/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author panpjp
 */
public class RMButton {

    public void draw(Graphics graphics) {
        graphics.setColor(shadowColor);
        graphics.fillRect(x + 2, y + 2, width, height);

        graphics.setColor(fgColor);
        graphics.fillRect(x, y, width, height);
    }
    
//<editor-fold defaultstate="collapsed" desc="Constructor">
    {
        this.fgColor = Color.GRAY;
        this.shadowColor = Color.DARK_GRAY;
        this.textColor = Color.WHITE;
    }

    public RMButton(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Properties">
    private int x, y, width, height;
    private String text;
    private Color textColor, fgColor, shadowColor;

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
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the textColor
     */
    public Color getTextColor() {
        return textColor;
    }

    /**
     * @param textColor the textColor to set
     */
    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    /**
     * @return the fgColor
     */
    public Color getFgColor() {
        return fgColor;
    }

    /**
     * @param fgColor the fgColor to set
     */
    public void setFgColor(Color fgColor) {
        this.fgColor = fgColor;
    }

    /**
     * @return the shadowColor
     */
    public Color getShadowColor() {
        return shadowColor;
    }

    /**
     * @param shadowColor the shadowColor to set
     */
    public void setShadowColor(Color shadowColor) {
        this.shadowColor = shadowColor;
    }
//</editor-fold>

}
