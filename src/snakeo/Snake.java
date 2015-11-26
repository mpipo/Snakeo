/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import grid.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;

/**
 *
 * @author panpjp
 */
class Snake {

    private Direction direction = Direction.LEFT;
    private ArrayList<Point> body;
    private Grid grid;
    private Color bodyColor = Color.MAGENTA;
    
    public void draw(Graphics graphics) {
        graphics.setColor(bodyColor);
        for (int i = 0; i < getBody().size(); i++) {
//            System.out.println("body location = " + getBody().get(i).toString());
            graphics.fillOval(grid.getCellSystemCoordinate(getBody().get(i)).x,
            grid.getCellSystemCoordinate(getBody().get(i)).y,
            grid.getCellWidth(),
            grid.getCellHeight());
        }
    }
    public Snake(Direction direction, Grid grid){
        this.direction = direction;
        this.grid = grid;
        
        body = new ArrayList<>();
        body.add(new Point(5,5));
        body.add(new Point(5,4));
        body.add(new Point(5,3));
    }
    
    public void move() throws InterruptedException {
        Point newHead = new Point(getHead());
        if (direction == Direction.LEFT){
            newHead.x--;
        } else if (direction == Direction.RIGHT) {
            newHead.x++;
        } else if (direction == Direction.DOWN) {
            newHead.y++;
        } else if (direction == Direction.UP) {
            newHead.y--;
        }
        getBody().add(0, newHead);
//        sleep(100);
    }
    
    public Point getHead(){
        return getBody().get(0);
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @param bodyColor the bodyColor to set
     */
    public void setBodyColor(Color bodyColor) {
        this.bodyColor = bodyColor;
    }
    
    

    void setDirection(Direction direction) {
        this.direction = direction;
    }
    
}
