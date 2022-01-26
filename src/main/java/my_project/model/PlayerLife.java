package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import my_project.view.VisualStack;

import java.awt.image.BufferedImage;

public class PlayerLife extends Entity implements VisualStack.Animated {

    private BufferedImage[] images;
    private VisualStack<PlayerLife> playerLifesStack;
    private boolean hit;

    public PlayerLife(int x, int y, ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        this.x = x;
        this.y = y;
        this.hit = false;

        playerLifesStack = new VisualStack<>(viewController);
        playerLifesStack.pushInVisual(this, 3);

        // ToDo: Mit Stack muss noch gearbeitet werden

        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/heart_full.png"), // 0
                createImage("src/main/resources/graphic/heart_empty.png"), // 1
        };
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
    }

    @Override
    public void draw(DrawTool drawTool){
        if(hit){
            drawTool.drawTransformedImage(images[1], x, y, 0 , 0.85);
        }else{
            drawTool.drawTransformedImage(images[0], x, y,0,0.85);
        }
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    @Override
    public void comeIn() {

    }

    @Override
    public void goOut() {

    }
}
