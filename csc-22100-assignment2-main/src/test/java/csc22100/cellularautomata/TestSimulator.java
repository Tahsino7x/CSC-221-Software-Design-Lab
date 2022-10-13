package csc22100.cellularautomata;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TestSimulator implements WithAssertions {
    private ByteArrayOutputStream outBytes;
    private ByteArrayOutputStream errBytes;

    private final PrintStream originalStdOut = System.out;
    private final PrintStream originalStdErr = System.err;

    @BeforeEach
    public void captureStreams() {
        outBytes = new ByteArrayOutputStream();
        errBytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outBytes));
        System.setErr(new PrintStream(errBytes));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalStdOut);
        System.setErr(originalStdErr);
    }

    @Test
    public void testSimulatorNoGenerations() {
        Simulator simulator = new Simulator(110, 20, 0);
        String expected = "OOOOOOOOOOXOOOOOOOOO\n";

        simulator.run();

        assertThat(outBytes.toString()).isEqualTo(expected);
    }

    @Test
    public void testSimulator() {
        Simulator simulator = new Simulator(110, 20, 10);
        String expected = "OOOOOOOOOOXOOOOOOOOO\n" +
                "OOOOOOOOOXXOOOOOOOOO\n" +
                "OOOOOOOOXXXOOOOOOOOO\n" +
                "OOOOOOOXXOXOOOOOOOOO\n" +
                "OOOOOOXXXXXOOOOOOOOO\n" +
                "OOOOOXXOOOXOOOOOOOOO\n" +
                "OOOOXXXOOXXOOOOOOOOO\n" +
                "OOOXXOXOXXXOOOOOOOOO\n" +
                "OOXXXXXXXOXOOOOOOOOO\n" +
                "OXXOOOOOXXXOOOOOOOOO\n";

        simulator.run();
        assertThat(outBytes.toString()).isEqualTo(expected);
    }

    @Test
    public void testSimulatorSillyCase() {
        Simulator simulator = new Simulator(1, 1, 0);
        String expected = "X\n";
        simulator.run();

        assertThat(outBytes.toString()).isEqualTo(expected);
    }

    @Test
    public void testSimulatorCornerCase1() {
        Simulator simulator = new Simulator(0, 1, 0);
        String expected = "X\n";
        simulator.run();

        assertThat(outBytes.toString()).isEqualTo(expected);
    }

    @Test
    public void testSimulatorCornerCase2() {
        Simulator simulator = new Simulator(255, 1, 10);
        String expected = "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n" +
                "X\n";
        simulator.run();

        assertThat(outBytes.toString()).isEqualTo(expected);
    }

    @Test
    public void testSimulatorCornerCase3() {
        Simulator simulator = new Simulator(0, 1, 10);
        String expected = "X\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n" +
                "O\n";
        simulator.run();

        assertThat(outBytes.toString()).isEqualTo(expected);
    }
}
