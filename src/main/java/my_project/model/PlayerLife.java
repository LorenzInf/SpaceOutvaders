package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.view.VisualStack;

import java.awt.image.BufferedImage;

public class PlayerLife extends Entity implements VisualStack.Animated {

    private BufferedImage[] images;

    public PlayerLife(ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/heart_full.png"), // 0
                createImage("src/main/resources/graphic/heart_empty.png"), // 1
        };
        viewController.draw(this, 3);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[0], 30,30,0,1);
    }

    @Override
    public void comeIn() {

    }

    @Override
    public void goOut() {

    }
}
