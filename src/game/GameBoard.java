package game;

import figures.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameBoard extends JFrame implements MouseListener {

    private final Color[][] fieldColors = {{Color.RED, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.RED},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.DARK_GRAY, Color.RED, Color.WHITE, Color.RED, Color.DARK_GRAY}};

    private final Figure[][] figures = {
            {new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Leader(Color.YELLOW, Color.GREEN)},
            {null, null, null, null, null},
            {null, null, new Final(Color.GRAY, Color.GRAY), null, null},
            {null, null, null, null, null},
            {new Leader(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW)}
    };

    private final GameField[][] gameFields = new GameField[5][5];

    private Figure selectedFigure = null;


    public GameBoard() throws HeadlessException {
        super("ГрогНок vs СитенПушан");
        initWindow();
        generateTurtles();
        initFields();
        super.addMouseListener(this);

    }


    /*
    generate game window
     */
    private void initWindow() {
        super.setSize(500, 500);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
        Generate turtles
     */
    private void generateTurtles() {
        Turtle[] turtles = {new Turtle(Color.WHITE, Color.RED), new Turtle(Color.WHITE, Color.RED)};

        Random random = new Random();
        for (Turtle turtle : turtles) {
            int randomN = random.nextInt(5);

            while (figures[2][randomN] != null) {
                randomN = random.nextInt(5);
            }

            this.figures[2][randomN] = turtle;
        }
    }

    /*
    initialization of the fields
     */
    private void initFields() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                Figure figure = this.figures[row][col];

                if (figure != null) {
                    figure.setX(col);
                    figure.setY(row);
                }
                GameField gameField = new GameField(col, row, fieldColors[row][col], figure);
                this.gameFields[row][col] = gameField;
            }
        }
    }

    /*
    render the game
    */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                gameFields[row][col].render(g);
            }
        }

    }

    /*
   moving the figure
    */
    private void move(int bufferedFigureY, int bufferedFigureX, int desiredPositonY, int desiredPositionX) {
        boolean isSuccessful = this.selectedFigure.move(desiredPositionX, desiredPositonY, this.gameFields);
        if (isSuccessful) {
            this.gameFields[bufferedFigureY][bufferedFigureX].setFigure(null);
        }

    }

    /*
    show the winner
     */
    private void showWinner(Color colorOfTheWinner) {
        String msg = String.format("The winners are: %s frogs", colorOfTheWinner.equals(Color.YELLOW) ? "Yellow" : "Green");
        JOptionPane.showMessageDialog(this, msg, "The winners are....", JOptionPane.INFORMATION_MESSAGE);

    }


    /*
    event handler on mouse click
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / GameField.FIELD_SIZE;
        int row = e.getY() / GameField.FIELD_SIZE;

        GameField chosenField = gameFields[row][col];

        if (selectedFigure == null) {
            this.selectedFigure = chosenField.getFigure();

        } else {

            int selectedFigureX = selectedFigure.getX();
            int selectedFigureY = selectedFigure.getY();

            if (selectedFigure.isValidMove(selectedFigureX, selectedFigureY, col, row)) {

                if (chosenField.getFigure() == null) {
                    this.move(selectedFigureY, selectedFigureX, row, col);
                    super.repaint();

                } else {
                    if (chosenField.getFigure() instanceof Turtle) {
                        chosenField.setFigure(null);
                        gameFields[selectedFigureY][selectedFigureX].setFigure(null);
                    } else if (chosenField.getFigure() instanceof Final && this.selectedFigure instanceof Leader) {
                        this.showWinner(this.selectedFigure.getInnerColor());
                        System.exit(0);
                    }

                    super.repaint();
                }

            }
            selectedFigure = null;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
