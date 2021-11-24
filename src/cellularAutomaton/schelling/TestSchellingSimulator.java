package cellularAutomaton.schelling;

import gui.GUISimulator;

import java.awt.*;

public class TestSchellingSimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(1000, 1000, Color.BLACK);
        SchellingSimulator c = new SchellingSimulator(gui, 3, 2);
        gui.setSimulable(c);
    }
}
