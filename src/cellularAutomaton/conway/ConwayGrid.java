package cellularAutomaton.conway;

import cellularAutomaton.Grid;
import gui.GUISimulator;

import java.awt.*;
import java.util.Random;


public class ConwayGrid extends Grid {
    public ConwayGrid(GUISimulator gui, Color strokeColor, Color bgColor, Color activeColor, int nb_states) {
        super(gui, strokeColor, bgColor, activeColor, nb_states);
    }

    public void reInitCells() {
        Random rd = new Random();
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                setCell(new ConwayCell(rd.nextBoolean() ? 1 : 0, i, j), i, j);
            }
        }
    }
}
