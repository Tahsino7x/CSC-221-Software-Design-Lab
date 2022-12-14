/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package csc22100.cellularautomata;

/**
 * Main Class.
 */
public class Main {

    /**
     * This method reads three integers from the args array (in this order):
     * the rule number, the number of iterations and the width of the automaton to display and simulate
     * 1-dimensional elementary cellular automaton.
     *
     * @param args arguments.
     * @throws Exception if incorrect or invalid number of arguments.
     */
    public static void main(String[] args) throws Exception {

        //Handling invalid number of arguments
        if (args.length < 3) {
            throw new Exception("Invalid number of arguments");
        }

        //Handling Incorrect arguments and simulating
        try {
            int rule = Integer.parseInt(args[0]);
            int numIterations = Integer.parseInt(args[1]);
            int width = Integer.parseInt(args[2]);

            //rule and numIterations cannot be negative, and width cannot be zero.
            if (rule < 0 || numIterations < 0 || width < 1) {
                throw new NumberFormatException();
            }

            Simulator simulator = new Simulator(rule, width, numIterations);
            simulator.run();

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Incorrect arguments");
        }

    }
}
