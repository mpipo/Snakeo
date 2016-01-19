/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import java.awt.Graphics;
import java.util.Arrays;
import java.awt.Color;

/**
 *
 * @author panpjp
 */
public class Console {

    private int x, y, width, height;
    private String ConsoleTheme;
    private final String ListOfCS[];

    {
        ListOfCS = new String[]{"Style_Default", "Style_Source", "Style_Bethesda", "Style_Unix"};
    }

    public Console(int x, int y, int width, int height, String ConsoleTheme) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.ConsoleTheme = ConsoleTheme;
    }

    public void draw(Graphics graphics) {

        if (Arrays.asList(ListOfCS).contains(ConsoleTheme)) {
            if (ConsoleTheme == "Style_Default") {
                graphics.setColor(Color.GRAY);
                graphics.fillRect(x, y, width, height);
                graphics.setColor(Color.DARK_GRAY);
                graphics.fillRect(x + 20, y + 20, width - 10, height - 10);
            }
        } else {
            System.out.println("ERROR");

        }
    }

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
     * @return the ConsoleType
     */
    public String getConsoleTheme() {
        return ConsoleTheme;
    }

    /**
     * @param ConsoleTheme the ConsoleTheme to set
     */
    public void setConsoleTheme(String ConsoleTheme) {
        this.ConsoleTheme = ConsoleTheme;
    }
}
