package cellularAutomaton.immigration;

import cellularAutomaton.Cell;
import cellularAutomaton.Grid;

public class ImmigrationCell extends Cell {
    public ImmigrationCell(int state, int i, int j, int nb_states) {
        super(state, i, j, nb_states);
    }

    @Override
    public void computeNextState(Grid grid) {
        int neighborsStateSup = 0;
        for(Cell c: getNeighbors(grid)) {
            if (c.getState() == ((getState() + 1) % getNbStates())) { neighborsStateSup++; }
        }
        if(neighborsStateSup >= 3) { setNextState((getState() + 1) % getNbStates()); }
        else { setNextState(getState()); }
    }
}
