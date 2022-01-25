package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.model.PlayerLife;

import java.awt.image.BufferedImage;

public class Game extends GraphicalWindow {

    private BufferedImage[] images;

    public Game(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        viewController.createScene();
        programController.getStack().pushInVisual(new PlayerLife(viewController, programController)); // ToDo: Player Life kaputt, er zeichnet es noch nicht
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                createImage("src/main/resources/graphic/maingame_blank.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
}
