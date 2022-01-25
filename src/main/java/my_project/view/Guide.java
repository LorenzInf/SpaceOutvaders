package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import java.awt.image.BufferedImage;

public class Guide extends GraphicalWindow {

    private BufferedImage[] images;

    public Guide(ViewController viewController) {
        super();
        viewController.createScene();
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                createImage("src/main/resources/graphic/maingame_blank.png")
        };
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], 0 ,0);
    }
}
