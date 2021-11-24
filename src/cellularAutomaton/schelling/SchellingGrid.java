package cellularAutomaton.schelling;

import cellularAutomaton.Cell;
import cellularAutomaton.Grid;
import gui.GUISimulator;

import java.awt.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SchellingGrid extends Grid {
    public final int max_neighbors;
    public Set<Cell> free_cells = new HashSet<>();

    public SchellingGrid(GUISimulator gui, Color strokeColor, Color bgColor, Color activeColor, int nb_states, int max_neighbors) {
        super(gui, strokeColor, bgColor, activeColor, nb_states);
        this.max_neighbors = max_neighbors;
    }

    @Override
    public void refreshCells() throws Exception {
        Set<Cell> cells_to_move = new HashSet<>();
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                Cell c = getCell(i, j);
                if(c.getState() != 0) {
                    c.computeNextState(this);
                    if(c.getNextState() == 0) {
                        cells_to_move.add(c);
                    }
                }
            }
        }
        for(int i = 0; i < getCellsCol(); i++) {
            for(int j = 0; j < getCellsLine(); j++) {
                Cell free_cell, c = getCell(i, j);
                if(cells_to_move.contains(c)) {
                    cells_to_move.remove(c);
                    if(free_cells.isEmpty()) { throw new Exception("No more free cells available, please rerun simulation with more free cells."); }
                    Random rd = new Random();
                    // Get a random,new home
                    free_cell = (Cell) free_cells.toArray()[rd.nextInt(free_cells.size())];
                    // Déménagement
                    free_cell.setNextState(c.getState());
                    free_cell.setComputedNextState();
                    free_cell.setNextState(c.getState());
                    free_cells.remove(free_cell);
                }
                c.setComputedNextState();
                if(c.getState() == 0) { this.free_cells.add(c); }
            }
        }
    }

    @Override
    public void reInitCells() {
        Random rd = new Random();
        this.free_cells.clear();
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                int n = getNbStates();
                int random_state = rd.nextInt(n);
                Cell new_cell = new SchellingCell(random_state, i, j, n, this.max_neighbors);
                if(new_cell.getState() == 0) { this.free_cells.add(new_cell); }
                setCell(new_cell, i, j);
            }
        }
    }
}
