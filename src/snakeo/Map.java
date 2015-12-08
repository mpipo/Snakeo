/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import environment.Environment;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author panpjp
 */
class Map extends Environment implements CellDataProviderIntf {

    private final Grid grid;
    private Snake lenny;
    private ArrayList<Barrier> barriers;
    private Image healthImage;
    
    public Map() {
        this.setBackground(Color.BLACK);
        
        grid = new Grid(55, 30, 20, 20, new Point(20, 50), Color.WHITE);
        lenny = new Snake(Direction.LEFT, grid);
        
        healthImage = ResourceTools.loadImageFromResource("ui/hb_empty.png");
        
        barriers = new ArrayList<>();
        barriers.add(new Barrier(10, 10, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 11, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 12, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 13, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 14, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 15, Color.GREEN, this, false));
        barriers.add(new Barrier(10, 16, Color.GREEN, this, false));
//        myBarrier = new Barrier(10, 15, Color.GREEN, this, false);
    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelay = 0;
    int moveDelayLimit = 5;
    
    @Override
    public void timerTaskHandler() {
        if (lenny != null) {
            /* if counted to limit, then move snake and reset counter, else keep counting */
            if (moveDelay >= moveDelayLimit) {
                moveDelay = 0;
                try {
                    lenny.move();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                moveDelay++;
            }
                checkIntersections();
        }
    }
    
    public void checkIntersections(){
        for (Barrier barrier : barriers) {
            if (barrier.getLocation().equals(lenny.getHead())) {
                lenny.addHealth(-1000);
            }
        }
    }
    
    public void checkObjects(){
//        for 
    }
    
    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            lenny.setDirection(Direction.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            lenny.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            lenny.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            lenny.setDirection(Direction.RIGHT);
        }
    
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null) {
            grid.paintComponent(graphics);
        }
        
        if (lenny != null) {
            try {
                lenny.draw(graphics);
            } catch (InterruptedException ex) {
                Logger.getLogger(Map.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
//        
//        if (myBarrier != null) {
//            myBarrier.draw(graphics);
//        }
        if (barriers != null) {
            for (int i = 0; i < barriers.size(); i++) {
                barriers.get(i).draw(graphics);
            }
        }
    }
    
    public void printHealthBar(Graphics graphics) {
        while (true) {
            if (lenny.isDead()) {
                graphics.drawImage(healthImage, 480, 90, null);
            
            }
        }
    }

    @Override
    public int getCellWidth() {
        return grid.getCellWidth();
    }

    @Override
    public int getCellHeight() {
        return grid.getCellHeight();
    }

    @Override
    public int getSystemCoordX(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).x;
    }

    @Override
    public int getSystemCoordY(int x, int y) {
        return grid.getCellSystemCoordinate(x, y).y;
    }

    
}
