package cellularAutomaton.immigration;

import cellularAutomaton.Grid;
import gui.GUISimulator;

import java.awt.*;
import java.util.Random;

public class ImmigrationGrid extends Grid {
    public ImmigrationGrid(GUISimulator gui, Color strokeColor, Color bgColor, Color activeColor, int nb_states) {
        super(gui, strokeColor, bgColor, activeColor, nb_states);
    }

    @Override
    public void reInitCells() {
        Random rd = new Random();
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                int n = getNbStates();
                setCell(new ImmigrationCell(rd.nextInt(n), i, j, n), i, j);
            }
        }
    }
}
