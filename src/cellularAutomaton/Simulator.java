package cellularAutomaton;

import gui.GUISimulator;
import gui.Simulable;

public class Simulator implements Simulable {
    protected GUISimulator gui;
    protected Grid grid;

    public Simulator(GUISimulator gui, Grid grid) {
        this.gui = gui;
        this.grid = grid;
        this.grid.reInitCells();
        this.grid.drawGrid();
    }


    @Override
    public void next() {
        this.gui.reset();
        try {
            this.grid.refreshCells();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.grid.drawGrid();
    }

    @Override
    public void restart() {
        this.grid.reInitCells();
        this.grid.drawGrid();
    }
}
