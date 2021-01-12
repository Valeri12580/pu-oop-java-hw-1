import java.awt.*;

public class GameField {
    private int x;
    private int y;
    public static int FIELD_SIZE = 100;
    private Color color;

    public GameField(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }


    void render(Graphics g) {
        int fieldX = x * GameField.FIELD_SIZE;
        int fieldY = y * GameField.FIELD_SIZE;

        g.setColor(color);
        g.fillRect(fieldX, fieldY, GameField.FIELD_SIZE, GameField.FIELD_SIZE);
        g.setColor(Color.BLACK);
        g.drawRect(fieldX, fieldY, GameField.FIELD_SIZE, GameField.FIELD_SIZE);

    }
}
