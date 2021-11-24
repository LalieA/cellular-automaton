package cellularAutomaton.conway;

import cellularAutomaton.Cell;
import cellularAutomaton.Grid;

public class ConwayCell extends Cell {
    public ConwayCell(int state, int i, int j) {
        super(state, i, j, 2);
    }

    @Override
    public void computeNextState(Grid grid) {
        boolean res;
        int neighborsAlive = 0;
        for(Cell c: getNeighbors(grid)) {
            if (c.getState() == 1) {
                neighborsAlive++;
            }
        }
        if(getState() == 0 && neighborsAlive == 3) { res = true; }
        else res = (getState() == 1) && (neighborsAlive == 2 || neighborsAlive == 3);

        setNextState(res ? 1 : 0);
    }
}
