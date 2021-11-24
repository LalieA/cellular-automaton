package cellularAutomaton;

import gui.GUISimulator;
import gui.Rectangle;

import java.awt.*;

/**
 * A grid represents an environment for cells' evolution in cellular automaton.
 * @author Équipe 35
 *
 * @see Cell
 */
public abstract class Grid {
    public static final int CELL_SIZE = 50;

    private final int cells_line;
    private final int cells_col;
    private final int nb_states;
    private final Color strokeColor;
    private final Color bgColor;
    private final Color activeColor;

    private final GUISimulator gui;

    private final Cell[][] cell_grid;

    public Grid(GUISimulator gui, Color strokeColor, Color bgColor, Color activeColor, int nb_states) {
        this.gui = gui;
        this.strokeColor = strokeColor;
        this.bgColor = bgColor;
        this.activeColor = activeColor;
        this.nb_states = nb_states;

        this.cells_line = gui.getPanelWidth() / CELL_SIZE;
        this.cells_col = gui.getPanelHeight() / CELL_SIZE;

        this.cell_grid = new Cell[cells_col][cells_line];
    }

    /**
     * Computes and sets the next state of each cell of the grid.
     */
    public void refreshCells() throws Exception {
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                getCell(i, j).computeNextState(this);
            }
        }
        for(int i = 0; i < getCellsCol(); i++) {
            for(int j = 0; j < getCellsLine(); j++) {
                getCell(i, j).setComputedNextState();
            }
        }
    }

    /**
     * Returns the color corresponding to a state.
     *
     * @param  state  the state of which we want to color
     * @param  nb_states  the number of states a cell can be.
     *
     * @return  the corresponding Color object
     *
     * @see         Color
     */
    public Color getStateColor(int state, int nb_states) { // Color interpolation
        double x = (double) state / (nb_states - 1);
        Color a = getBgColor(), b = getActiveColor();
        float new_red = (float) (b.getRed() * x + a.getRed() * (1 - x));
        float new_green = (float) (b.getGreen() * x + a.getGreen() * (1 - x));
        float new_blue = (float) (b.getBlue() * x + a.getBlue() * (1 - x));
        return new Color(new_red / 255, new_green / 255, new_blue / 255);
    }

    /**
     * Draws the entire grid with cells' states.
     */
    public void drawGrid() {
        for(int i = 0; i < getCellsLine(); i++) {
            for(int j = 0; j < getCellsCol(); j++) {
                Color c = getStateColor(getCell(i, j).getState(), getCell(i, j).getNbStates());
                getGui().addGraphicalElement(
                        new Rectangle(j * CELL_SIZE + CELL_SIZE / 2, i * CELL_SIZE + CELL_SIZE / 2, getStrokeColor(), c, CELL_SIZE)
                );
            }
        }
    }

    /**
     * (Re)Generates a grid with cells on a random state.
     */
    public abstract void reInitCells();

    /**
     * Returns the Graphical User Interface object.
     *
     * @return the GUI Simulator
     *
     * @see GUISimulator
     */
    public GUISimulator getGui() { return this.gui; }

    /**
     * Sets the cell at line index i and column index j.
     *
     * @param  c  the cell to set
     * @param  i  the line index
     * @param  j  the column index
     *
     * @see         Cell
     */
    public void setCell(Cell c, int i, int j) { this.cell_grid[i][j] = c; }

    /**
     * Returns the cell at line index i and column index j.
     *
     * @param  i  the line index
     * @param  j  the column index
     *
     * @return the cell at index (i, j)
     *
     * @see         Cell
     */
    public Cell getCell(int i, int j) { return cell_grid[i][j]; }

    /**
     * Returns the color used for the grid's background
     *
     * @return the corresponding Color object
     *
     * @see         Color
     */
    public Color getBgColor() { return this.bgColor; }

    /**
     * Returns the color used for the grid's strokes
     *
     * @return the corresponding Color object
     *
     * @see         Color
     */
    public Color getStrokeColor() { return this.strokeColor; }

    /**
     * Returns the color used for the active cells
     *
     * @return the corresponding Color object
     *
     * @see         Color
     */
    public Color getActiveColor() { return this.activeColor; }

    /**
     * Returns the number of cells per lines
     *
     * @return the number of cells per lines
     */
    public int getCellsLine() { return this.cells_line; }

    /**
     * Returns the number of cells per columns
     *
     * @return the number of cells per columns
     */
    public int getCellsCol() { return this.cells_col; }

    /**
     * Returns the number of states in which a cell of the grid can be.
     *
     * @return the number of states in which a cell of the grid can be
     */
    public int getNbStates() { return this.nb_states; }
}
