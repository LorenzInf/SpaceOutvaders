package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.view.VisualStack;

import java.awt.image.BufferedImage;

public class PlayerLife extends Entity implements VisualStack.Animated {

    private BufferedImage[] images;
    private boolean empty;
    private int x;
    private int y;

    public PlayerLife(int x, int y,  ViewController viewController, ProgramController programController, boolean empty) {
        super(viewController, programController);
        this.x = x;
        this.y = y;
        this.empty = empty;

        if(!empty){
            programController.getStack().pushInVisual(this, x, y, 3);
        }else{
            viewController.draw(this, 3);
        }

        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/heart_full.png"), // 0
                createImage("src/main/resources/graphic/heart_empty.png"), // 1
        };
    }

    @Override
    public void draw(DrawTool drawTool){
        if(empty){
            drawTool.drawTransformedImage(images[1], x, y, 0 , 0.85);
        }else{
            drawTool.drawTransformedImage(images[0], x, y,0,0.85);
        }
    }

    @Override
    public void comeIn() {

    }

    @Override
    public void goOut() {

    }
}
