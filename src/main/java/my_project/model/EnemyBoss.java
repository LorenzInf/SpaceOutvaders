package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.Config;
import my_project.control.ProgramController;

import java.util.Random;

public class EnemyBoss extends Enemy {

    private double shootCooldown;
    private boolean attack0, attack1, attack2;
    private double timer;
    private int counter;
    double direction;

    public EnemyBoss(ViewController viewController, ProgramController programController, int posX, int posY) {
        super(viewController, programController, posX, posY);
        x = posX;
        y = posY - 120;
        width = Config.WINDOW_WIDTH;
        height = 300;
        shootCooldown = 5.0;
        counter = -2;
        timer = 0.0;
        hp = 35;
        movingRight = true;
        programController.getWaveController().setShootLock(false);
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(images[0], x, y);
    }

    @Override
    public boolean tryToShoot(double chance) {
        int help = new Random().nextInt(4);
        switch (help) {
            case 0 -> attack0 = true;
            case 1 -> attack1 = true;
            case 2 -> attack2 = true;
        }
        return true;
    }

    @Override
    public void update(double dt) {
        timer = Math.max(timer - dt, 0);
        shootCooldown -= dt;
        if (shootCooldown <= 0 && !attack2) {
            attack0 = attack1 = false;
            tryToShoot(100);
            shootCooldown = new Random().nextInt(7) + 4;
        }

        Player player = programController.getPlayer();
        double playerX = player.getX() + width/2;

        //Attack 0 (Homing single shots)
        if (attack0 && timer == 0) {
            new Shot(viewController, programController, playerX, y + height, 500, true);
            timer = 0.5;
        }

        //Attack 1 (Homing instant shots)
        if (attack1 && timer == 0) {
            new InstantShot(viewController, programController, playerX, y + height, this, 0, 0);
            timer = 0.5;
        }

        //Attack 2 (Single shots from left/right to right/left)
        if (attack2 && timer == 0) {
            if(counter == -2) {
                direction = new Random().nextDouble();
                if (direction < 0.5) counter = 11;
                else counter = 0;
            }

            new Shot(viewController, programController, getPosMiddle(counter, 18), y + height, 500, true);

            if (direction < 0.5) counter--;
            else counter++;

            if (counter == 12 || counter == -1) {
                attack2 = false;
                counter = -2;
            }
            timer = 0.5;
        }
    }
}
