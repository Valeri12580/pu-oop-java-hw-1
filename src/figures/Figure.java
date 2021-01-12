package figures;

import java.awt.*;


public abstract class Figure {
    protected Color innerColor;
    protected Color outlineColor;
    public static final int FIGURE_SIZE=40;
    protected int x;
    protected int y;


    public Figure(Color innerColor, Color outlineColor, int x, int y) {
        this.innerColor = innerColor;
        this.outlineColor = outlineColor;
        this.x = x;
        this.y = y;

    }

    public abstract void render(Graphics g);


}
