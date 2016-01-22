/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeo.levels;

import grid.Grid;
import java.awt.Color;
import java.util.ArrayList;
import snakeo.Barrier;
import snakeo.CellDataProviderIntf;

/**
 *
 * @author panpjp
 */
public class lv1 {
    private final Grid grid;
    ArrayList<Object> barriers;

    public lv1(Grid grid) {
        this.barriers = new ArrayList<>();
        barriers.add(new Barrier(1, 1, Color.BLACK, (CellDataProviderIntf) this, false));
    }
    
}
