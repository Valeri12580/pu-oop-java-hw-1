import figures.Figure;
import figures.Guard;
import figures.Leader;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GameBoard extends JFrame {

    private final Color[][] fieldColors = {{Color.RED, Color.DARK_GRAY, Color.WHITE, Color.DARK_GRAY, Color.RED},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE, Color.WHITE},
            {Color.GRAY, Color.GRAY, Color.WHITE, Color.GRAY, Color.GRAY},
            {Color.DARK_GRAY, Color.RED, Color.WHITE, Color.RED, Color.DARK_GRAY}};



    public GameBoard() throws HeadlessException {
        super("ГрогНок vs СитенПушан");
        super.setSize(500, 500);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        renderFields(g);
        renderFigures(g);


    }

    private void renderFields(Graphics g) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                GameField gameField = new GameField(x, y, this.fieldColors[y][x]);
                gameField.render(g);
            }
        }

    }

    private void renderFigures(Graphics g) {
        renderSpecificFigures(Color.YELLOW,Color.GREEN,0,40,Arrays.asList("Guard", "Guard", "Guard", "Guard", "Leader"),g);
        renderSpecificFigures(Color.GREEN,Color.YELLOW,0,430,Arrays.asList("Leader","Guard", "Guard", "Guard", "Guard"),g);
        renderSpecificFigures(Color.GRAY,Color.GRAY,2,230, Collections.singletonList("Guard"),g);
    }

    private void renderSpecificFigures(Color innerColor,Color outlineColor,int startPositionX,int startPositionY,
                                       List<String>figures,Graphics g){

        for (String s : figures) {
            Figure figure;
            String type = s;

            if (type.equals("Guard")) {
                figure = new Guard(innerColor, outlineColor, startPositionX * GameField.FIELD_SIZE + 30, startPositionY);

            } else {
                figure = new Leader(innerColor, outlineColor, startPositionX * GameField.FIELD_SIZE + 30, startPositionY);
            }

            figure.render(g);
            startPositionX++;

        }
    }






}
