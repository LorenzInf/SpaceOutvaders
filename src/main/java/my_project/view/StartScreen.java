package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.SoundManager;

import java.awt.image.BufferedImage;

public class StartScreen extends GraphicalWindow {

    private BufferedImage[] images;

    public StartScreen(ViewController viewController) {
        super();
        viewController.createScene();
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/start_screen.png"), //0
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[0], 0 ,0);
    }
}
