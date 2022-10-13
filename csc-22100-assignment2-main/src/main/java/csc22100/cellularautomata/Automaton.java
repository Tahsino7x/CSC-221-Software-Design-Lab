package csc22100.cellularautomata;

/**
 * This class is the implementation of 1-dimensional elementary cellular automaton.
 */
public class Automaton {

    private int rule;
    private int[] state;

    /**
     * Default constructor.
     * Set middle cell's state to ON.
     *
     * @param rule describes the rules for the automaton.
     * @param width length of 1-dimensional elementary cellular automaton.
     */
    public Automaton(int rule, int width) {
        this.rule = rule;
        state = new int[width];
        state[width / 2] = 1;
    }

    /**
     * This constructor initiate an automaton with predetermine states.
     *
     * @param rule describes the rules for the automaton.
     * @param state predetermine states of 1-dimensional elementary cellular automaton.
     */
    public Automaton(int rule, int[] state) {
        this.rule = rule;
        this.state = state;
    }

    /**
     * Upgrade the automaton states to the next generation.
     */
    public void step() {
        int[] nextGen = new int[state.length];

        for (int i = 0; i < state.length; i++) {

            //circularly getting previous and next
            int previous = state[(i - 1 + state.length) % state.length];
            int current = state[(i + state.length) % state.length];
            int next = state[(i + 1 + state.length) % state.length];

            // calculating next generation for ith cell
            String binaryString = String.valueOf(previous) + String.valueOf(current) + String.valueOf(next);
            int ruleSet = Integer.parseInt(binaryString, 2);
            nextGen[i] = (rule & (1 << ruleSet)) > 0 ? 1 : 0;
        }

        // copying back to state array
        for (int i = 0; i < state.length; i++) {
            state[i] = nextGen[i];
        }
    }

    /**
     * Getter method for state array.
     * @return state array
     */
    public int[] getState() {
        return state;
    }
}
