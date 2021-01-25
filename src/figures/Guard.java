package figures;

import game.GameField;

import java.awt.*;

public class Guard extends Figure {
    public Guard(Color innerColor, Color outlineColor) {
        super(innerColor, outlineColor,true);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D = (Graphics2D) g;
        fillFigure(graphics2D);
        drawFigure(graphics2D);

    }

    /*
    fill the figure
     */
    private void fillFigure(Graphics2D graphics2D) {
        graphics2D.setColor(innerColor);
        graphics2D.fillOval(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }

    /*
    draw the figure
     */
    private void drawFigure(Graphics2D graphics2D) {
        graphics2D.setColor(outlineColor);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawOval(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }

    @Override
    public boolean isValidMove(int currentX, int currentY, int xDesired, int yDesired) {

        if(!super.canMove){
            return false;
        }
        int resultX = Math.abs(currentX - xDesired);
        int resultY = Math.abs(currentY - yDesired);

        return ((resultX == 1 && resultY == 0) || (resultX == 0 && resultY == 1));
    }

    @Override
    public boolean move(int xDesired, int yDesired, GameField[][] gameFields) {
        this.setX(xDesired);
        this.setY(yDesired);
        gameFields[yDesired][xDesired].setFigure(this);
        return true;
    }
}
