package cellularAutomaton.conway;

import cellularAutomaton.Simulator;
import gui.GUISimulator;

import java.awt.*;

public class ConwaySimulator extends Simulator {
    public ConwaySimulator(GUISimulator gui) {
        super(gui, new ConwayGrid(gui, Color.decode("#323232"), Color.decode("#f7f7f7"), Color.decode("#0d6800"), 2));
    }
}
