package figures;

import game.GameField;

import java.awt.*;

public class Leader extends Figure {

    public Leader(Color innerColor, Color outlineColor) {
        super(innerColor, outlineColor);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(innerColor);
        g.fillRect(x, y, Figure.FIGURE_SIZE, Figure.FIGURE_SIZE);
    }

    @Override
    public boolean isValidMove(int currentX, int currentY, int xDesired, int yDesired) {

        int resultX = Math.abs(currentX - xDesired);
        int resultY = Math.abs(currentY - yDesired);

        return (resultX > 0 && resultY == 0) || (resultX == 0 && resultY > 0);

    }

    @Override
    public boolean move(int xDesired, int yDesired, GameField[][] gameFields) {
        int cycleX = xDesired - this.getX();
        int cycleY = yDesired - this.getY();

        int lastFreePosition;

        if (cycleX != 0) {

            lastFreePosition = this.getX();
            if (cycleX > 0) {

                while (4 > lastFreePosition && gameFields[this.getY()][lastFreePosition + 1].getFigure() == null) {

                    lastFreePosition++;

                }
            } else {
                while (lastFreePosition > 0 && gameFields[this.getY()][lastFreePosition - 1].getFigure() == null) {
                    lastFreePosition--;
                }
            }

            this.setPosition(lastFreePosition, yDesired);
            gameFields[yDesired][lastFreePosition].setFigure(this);
            return lastFreePosition == this.getX();
        } else {
            lastFreePosition = this.getY();

            if (cycleY > 0) {

                while (4 > lastFreePosition && gameFields[lastFreePosition + 1][this.getX()].getFigure() == null) {

                    lastFreePosition++;

                }
            } else {
                while (lastFreePosition > 0 && gameFields[lastFreePosition - 1][this.getX()].getFigure() == null) {
                    lastFreePosition--;
                }
            }

            this.setPosition(xDesired, lastFreePosition);
            gameFields[lastFreePosition][xDesired].setFigure(this);
            return lastFreePosition == this.getY();

        }

    }

    private void setPosition(int x, int y) {
        this.setX(x);
        this.setY(y);
    }
}
