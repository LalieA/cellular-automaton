package cellularAutomaton.immigration;

import cellularAutomaton.Simulator;
import gui.GUISimulator;

import java.awt.*;

public class ImmigrationSimulator extends Simulator {
    public ImmigrationSimulator(GUISimulator gui, int nb_states) {
        super(gui, new ImmigrationGrid(gui, Color.decode("#323232"), Color.decode("#f7f7f7"), Color.decode("#0d6800"), nb_states));
    }
}
