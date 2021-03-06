package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyBurst extends Enemy{

    private double burstTimer;
    private int shooting;

    public EnemyBurst(ViewController viewController, ProgramController programController, int posX, int posY){
        super(viewController,programController,posX,posY);
        shootChance = 1;
        shootDelay = 0.25;
        x += 17.5;
        y += 28;
        width = 140;
        height = 119;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[1], x, y);
    }

    /** TryToShoot but gets called three Times instead of once
     * @param dt dt
     */
    @Override
    public void update(double dt){
        doMovement(dt);
        if(moving) timer -= dt;
        shootTimer += dt;
        burstTimer = Math.max(burstTimer - dt, 0);
        if(shooting == 0 && shootTimer >= shootDelay) {
            shootTimer = 0;
            if(tryToShoot(shootChance)){
                burstTimer = 0.2;
                shooting = 2;
            }
        }
        if(burstTimer == 0 && shooting > 0) {
            new Shot(viewController, programController, enemyX , enemyY + 60, 500, true);
            SoundController.playSound("shootPlayer");
            burstTimer = 0.2;
            shooting -= 1;
        }
    }
}

