package cellularAutomaton;

/**
 * A cell represents an agent unit in cellular automaton.
 * @author Équipe 35
 *
 */
public abstract class Cell {
    private final int nb_states;
    private int state;
    private int next_state;

    private final int i;
    private final int j;

    public Cell(int state, int i, int j, int nb_states) {
        this.state = state;
        this.nb_states = nb_states;
        this.i = i;
        this.j = j;
    }

    /**
     * Computes the next state of the cell according to the state of the grid
     * in which the cell evolves.
     *
     * @param  grid  the grid in which the cell evolves
     * @see         Grid
     */
    public abstract void computeNextState(Grid grid);

    /**
     * Returns the 8 neighboring cells of the grid.
     *
     * @param  grid  the grid in which the cell evolves
     *
     * @return return a tab of 8 cells
     *
     * @see         Grid
     */
    public Cell[] getNeighbors(Grid grid) {
        Cell[] neighbors = new Cell[8];
        int n = grid.getCellsLine(), m = grid.getCellsCol();
        int index = 0;
        for(int i = getI() - 1; i < getI() + 2; i++) {
            for(int j = getJ()- 1; j < getJ() + 2; j++) {
                if(!(i == getI() && j == getJ())) {
                    neighbors[index] = grid.getCell(mod(i, n), mod(j, m));
                    index++;
                }
            }
        }
        return neighbors;
    }

    /**
     * Sets the current cell's state to the last computed state.
     */
    public void setComputedNextState() { this.state = this.next_state; }

    /**
     * Sets the next state of the cell.
     *
     * @param  next_state  the next state of the cell
     */
    public void setNextState(int next_state) { this.next_state = next_state; }

    /**
     * Sets the current state of the cell.
     *
     * @param  state  the new current state of the cell
     */
    public void setState(int state) { this.state = state; }

    /**
     * Returns the next state of the cell.
     *
     * @return the next state of the cell
     */
    public int getNextState() { return this.next_state; }

    /**
     * Returns the current state of the cell.
     *
     * @return the current state of the cell
     */
    public int getState() { return this.state; }

    /**
     * Returns the number of states in which the cell can be.
     *
     * @return the number of states in which the cell can be
     */
    public int getNbStates() { return this.nb_states; }

    /**
     * Returns the line index of the cell's position on the grid.
     *
     * @return the line index of the cell's position on the grid.
     */
    public int getI() { return this.i; }

    /**
     * Returns the column index of the cell's position on the grid.
     *
     * @return the column index of the cell's position on the grid.
     */
    public int getJ() { return this.j; }

    /**
     * Returns the modulus of two integers, including for a negative parameter a.
     *
     * @param  a  the integer to be divided
     * @param  b  the integer to divide with
     *
     * @return a % b, with a potentially negative (result is >= 0)
     */
    private int mod(int a, int b) {
        if(a == -1) { return b - 1; }
        if(a == b) { return 0; }
        return a;
    }
}
