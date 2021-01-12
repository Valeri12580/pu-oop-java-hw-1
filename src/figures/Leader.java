package figures;

import java.awt.*;

public class Leader extends Figure{

    public Leader(Color innerColor, Color outlineColor, int x, int y) {
        super(innerColor, outlineColor, x, y);
    }

    @Override
    public void render(Graphics g) {
        g.setColor(innerColor);
        g.fillRect(x,y,Figure.FIGURE_SIZE,Figure.FIGURE_SIZE);
    }
}
