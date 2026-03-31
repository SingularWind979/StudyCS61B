package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A client that uses the synthesizer package
 * to replicate a plucked guitar string sound
 *
 * @author Eli Lipsitz
 */
public class GuitarHeroLite {
    /** Size of the drawing window. */
    private static final int WIDTH = 512;
    private static final int HEIGHT = 512;
    private static final Color PEN_COLOR = StdDraw.BLACK;
    private static final double PEN_RADIUS = 0.05;

    /** Set up the drawing window. */
    private static void setDrawingWindow() {
        StdDraw.setCanvasSize(WIDTH, HEIGHT);
        StdDraw.setXscale(0, WIDTH);
        StdDraw.setYscale(0, HEIGHT);
        StdDraw.setPenColor(PEN_COLOR);
        StdDraw.setPenRadius(PEN_RADIUS);
        StdDraw.text(WIDTH / 2.0, HEIGHT / 2.0, "Play the guitar!");
    }

    /** Create all 12 guitar strings. */
    private static Map<Character, GuitarString> makeGuitarString() {
        Map<Character, GuitarString> guitarStrings = new HashMap<>();

        for (GuitarNote note : GuitarNote.values()) {
            guitarStrings.put(note.name().charAt(0), note.string);
        }

        return  guitarStrings;
    }

    /** Play the note. */
    private static void playNote(GuitarString string, String key) {
        StdDraw.clear();
        StdDraw.text(WIDTH / 2.0, HEIGHT / 2.0, key);
        StdDraw.show();
        string.pluck();
    }

    public static void main(String[] args) {
        // create all 12 guitar strings
        Map<Character, GuitarString> guitarStrings = makeGuitarString();

        // set up the drawing window
        setDrawingWindow();

        while (true) {
            // check if the user has typed a key; if so, process it
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();

                // quit the program
                if (key == 'q') {
                    System.exit(0);
                }

                // play the note
                if (guitarStrings.containsKey(key)) {
                    playNote(guitarStrings.get(key), String.valueOf(key));
                }
            }

            // compute the superposition of samples
            double sample = 0.0;
            for (GuitarString string : guitarStrings.values()) {
                sample += string.sample();
            }

            // play the sample on standard audio
            StdAudio.play(sample);

            // advance the simulation of each guitar string by one step
            for (GuitarString string : guitarStrings.values()) {
                string.tic();
            }
        }
    }
}
