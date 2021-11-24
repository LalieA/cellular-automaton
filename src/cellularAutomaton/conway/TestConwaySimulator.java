package cellularAutomaton.conway;

import gui.GUISimulator;
import java.awt.*;

public class TestConwaySimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(1000, 1000, Color.BLACK);
        ConwaySimulator c = new ConwaySimulator(gui);
        gui.setSimulable(c);
    }
}
