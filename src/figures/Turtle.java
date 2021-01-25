package figures;

import game.GameField;

import java.awt.*;

public class Turtle extends Figure {

    public Turtle(Color innerColor, Color outlineColor) {
        super(innerColor, outlineColor, false);
    }

    @Override
    public boolean isValidMove(int currentX, int currentY, int xDesired, int yDesired) {

        return super.canMove;
    }

    @Override
    public boolean move(int xDesired, int yDesired, GameField[][] gameFields) {
        return false;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setColor(outlineColor);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawOval(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }
}
