package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.util.Random;

public class EnemyInstant extends Enemy {

    private double shotCooldown;
    private InstantShot shot;

    public EnemyInstant(ViewController viewController, ProgramController programController, int posX, int posY){
        super(viewController,programController,posX,posY);
        x += 28;
        y += 28;
        width = height = 119;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[4],x,y);
    }

    @Override
    public boolean tryToShoot(double chance){
        if(timer <= 0 && shotCooldown == 0) {
            int help = new Random().nextInt(100 + 1);
            if (chance >= help && y > 0) {
                shot = new InstantShot(viewController, programController, enemyX, y, this,44,103);
                shotCooldown = 3.0;
                return true;
            }
        }
        return false;
    }

    @Override
    public void update(double dt) {
        super.update(dt);
        shotCooldown = Math.max(shotCooldown - dt, 0);
    }

    public void die() {
        if(shot != null) shot.setShootTimer(0.0);
    }
}
