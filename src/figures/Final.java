package figures;

import game.GameField;

import java.awt.*;

public class Final extends Figure{
    public Final(Color innerColor, Color outlineColor) {
        super(innerColor, outlineColor, false);
    }

    @Override
    public boolean isValidMove(int currentX, int currentY, int xDesired, int yDesired) {
        return this.canMove;
    }

    @Override
    public boolean move(int xDesired, int yDesired, GameField[][] gameFields) {
        return false;
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D=(Graphics2D)g ;
        drawFigure(graphics2D);
        fillFigure(graphics2D);
    }

    private void drawFigure(Graphics2D graphics2D){
        graphics2D.setColor(outlineColor);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawOval(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }
    private void fillFigure(Graphics2D graphics2D){
        graphics2D.setColor(innerColor);
        graphics2D.fillOval(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }
}
