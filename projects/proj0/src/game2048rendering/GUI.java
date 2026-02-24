package game2048rendering;

import game2048logic.Model;
import ucb.gui2.TopLevel;
import ucb.gui2.LayoutSpec;

import java.util.concurrent.ArrayBlockingQueue;

import java.awt.event.KeyEvent;

/**
 * The GUI controller for a 2048 board and buttons.
 *
 * @author P. N. Hilfinger
 */
class GUI extends TopLevel {
    /**
     * A new window with given TITLE providing a view of MODEL.
     *
     * @param title Title of the window.
     * @param model Model to be displayed.
     */
    GUI(String title, Model model) {
        super(title, true);
        addMenuButton("Game->New", this::newGame);
        addMenuButton("Game->Quit", this::quit);

        addLabel("", "Score", new LayoutSpec("y", 1));

        _model = model;

        _widget = new BoardWidget(model.size());
        add(_widget,
            new LayoutSpec("y", 0,
                           "height", "REMAINDER",
                           "width", "REMAINDER"));

        _widget.requestFocusInWindow();
        _widget.setKeyHandler("keypress", this::keyPressed);
        setPreferredFocus(_widget);
        setScore(0);
    }

    /**
     * Response to "Quit" button click.
     *
     * @param dummy Unused parameter.
     */
    private void quit(String dummy) {
        _pendingKeys.offer("Quit");
        _widget.requestFocusInWindow();
    }

    /**
     * Response to "New Game" button click.
     *
     * @param dummy Unused parameter.
     */
    private void newGame(String dummy) {
        _pendingKeys.offer("New Game");
        _widget.requestFocusInWindow();
    }

    /**
     * Respond to the user pressing key E
     * by queuing the key on our queue of pending keys.
     *
     * @param unused Unused parameter.
     * @param e Key event.
     */
    private void keyPressed(String unused, KeyEvent e) {
        _pendingKeys.offer(e.getKeyCode() + "");
    }

    /**
     * Return the next pending event, waiting for it as necessary.
     * Ordinary key presses are reported
     * as the key codes of the character pressed.
     * In addition, menu-button clicks result in
     * the messages "Quit" or "New Game".
     *
     * @return Next pending key event.
     */
    private String readKey() {
        try {
            return _pendingKeys.take();
        } catch (InterruptedException e) {
            throw new Error("unexpected interrupt");
        }
    }

    /**
     * Return which direction arrow was pressed.
     *
     * @return Direction arrow pressed.
     */
    String getKey() {
        String command = readKey();
        switch (command) {
            case "↑" -> command = "Up";
            case "→" -> command = "Right";
            case "↓" -> command = "Down";
            case "←" -> command = "Left";
            default -> { }
        }

        return command;
    }

    /**
     * Set the current score being displayed to SCORE.
     *
     * @param score Score to be displayed.
     */
    private void setScore(int score) {
        setLabel("Score", String.format("Score: %6d", score));
    }

    /**
     * Plays an animation to update the GUI to the new state of the board.
     */
    void update() {
        _widget.update(_model);
        setScore(_model.score());
    }

    /** The board widget. */
    private final BoardWidget _widget;

    /** The game model being viewed. */
    private final Model _model;

    /** Queue of pending key presses. */
    private final ArrayBlockingQueue<String> _pendingKeys =
            new ArrayBlockingQueue<>(5);
}
