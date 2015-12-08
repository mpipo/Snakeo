/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author panpjp
 */
public class HealthBar {
    // create new storage for image
    private Image healthBar00;
    
    
    public void print(Graphics graphics) {
        healthBar00 = ResourceTools.loadImageFromFile("ui/healthbar/hb_zero.png");
    }
}
