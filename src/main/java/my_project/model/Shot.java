package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import java.awt.image.BufferedImage;

public class Shot extends Entity {

    private final ViewController viewController;
    private final double speed;
    private final boolean enemyShot;
    private final BufferedImage[] images;
    private final ProgramController programController;

    public Shot(ViewController viewController, ProgramController programController, double x, double y, double speed, boolean enemyShot){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.enemyShot = enemyShot;
        radius = 10;
        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/laser_shot_player.png"),
                createImage("src/main/resources/graphic/laser_shot_enemy.png")
        };
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
    }

    public void draw(DrawTool drawTool){
        if(!enemyShot){
            drawTool.drawTransformedImage(images[0], x, y, 0 ,0.25);
        }else{
            drawTool.drawTransformedImage(images[1], x, y, 0 ,0.25);
        }
    }

    @Override
    public void update(double dt){
        y += (enemyShot ? 1 : -1) * speed*dt;
        if(y < -120 || y > (Config.WINDOW_HEIGHT + height)){
            viewController.removeDrawable(this);
        }
        for(int x = 0; x <= 12; x++){
            for(int y = 0; y <= 8; y++){
                if(programController.getArray().get(x,y) != null && !enemyShot && this.collidesWith(programController.getArray().get(x,y))){
                    viewController.removeDrawable(programController.getArray().get(x,y));
                    programController.getArray().set(null,x,y);
                    viewController.removeDrawable(this);
                    SoundController.playSound("enemyDeath");
                }
                if(enemyShot && this.collidesWith(programController.getPlayer())){
                    viewController.removeDrawable(this);
                    //programController.getPlayer(). Remove Life
                    SoundController.playSound("enemyDeath");
                }
            }
        }
    }
}
