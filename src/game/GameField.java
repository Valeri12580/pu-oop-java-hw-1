package game;

import figures.Figure;

import java.awt.*;

public class GameField {
    private Figure figure;
    private int x;
    private int y;
    public static final int FIELD_SIZE = 100;
    private Color color;


    public GameField(int x, int y, Color color, Figure figure) {
        this.x = x * GameField.FIELD_SIZE;
        this.y = y * GameField.FIELD_SIZE;
        this.color = color;
        this.figure = figure;


    }


    /*
    render the specific field with the figure within it(if its not null)
     */
    public void render(Graphics g) {
        this.fill(this.color, g);
        this.draw(g);
        if (figure != null) {
            this.figure.render(g);

        }


    }


    /*
    fill the field
     */
    private void fill(Color color, Graphics g) {
        g.setColor(color);
        g.fillRect(this.x, this.y, GameField.FIELD_SIZE, GameField.FIELD_SIZE);
    }

    /*
    draw the field
     */
    private void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(this.x, this.y, GameField.FIELD_SIZE, GameField.FIELD_SIZE);
    }

    public Figure getFigure() {
        return figure;
    }

    public GameField setFigure(Figure figure) {
        this.figure = figure;
        return this;
    }
}
