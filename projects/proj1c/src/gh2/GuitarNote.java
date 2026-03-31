package gh2;

/**
 * The sound of guitar strings.
 *
 * @author SingularWind
 */
public enum GuitarNote {
    /** The constants for the guitar note frequencies. */
    C(-9), c(-8), D(-7), d(-6),
    E(-5), F(-4), f(-3), G(-2),
    g(-1), A(0), a(1), B(2);

    /** The frequency of the A note, the reference frequency. */
    private static final double CONCRETE_A = 440.0;
    /** The index of the note. */
    private static final int NOTE_CNT = 12;

    /** The frequency of the note. */
    public final double frequency;
    /** The guitar string of the note. */
    public final GuitarString string;

    /**
     * Constructs a new note with the given index.
     * The index is the number of semitones away from the A note.
     *
     * @param index the index of the note
     */
    GuitarNote(int index) {
        frequency = CONCRETE_A * Math.pow(2, (double) index / NOTE_CNT);
        string = new GuitarString(frequency);
    }
}
