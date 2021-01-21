package game;

import figures.Figure;
import figures.Guard;
import figures.Leader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends JFrame implements MouseListener {

    private final Color[][] fieldColors = {{Color.RED, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.RED},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.DARK_GRAY, Color.RED, Color.WHITE, Color.RED, Color.DARK_GRAY}};

    private final Figure[][] figures = {
            {new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Guard(Color.YELLOW, Color.GREEN), new Leader(Color.YELLOW, Color.GREEN)},
            {null, null, null, null, null},
            {null, null, new Guard(Color.GRAY, Color.GRAY), null, null},
            {null, null, null, null, null},
            {new Leader(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW), new Guard(Color.GREEN, Color.YELLOW)}
    };

    private GameField[][] gameFields = new GameField[5][5];

    private Figure selectedFigure = null;


    public GameBoard() throws HeadlessException {
        super("ГрогНок vs СитенПушан");
        initWindows();
        initFields();
        super.addMouseListener(this);

    }


    /*
    generate game window
     */
    private void initWindows() {
        super.setSize(500, 500);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    event handler on mouse click
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        int col = e.getX() / GameField.FIELD_SIZE;
        int row = e.getY() / GameField.FIELD_SIZE;

        if (selectedFigure == null) {
            this.selectedFigure = gameFields[row][col].getFigure();

        } else {

            int selectedFigureX = selectedFigure.getX();
            int selectedFigureY = selectedFigure.getY();

            if (selectedFigure.isValidMove(selectedFigureX, selectedFigureY, col, row) && gameFields[row][col].getFigure() == null) {
                this.move(selectedFigureY, selectedFigureX, row, col);
                super.repaint();

            } else {
                System.out.println("not valid");
            }

            selectedFigure = null;
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
