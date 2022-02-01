package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shot extends Entity {

    private final ViewController viewController;
    private final double speed;
    private final boolean enemyShot;
    private BufferedImage[] images;
    private ProgramController programController;
    private EnemyWave enemyWave;

    public Shot(ViewController viewController, ProgramController programController, EnemyWave enemyWave, double x, double y, double speed, boolean enemyShot){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
        this.enemyWave = enemyWave;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.enemyShot = enemyShot;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/laser_shot_2.png"),
        };
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
    }

    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[0], x, y, 0 ,0.25);
    }

    @Override
    public void update(double dt){
        y -= speed*dt;
        if(y < -120 || y > (Config.WINDOW_HEIGHT + height)){
            viewController.removeDrawable(this);
        }
    }

    @Override
    public void setX(double x){}

    @Override
    public void setY(double y){}

}
