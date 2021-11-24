package cellularAutomaton.immigration;

import gui.GUISimulator;

import java.awt.*;

public class TestImmigrationSimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(1000, 1000, Color.BLACK);
        ImmigrationSimulator c = new ImmigrationSimulator(gui, 4);
        gui.setSimulable(c);
    }
}
