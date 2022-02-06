package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;
import java.util.Random;

public class Buff extends Entity {

    private final BufferedImage[] images;
    private final int randomNumber;

    public Buff(double x, double y, ViewController viewController, ProgramController programController) {
        super(viewController, programController);
        this.x = x;
        this.y = y;
        randomNumber = 0; // new Random().nextInt(6);

        images = new BufferedImage[]{
                createImage("src/main/resources/graphic/buffs/extralife_buff.png"),
                createImage("src/main/resources/graphic/buffs/fast_shoot_buff.png"), // ToDo: Sprite ändern
                createImage("src/main/resources/graphic/buffs/life_buff.png"),
                createImage("src/main/resources/graphic/buffs/pierce_buff.png"),
                createImage("src/main/resources/graphic/buffs/shield_buff.png"),
                createImage("src/main/resources/graphic/buffs/speed_buff.png")
        };
        viewController.draw(this,3);
    }

    @Override
    public void draw(DrawTool drawTool){
        switch(randomNumber){
            case 0 -> drawTool.drawTransformedImage(images[0], x, y, 0, 0.85);
            case 1 -> drawTool.drawTransformedImage(images[1], x-200, y, 0, 0.2);
            case 2 -> drawTool.drawTransformedImage(images[2], x, y, 0, 1);
            case 3 -> drawTool.drawTransformedImage(images[3], x-10, y, 0, 0.8);
            case 4 -> drawTool.drawTransformedImage(images[4], x-65, y, 0, 0.15);
            case 5 -> drawTool.drawTransformedImage(images[5], x-72, y, 0, 0.1);
        }
    }

    @Override
    public void update(double dt){
        y += 250*dt;
        if(this.collidesWith(programController.getPlayer())){
            viewController.removeDrawable(this);
            switch(randomNumber){
                case 0 -> {
                    programController.createExtraLife();
                    programController.getPlayer().setExtraLife(true);
                }
                // ToDo: alle anderen implentieren
            }
        }
    }
}
