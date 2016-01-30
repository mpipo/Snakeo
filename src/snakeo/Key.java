/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;

import com.sun.glass.events.KeyEvent;

/**
 *
 * @author panpjp
 */
public class Key {
    public boolean isUp() {
        if (KeyEvent.VK_UP == 1) {
            return true;
        } else {
            return false;
        }
    }
}
