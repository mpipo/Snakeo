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
import java.util.ArrayList;

/**
 *
 * @author panpjp
 */
class Snake {

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

    public Snake(Direction direction, Grid grid, LocationValidatorIntf validator) {
        this.direction = direction;
        this.grid = grid;
        this.validator = validator;

        body = new ArrayList<>();
        body.add(new Point(20, 9));
        body.add(new Point(20, 8));
        body.add(new Point(20, 7));
        hp = 100;
        blocked = false;
    }

    public void move() {
        if (isAlive()) {

            Point newHead = new Point(getHead());

            if (direction == Direction.LEFT) {
                newHead.x--;
            } else if (direction == Direction.RIGHT) {
                newHead.x++;
            } else if (direction == Direction.DOWN) {
                newHead.y++;
            } else if (direction == Direction.UP) {
                newHead.y--;
            }

            newHead = validator.validate(newHead);
            
            if (!isBlocked()) {
                getBody().add(0, newHead);

                //delete tail
                // if the growth counter is greater than zero
                // - do not remove the tail
                // - subtract one from the growth counter
                // else (the growthCounter is less than or equal to zero)
                // - delete the tail
                if (growthCounter > 0) {
                    growthCounter--;
                } else {
                    body.remove(body.size() - 1);
                }
            }
//        sleep(100);
        } else {
            bodyColor = Color.RED;
//            System.out.println("wasted");
        }
    }

//<editor-fold defaultstate="collapsed" desc="Properties">
    private Direction direction = Direction.RIGHT;
    private final LocationValidatorIntf validator;
    private ArrayList<Point> body;
    private final Grid grid;
    private Color bodyColor = Color.GREEN;
    private int hp;
    private int mp;
    private int sta;
    private int growthCounter;
    private boolean blocked;

    public Point getHead() {
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

    public void setDirection(Direction direction) {
        this.direction = direction;
        blocked = false;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return hp;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public int getHealthRounded() {
//        return Integer.getInteger();
        int i = (int) Math.round(hp / 10.0) * 10;
        return i;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int hp) {
        this.hp = hp;
    }

    public void addHealth(int hp) {
        this.hp += hp;
    }

    public void rmHealth(int hp) {
        this.hp -= hp;
    }

    public boolean isAlive() {
        return (hp > 0);
    }

    /**
     * @return the blocked
     */
    public boolean isBlocked() {
        return blocked;
    }

    /**
     * @param blocked the blocked to set
     */
    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }


    /**
     * @return the growthCounter
     */
    public int getGrowthCounter() {
        return growthCounter;
    }

    /**
     * @param growthCounter the growthCounter to set
     */
    public void setGrowthCounter(int growthCounter) {
        this.growthCounter = growthCounter;
    }
    
    public void addGrowthCounter(int growth) {
        this.growthCounter += growth;
    }
//</editor-fold>
    
}