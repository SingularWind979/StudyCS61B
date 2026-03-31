package gh2;

import deque.ArrayDeque61B;
import deque.Deque61B;

/**
 * A class that models a guitar string.
 *
 * @author Eli Lipsitz + SingularWind
 */
public class GuitarString {
    /** Constants. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /** Buffer for storing sound data. */
    private final Deque61B<Double> buffer;

    /**
     * Creates a guitar string of the given frequency.
     *
     * @param frequency The frequency of the guitar string.
     */
    public GuitarString(double frequency) {
        // check frequency is non-negative
        if (frequency < 0.0) {
            throw new IllegalArgumentException("Frequency must be non-negative");
        }

        // calculate initial capacity
        int initCapacity = (int) Math.round((SR) / frequency);

        // initialize buffer with zeros
        buffer = new ArrayDeque61B<>(initCapacity, false);
        for (int i = 0; i < initCapacity; i++) {
            buffer.addLast(0.0);
        }
    }

    /**
     * Pluck the guitar string
     * by replacing the buffer with white noise.
     */
    public void pluck() {
        for (int i = 0; i < buffer.size(); i++) {
            double whiteNoise = Math.random() - 0.5;
            buffer.removeFirst();
            buffer.addLast(whiteNoise);
        }
    }

    /**
     * Advance the simulation one time step
     * by performing one iteration of the Karplus-Strong algorithm.
     */
    public void tic() {
        double sample1 = buffer.removeFirst();
        double sample2 = buffer.getFirst();
        double newSample = 0.5 * (sample1 + sample2) * DECAY;
        buffer.addLast(newSample);
    }

    /**
     * Returns the double at the front of the buffer one time step.
     *
     * @return The double at the front of the buffer.
     */
    public double sample() {
        return buffer.getFirst();
    }
}
