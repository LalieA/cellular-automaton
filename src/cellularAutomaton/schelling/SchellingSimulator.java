package cellularAutomaton.schelling;

import cellularAutomaton.Simulator;
import gui.GUISimulator;

import java.awt.*;

public class SchellingSimulator extends Simulator {

    public SchellingSimulator(GUISimulator gui, int nb_states, int max_neighbors) {
        super(gui, new SchellingGrid(gui, Color.decode("#323232"), Color.decode("#f7f7f7"), Color.decode("#0d6800"), nb_states, max_neighbors));
    }
}
