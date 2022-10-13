package csc22100.cellularautomata;

/**
 * Simulator for 1-dimensional elementary cellular automaton.
 */
public class Simulator implements Runnable {

    private Automaton automaton;
    private int numIterations;

    /**
     * Constructor for simulator.
     *
     * @param rule describes the rules for the automaton.
     * @param width length of 1-dimensional elementary cellular automaton.
     * @param numIterations number of iterations for calculating next generation.
     */
    public Simulator(int rule, int width, int numIterations) {
        automaton = new Automaton(rule, width);
        this.numIterations = numIterations;
    }

    /**
     * Implementation of run method.
     */
    public void run() {
        for (int i = 0; i < numIterations; i++) {
            for (int state : automaton.getState()) {
                if (state == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
            automaton.step();
        }

        // if the number of iterations is 0, printing the starting state
        if (numIterations == 0) {
            for (int state : automaton.getState()) {
                if (state == 0) {
                    System.out.print("O");
                } else {
                    System.out.print("X");
                }
            }
            System.out.print("\n");
        }
    }
}
