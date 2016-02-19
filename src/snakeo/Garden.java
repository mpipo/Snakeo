/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import audio.AudioPlayer;
import environment.Environment;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import grid.Grid;
import images.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import snakeo.levels.Level;

/**
 *
 * @author panpjp
 */
final class Garden extends Environment implements CellDataProviderIntf, LocationValidatorIntf {

//<editor-fold defaultstate="collapsed" desc="Properties">
    private static final Color PAUSE_OVERLAY = new Color(0, 0, 0, 160);
    public int currentLevel;
    private final Grid grid;
    private final Snake lenny;
    private final Image healthImage;
    private ArrayList<Barrier> barriers;
    private final ArrayList<Item> items;
    private final ArrayList<Item0> items0;
    private final Image healthBar00;
    private final Image healthBar10;
    private final Image healthBar20;
    private final Image healthBar30;
    private final Image healthBar40;
    private final Image healthBar50;
    private final Image healthBar60;
    private final Image healthBar70;
    private final Image healthBar80;
    private final Image healthBar90;
    private final Image healthBar100;
    private GameState state;
    private Image menuBackground;
    private Level level;
    private MySoundManager soundManager;

//</editor-fold>
    public Garden() {
        this.state = GameState.MENU;
        this.setBackground(Color.WHITE);

        grid = new Grid(32, 15, 40, 40, new Point(20, 50), Color.GREEN);
        lenny = new Snake(Direction.RIGHT, grid, this);

        level = new Level(1, this);

        createRectEdge(32, 15, 0, 0);
        healthImage = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_empty.png");
        healthBar00 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_empty.png");
        healthBar10 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_10.png");
        healthBar20 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_20.png");
        healthBar30 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_30.png");
        healthBar40 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_40.png");
        healthBar50 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_50.png");
        healthBar60 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_60.png");
        healthBar70 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_70.png");
        healthBar80 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_80.png");
        healthBar90 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_90.png");
        healthBar100 = ResourceTools.loadImageFromResource("snakeo/ui/healthbar/hb_full.png");

        items = new ArrayList<>();
        items.add(new Item(10, 5, "HP_UP", ResourceTools.loadImageFromResource("snakeo/items/hp_up/225x300.png"), this));
        items.add(new Item(20, 10, "MP_UP", ResourceTools.loadImageFromResource("snakeo/items/mp_up/225x300.png"), this));
        items.add(new Item(30, 10, "STA_UP", ResourceTools.loadImageFromResource("snakeo/items/sta_up/225x300.png"), this));

        items0 = new ArrayList<>();
        items0.add(new Item0(5, 5, this));
        this.state = GameState.RUNNING;
        soundManager = MySoundManager.getSoundManager();
    }

    @Override
    public void initializeEnvironment() {
    }

    int moveDelay = 0;
    int moveDelayLimit = 5;

    @Override
    public void timerTaskHandler() {
        //only move the snake if state == RUNNING
        if (state == GameState.RUNNING) {
            if (lenny != null) {
                /* if counted to limit, then move snake and reset counter, else keep counting */
                if (moveDelay >= moveDelayLimit) {
                    moveDelay = 3;
                    lenny.move();
                } else {
                    moveDelay++;
                }
//            checkIntersections();
            }
        }
    }

    public void checkIntersections() {
        if (barriers != null) {
            for (Barrier barrier : barriers) {
                if (barrier.getLocation().equals(lenny.getHead())) {
                    lenny.rmHealth(100);
                }
            }
        }
        /*        if (items != null) {
            for (Item item : items) {
                if (item.getLocation().equals(lenny.getHead())) {
                    
                }
            }
        } */
        if (items0 != null) {
            for (Item0 items0 : items0) {
                if (items0.getLocation().equals(lenny.getHead())) {
                    lenny.addHealth(20);
                }
            }
        }
    }

    public boolean checkBarriers(Point location) {
        if (barriers != null) {
            for (Barrier barrier : barriers) {
                if (barrier.getLocation().equals(location)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void checkObjects() {
//        for 
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                lenny.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                lenny.setDirection(Direction.DOWN);
                break;
            case KeyEvent.VK_LEFT:
                lenny.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                lenny.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_SPACE:
                soundManager.play(MySoundManager.SMG_SOUND, 3);
                break;
            case KeyEvent.VK_ESCAPE:
                // if state is PAUSED, then set to RUNNING,
                // else if state is RUNNING, then set to PAUSED
                if (state == GameState.PAUSED) {
                    state = GameState.RUNNING;
                } else if (state == GameState.RUNNING) {
                    state = GameState.PAUSED;
                }
                break;
            case KeyEvent.VK_M:
                state = GameState.MENU;
                break;
            case KeyEvent.VK_SLASH:
                if (state == GameState.CONSOLE) {
                    state = GameState.RUNNING;
                } else if (state == GameState.RUNNING) {
                    state = GameState.CONSOLE;
                }
                break;
            case KeyEvent.VK_G:
                lenny.addGrowthCounter(3);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            System.out.println("hello");
        }
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    }

    private Image getHealthImage() {
        int snakeHealth = lenny.getHealthRounded();
        if (snakeHealth <= 10) {
            return healthBar00;
        } else if (snakeHealth <= 20) {
            return healthBar10;
        } else if (snakeHealth <= 30) {
            return healthBar20;
        } else if (snakeHealth <= 40) {
            return healthBar30;
        } else if (snakeHealth <= 50) {
            return healthBar40;
        } else if (snakeHealth <= 60) {
            return healthBar50;
        } else if (snakeHealth <= 70) {
            return healthBar60;
        } else if (snakeHealth <= 80) {
            return healthBar70;
        } else if (snakeHealth <= 90) {
            return healthBar80;
        } else if (snakeHealth <= 100) {
            return healthBar90;
        } else {
            return healthBar100;
        }
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if ((state == GameState.RUNNING) || ((state == GameState.PAUSED)) || ((state == GameState.CONSOLE))) {
            checkIntersections();
            if (level != null) {
                level.draw(graphics);
                System.out.println(lenny.getHealth());
            }

            if (grid != null) {
                grid.paintComponent(graphics);
            }

            if (lenny != null) {
                lenny.draw(graphics);
            }
            graphics.drawImage(getHealthImage(), 10, 2, 240, 45, this);

            if (barriers != null) {
                drawBarriersLv1();
                for (int i = 0; i < barriers.size(); i++) {
                    barriers.get(i).draw(graphics);

                }
            }
            if (items != null) {
                for (int i = 0; i < items.size(); i++) {
                    items.get(i).draw(graphics);

                }
            }
            if (items0 != null) {
                for (int i = 0; i < items0.size(); i++) {
                    items0.get(i).draw(graphics);
                }
            }
            if (state == GameState.PAUSED) {
                graphics.setColor(PAUSE_OVERLAY);
                graphics.fillRect(0, 0, this.getWidth(), this.getHeight());

                graphics.setFont(new Font("Arial", Font.BOLD, 60));
                graphics.setColor(Color.red);
                graphics.drawString("PAUSED", this.getWidth() / 2, this.getHeight() / 2);

            } else if (state == GameState.CONSOLE) {
                new Console(0, this.getHeight() / 2, this.getWidth(), this.getHeight() / 2, "Style_Default").draw(graphics);
            }

        } else if (state == GameState.MENU) {
            if (menuBackground == null) {
                menuBackground = ResourceTools.loadImageFromResource("snakeo/ui/background/placeholder.png");
            }
            graphics.drawImage(menuBackground, 0, 0, this.getWidth(), this.getHeight(), null);

            new RMButton(400, 400, 100, 25, "Ron Rocks").draw(graphics);

        }
//        drawRectEdge(graphics, 30, 15, 0, 0);
//        printHealthBar(graphics);
    }

    /*    private void printHealthBar(Graphics graphics) {
     int hr;
     hr = snakeo.Snake.getHealthRounded();
     if (hr = 10) {
     graphics.drawImage(healthBar10, 100, 5, 240, 40, null);
     }
     } */
    public void createRectEdge(int width, int height, int xst, int yst) {
        barriers = new ArrayList<>();
        // upper
        for (int x = xst; x < width + xst; x++) {
            barriers.add(new Barrier(x, 0, Color.GREEN, this, false, false));
        }
        // right side
        for (int y = yst; y <= height + yst; y++) {
            barriers.add(new Barrier(width, y, Color.GREEN, this, false, false));
        }
        // bottom
        for (int x = xst; x < width + xst; x++) {
            barriers.add(new Barrier(x, height, Color.GREEN, this, false, false));
        }
        // left side
        for (int y = yst; y < height + yst; y++) {
            barriers.add(new Barrier(0, y, Color.GREEN, this, false, false));
        }
    }

    // an uber crappy implementation because i have no idea what's going on
    private void drawBarriersLv1() {
//<editor-fold defaultstate="collapsed" desc="x=11">
        barriers.add(new Barrier(11, 0, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 1, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 2, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 3, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 4, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 5, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 6, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 7, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 8, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 9, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 10, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 11, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 12, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 13, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 14, Color.BLACK, this, false, true));
        barriers.add(new Barrier(11, 15, Color.BLACK, this, false, true));
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="x=12">
        barriers.add(new Barrier(12, 0, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 1, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 2, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 3, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 4, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 5, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 6, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 7, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 8, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 9, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 10, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 11, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 12, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 13, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 14, Color.BLACK, this, false, true));
        barriers.add(new Barrier(12, 15, Color.BLACK, this, false, true));
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="x=13">
        barriers.add(new Barrier(13, 0, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 1, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 2, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 3, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 4, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 5, Color.BLACK, this, false, true));
//        barriers.add(new Barrier(11, 6, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 7, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 8, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 9, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 10, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 11, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 12, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 13, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 14, Color.BLACK, this, false, true));
        barriers.add(new Barrier(13, 15, Color.BLACK, this, false, true));
//</editor-fold>
    }
//<editor-fold defaultstate="collapsed" desc="CellDataProviderIntf">

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
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="LocationValidatorIntf">
    @Override
    public Point validate(Point proposedLocation) {
        //check if he is trying to put his head into a wall
        // - if so, block the damn snake!!!!!!!
        //          make a farting noise
        //          say something mean to the player...

        if (checkBarriers(proposedLocation)) {
            lenny.addHealth(-0);
            lenny.setBlocked(true);
            System.out.println("Hey, you're a crappy driver...");
        }
        return proposedLocation;
    }
//</editor-fold>

}
