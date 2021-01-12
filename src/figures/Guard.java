package figures;

import java.awt.*;

public class Guard  extends Figure{
    public Guard(Color innerColor, Color outlineColor, int x, int y) {
        super(innerColor, outlineColor, x, y);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D graphics2D=(Graphics2D)g;
        graphics2D.setColor(innerColor);
        graphics2D.fillOval(x,y,Figure.FIGURE_SIZE,Figure.FIGURE_SIZE);
        graphics2D.setColor(outlineColor);
        graphics2D.setStroke(new BasicStroke(3));
        graphics2D.drawOval(x,y,Figure.FIGURE_SIZE,Figure.FIGURE_SIZE);

    }
}
