package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Game extends GraphicalWindow {

    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.viewController = viewController;
        this.programController = programController;
        viewController.createScene();
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt
                createImage("src/main/resources/graphic/maingame_blank.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
        drawTool.setCurrentColor(Color.WHITE);
        drawTool.formatText("Minecraft",0,30);
        drawTool.drawText(150,1040,"Score: " + programController.getScore());
    }
}
