package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;
import my_project.view.VisualQueue;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Buff extends Entity implements VisualQueue.Animatible {

    private final BufferedImage[] images;
    private final int randomNumber;
    private boolean isInQueue;


    public Buff(double x, double y, ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        this.x = x;
        this.y = y;
        width = 50;
        height = 85;
        isInQueue = false;
        if(programController.getStack().getCounter() == 3){
            randomNumber = new Random().nextInt(5);
        }else{
            randomNumber = new Random().nextInt(6);
        }

        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/buffs/extralife_buff.png"),
                createImage("src/main/resources/graphic/buffs/fast_shoot_buff.png"),
                createImage("src/main/resources/graphic/buffs/speed_buff.png"),
                createImage("src/main/resources/graphic/buffs/pierce_buff.png"),
                createImage("src/main/resources/graphic/buffs/shield_buff.png"),
                createImage("src/main/resources/graphic/buffs/life_buff.png"),

        };
        viewController.draw(this, 3);
    }

    @Override
    public void draw(DrawTool drawTool){
        switch(randomNumber){
            case 0 -> drawTool.drawImage(images[0], x, y); // Extra life
            case 1 -> drawTool.drawImage(images[1], x, y); // Fast Shoot
            case 2 -> drawTool.drawImage(images[2], x, y); // Speed - Buff
            case 3 -> drawTool.drawImage(images[3], x, y); // Pierce
            case 4 -> drawTool.drawImage(images[4], x, y); // Shield
            case 5 -> drawTool.drawImage(images[5], x, y); // Life Buff
        }

    }

    @Override
    public void update(double dt){
        if(!isInQueue){
            y += 250*dt;
        }
        if(this.collidesWith(programController.getPlayer())){
            if(randomNumber == 5 && programController.getStack().getCounter() != 3){
                viewController.removeDrawable(this);
                programController.getPlayer().setHealBoost(true);
                switch (programController.getStack().getCounter()) {
                    case 1 -> new PlayerLife(1810, 880, viewController, programController, 0);
                    case 2 -> new PlayerLife(1810, 950, viewController, programController, 0);
                }
            }
            if(programController.getBuffVisualQueue().getCounter() != 3 && randomNumber != 5){
                programController.getBuffVisualQueue().enqueue(this);
                isInQueue = true;
            }
        }
    }

    @Override
    public void fadeOut(boolean fadeOut) {

    }

    @Override
    public void setTx(double tx) {

    }

    @Override
    public void setTy(double ty) {

    }

    @Override
    public double getTx() {
        return 0;
    }

    @Override
    public double getTy() {
        return 0;
    }

    @Override
    public boolean isArrived() {
        return false;
    }

    public int getRandomNumber() {
        return randomNumber;
    }


}
