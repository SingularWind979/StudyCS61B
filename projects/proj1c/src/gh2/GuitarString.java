package gh2;

// TODO: maybe more imports

import deque.Deque61B;

//Note: This file will not compile until you complete the Deque61B implementations

/**
 * A class that models a guitar string.
 *
 * @author Eli Lipsitz
 */
public class GuitarString {
    /** Constants. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    // TODO: uncomment the following member once you're ready to start this portion
    /** Buffer for storing sound data. */
    private Deque61B<Double> buffer;

    /**
     * Creates a guitar string of the given frequency.
     *
     * @param frequency The frequency of the guitar string.
     */
    public GuitarString(double frequency) {
        // TODO:
        //  Initialize the buffer with capacity = SR / frequency.
        //  You'll need to cast the result of this division operation into an int.
        //  For better accuracy, use the Math.round() function before casting.
        //  Your should initially fill your buffer with zeros.
    }

    /**
     * Pluck the guitar string
     * by replacing the buffer with white noise.
     */
    public void pluck() {
        // TODO:
        //  Dequeue everything in buffer,
        //  and replace with random numbers between -0.5 and 0.5.
        //  You can get such a number by using:
        //  double r = Math.random() - 0.5;
        //
        // Make sure that your random numbers are different from each other.
        // This does not mean that you need to check that the numbers are different from each other.
        // It means you should repeatedly call Math.random() - 0.5
        // to generate new random numbers for each array index.
    }

    /**
     * Advance the simulation one time step
     * by performing one iteration
     * of the Karplus-Strong algorithm.
     */
    public void tic() {
        // TODO:
        //  Dequeue the front sample and enqueue a new sample
        //  that is the average of the two multiplied by the DECAY factor.
        //  **Do not call StdAudio.play().**
    }

    /**
     * Returns the double at the front of the buffer.
     *
     * @return The double at the front of the buffer.
     */
    public double sample() {
        // TODO: Return the correct thing.
        return 0;
    }
}
    // TODO: Remove all comments that say TODO when you're done.
