package figures;

import game.GameField;

import java.awt.*;

public abstract class Figure {
    protected Color innerColor;
    protected Color outlineColor;
    public static final int FIGURE_SIZE=40;
    protected int x;
    protected int y;
    protected boolean canMove;


    public Figure(Color innerColor, Color outlineColor,boolean canMove) {
        this.innerColor = innerColor;
        this.outlineColor = outlineColor;
        this.canMove=canMove;
    }

    /*
    checking if the move is valid(every implementation is different according to the class that extends it)
     */
    public abstract boolean isValidMove(int currentX,int currentY,int xDesired,int yDesired);

    /*
   move the figure (every implementation is different according to the class that extends it)
    */
    public abstract boolean move(int xDesired,int yDesired,GameField[][] gameFields);

    /*
    render the figure
     */
    public abstract void render(Graphics g);

    public Figure setX(int x) {
        this.x = x*GameField.FIELD_SIZE+30;
        return this;
    }

    public Figure setY(int y) {
        this.y = y*GameField.FIELD_SIZE+30;
        return this;
    }

    public int getX() {
        return x/GameField.FIELD_SIZE;
    }

    public int getY() {
        return y/GameField.FIELD_SIZE;
    }

    public Color getInnerColor() {
        return innerColor;
    }
}
