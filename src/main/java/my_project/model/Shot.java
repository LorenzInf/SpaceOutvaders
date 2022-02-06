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
    private boolean hasHit;
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
        hasHit = false;
        width = 10;
        height = 100;
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
        if(y < -120 || y > Config.WINDOW_HEIGHT){
            viewController.removeDrawable(this);
        }
        for(int x = 0; x <= 12; x++){
            for(int y = 0; y <= 8; y++){
                if(programController.getArray().get(x,y) != null && !enemyShot && y > 1 && this.collidesWith(programController.getArray().get(x,y))){
                    if(programController.getArray().get(x,y) instanceof EnemyShield){
                        ((EnemyShield) programController.getArray().get(x,y)).setHp(((EnemyShield) programController.getArray().get(x,y)).getHp() - 1);
                        SoundController.playSound("enemyDeath");
                        if(((EnemyShield) programController.getArray().get(x,y)).getHp() == 0) {
                            viewController.removeDrawable(programController.getArray().get(x, y));
                            programController.getArray().set(null, x, y);
                        }
                        viewController.removeDrawable(this);
                    } else {
                        viewController.removeDrawable(programController.getArray().get(x, y));
                        programController.getArray().set(null, x, y);
                        viewController.removeDrawable(this);
                        SoundController.playSound("enemyDeath");
                    }
                }
                if(enemyShot && this.y < Config.WINDOW_HEIGHT - 120 && this.collidesWith(programController.getPlayer())){
                    viewController.removeDrawable(this);
                    if(programController.getPlayer().isExtraLife()){
                        viewController.removeDrawable(programController.getExtraLife());
                        programController.getPlayer().setExtraLife(false);
                        setHasHit(true);
                        SoundController.playSound("enemyDeath");
                    }else if(!hasHit){
                        programController.getStack().popVisual();
                        setHasHit(true);
                        SoundController.playSound("enemyDeath");
                        if(programController.getStack().top() == null){
                            programController.getWindow().switchScene(6);
                        }
                    }
                }
            }
        }
    }

    public void setHasHit(boolean hasHit) {
        this.hasHit = hasHit;
    }
}
