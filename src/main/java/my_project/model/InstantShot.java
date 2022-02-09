package my_project.model;

import KAGO_framework.control.SoundController;
import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.*;

public class InstantShot extends Shot {

    private double chargeTimer;
    private double shootTimer;
    private double alpha;
    private Enemy enemy;
    private boolean shot;
    private double offsetX, offsetY;
    private boolean hasHit;

    public InstantShot(ViewController viewController, ProgramController programController, double x, double y, Enemy enemy, double offsetX, double offsetY) {
        super(viewController, programController, x, y, 0, true);
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.x = x + 15;
        this.y = y;
        width = 15;
        height = 1000;
        this.enemy = enemy;
        SoundController.playSound("shotCharge");
        chargeTimer = 2.349;
        shootTimer = -1.0;
        alpha = 0;
        hasHit = false;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(chargeTimer > 0) {
            drawTool.setCurrentColor(255,0,0,(int) alpha);
            drawTool.drawFilledRectangle(x - 15, y, width + 15, height);
        } else if (shootTimer > 0) {
            drawTool.setCurrentColor(Color.WHITE);
            drawTool.drawFilledRectangle(x, y, width, height);
        }
    }

    @Override
    public void update(double dt) {
        if(shot && !hasHit) {
            checkPlayerCollision();
            hasHit = true;
        }
        x = enemy.getX() + offsetX + 15;
        y = enemy.getY() + offsetY;
        chargeTimer = Math.max(chargeTimer - dt, 0);
        if( shootTimer != -1.0 ) {
            shootTimer = Math.max(shootTimer - dt, 0);
        }
        if(chargeTimer == 0) {
            if(!shot) {
                shootTimer = 0.1;
                SoundController.stopSound("shotCharge");
                SoundController.playSound("instantShot");
            }
            shot = true;
        }
        alpha += dt/(2.349 * 2) * 255;
        if(shootTimer == 0) {
            viewController.removeDrawable(this);
        }
    }

    public void setShootTimer(double amount) {
        shootTimer = amount;
    }
}
