package csc22100.cellularautomata;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO: Add at least two tests for your Automaton class.
 * <p>
 * I like to use Assertj for my assertions, so I have my test classes "implement WithAssertions" (see TestSimulator for an example).
 * If you'd like to use assertj, you can refer to https://assertj.github.io/doc/#assertj-core-assertions-guide
 * <p>
 * I've imported the JUnit5 assertions already. You can see the full list of assertion functions at
 * https://junit.org/junit5/docs/current/api/org.junit.jupiter.api/org/junit/jupiter/api/Assertions.html
 */
public class TestAutomaton {

    @Test
    public void Test1() {
        Automaton automaton = new Automaton(60, 5);
        automaton.step();
        automaton.step();
        assertEquals("[0, 0, 1, 0, 1]", Arrays.toString(automaton.getState()));
    }

    @Test
    public void Test2() {
        Automaton automaton = new Automaton(0, 5);
        for (int i = 0; i < 50000; i++) {
            automaton.step();
        }
        assertEquals("[0, 0, 0, 0, 0]", Arrays.toString(automaton.getState()));
    }

    @Test
    public void Test3() {
        Automaton automaton = new Automaton(1, new int[]{1});
        for (int i = 0; i < 10001; i++) {
            automaton.step();
        }
        assertEquals("[0]", Arrays.toString(automaton.getState()));
    }

    @Test
    public void Test4() {
        Automaton automaton = new Automaton(1, new int[]{1});
        for (int i = 0; i < 10000; i++) {
            automaton.step();
        }
        assertEquals("[1]", Arrays.toString(automaton.getState()));
    }

    @Test
    public void Test5() {
        Automaton automaton = new Automaton(1, new int[]{0,1,1,0,0,0,1,0,1,0,0});
        for (int i = 0; i < 3; i++) {
            automaton.step();
        }
        assertEquals("[0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]", Arrays.toString(automaton.getState()));
    }

}
