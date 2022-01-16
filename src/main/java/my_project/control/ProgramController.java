package my_project.control;

import KAGO_framework.control.SoundController;
import my_project.Config;
import my_project.model.Player;
import KAGO_framework.control.ViewController;
import my_project.view.Game;
import my_project.view.Visual2DArray;

import java.awt.*;
import java.lang.reflect.Array;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private final ViewController viewController;
    private final SoundController soundController;
    private GraphicalWindow window;
    private Visual2DArray array;


    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        soundController = new SoundController();
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        array = new Visual2DArray<Game>(11, Config.WINDOW_HEIGHT / 175, 0 , 0, new Visual2DArray.VisualizationConfig(0,0, 175, 175, 0, true, false, false, null, Color.WHITE, new Color(0,0,0,0)));
        window = new GraphicalWindow(viewController, this);
        new InputManagerMainMenu(this, viewController, soundController);
        new InputManagerOptions(this, viewController, window.getOptions(), soundController);
        new InputManagerGame(this, viewController);
        new Player(0,0,false, 0, viewController, getWindow().programController);
        viewController.draw(array, 2);
        viewController.register(array);
    }

    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }

    public GraphicalWindow getWindow(){
        return window;
    }

}
