package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;
import java.awt.image.BufferedImage;

public class Shot extends Entity {

    protected final ViewController viewController;
    private final double speed;
    private final boolean enemyShot;
    protected final BufferedImage[] images;
    protected final ProgramController programController;
    protected Enemy[][] array;

    public Shot(ViewController viewController, ProgramController programController, double x, double y, double speed, boolean enemyShot){
        super(viewController, programController);
        this.viewController = viewController;
        this.programController = programController;
        this.x = x + 78.5;
        this.y = y + 55.5;
        this.speed = speed;
        this.enemyShot = enemyShot;
        width = 18;
        height = 64;
        array = programController.getArray();
        String path = "src/main/resources/graphic/";
        images = new BufferedImage[]{
                createImage(path + "laser_shot_player.png"),
                createImage(path + "laser_shot_enemy.png"),
                createImage(path + "buffs/rapid_shot.png"),
                createImage(path + "buffs/pierce_shot.png")
        };
        viewController.draw(this, GraphicalWindow.GAME_INDEX);
    }

    @Override
    public void draw(DrawTool drawTool){
        if(!enemyShot){
            drawTool.drawImage(images[0], x, y);
        }else{
            drawTool.drawImage(images[1], x, y);
        }
        if(programController.getPlayer().isRapidFire() && !this.enemyShot){
            drawTool.drawImage(images[2], x, y);
        }
        if(programController.getPlayer().isPiercing() && !this.enemyShot){
            drawTool.drawImage(images[3], x, y);
        }
    }

    @Override
    public void update(double dt){
        y += (enemyShot ? 1 : -1) * speed*dt;
        if(y < -120 || y > Config.WINDOW_HEIGHT){
            viewController.removeDrawable(this);
        }
        for(int x = 0; x < 11; x++){
            for(int y = 0; y < 6; y++){
                if(array[x][y] != null && !enemyShot && this.y > 1 && this.collidesWith(array[x][y])) {
                    if(array[x][y].getHp() > 1) {
                        array[x][y].setHp(array[x][y].getHp() - 1);
                        if(array[x][y] instanceof EnemyShield) SoundController.playSound("shieldHit");
                        else SoundController.playSound("enemyDeath");
                        viewController.removeDrawable(this);
                    } else {
                        viewController.removeDrawable(array[x][y]);
                        array[x][y] = null;
                        SoundController.playSound("enemyDeath");
                        if(!programController.getPlayer().isPiercing()) {
                            viewController.removeDrawable(this);
                        }
                    }
                }
            }
        }
        if(enemyShot && this.y < Config.WINDOW_HEIGHT - 120 && this.collidesWith(programController.getPlayer())){
            viewController.removeDrawable(this);
            if(programController.getPlayer().isExtraLife() && !programController.getPlayer().isShield()){
                viewController.removeDrawable(programController.getExtraLife());
                programController.getPlayer().setExtraLife(false);
                programController.getPlayer().setiCooldown(2.0);
                SoundController.playSound("enemyDeath");
            }else if(!programController.getPlayer().isShield()){
                programController.getPlayer().setiCooldown(2.0);
                programController.getStack().popVisual();
                SoundController.playSound("enemyDeath");
                if (programController.getStack().top() == null) {
                    programController.getWindow().switchScene(6);
                }
            }
        }
    }
}
