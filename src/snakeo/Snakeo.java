/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo;
import environment.ApplicationStarter;
import java.awt.Dimension;
/**
 *
 * @author panpjp
 */
public class Snakeo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ApplicationStarter.run(null, "Snakeo", new Dimension(1280, 700), new Main());
    }
    
}
