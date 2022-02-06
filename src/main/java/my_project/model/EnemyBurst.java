package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyBurst extends Enemy{

    private double burstTimer;
    private int shooting;

    public EnemyBurst(ViewController viewController, ProgramController programController){
        super(viewController,programController);
        shootChance = 2;
        shootDelay = 1.5;
        x -= 25;
        y -= 20;
        width = 200 * 0.7;
        height = 170 * 0.7;
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawTransformedImage(images[1], x, y, 0, 0.7);
    }

    @Override
    public void update(double dt){
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
            new Shot(viewController, programController, x + 60, y + 60, 500, true);
            SoundController.playSound("shootPlayer");
            burstTimer = 0.2;
            shooting -= 1;
        }
    }
}

