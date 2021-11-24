package cellularAutomaton.schelling;

import cellularAutomaton.Cell;
import cellularAutomaton.Grid;

public class SchellingCell extends Cell {
    private final int max_neighbors;
    public SchellingCell(int state, int i, int j, int nb_states, int max_neighbors) {
        super(state, i, j, nb_states);
        this.max_neighbors = max_neighbors;
    }

    @Override
    public void computeNextState(Grid grid) {
        int diff_neighbors = 0;
        for(Cell c: getNeighbors(grid)) {
            if (c.getState() != 0 && c.getState() != getState()) { diff_neighbors++; }
        }
        if(diff_neighbors > this.max_neighbors) { setNextState(0); }
        else { setNextState(getState()); }
    }
}
