package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

public class EnemyBurst extends Enemy{
    public EnemyBurst(ViewController viewController, ProgramController programController){
        super(viewController,programController);
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[1],x,y);
    }

    @Override
    public void update(double dt){

        if(tryToShoot()){
            //shoot();
            //wait idk 0.5 second or so
            //shoot();
            //wait idk 0.5 second or so
            //shoot();
        }
    }
}
