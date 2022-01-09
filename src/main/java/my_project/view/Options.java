package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class Options extends GraphicalWindow {

    private ProgramController programController;
    private boolean musicOn;
    private boolean soundOn;
    private BufferedImage[] images;

    public Options(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt weil sonst die Images neu geladen werden
                load("options_blank.png"), // 0
                load("options_music_on.png"), // 1
                load("options_music_off.png"), // 2
                load("options_sound_on.png"), // 3
                load("options_sound_off.png"), // 4
                load("options_music_on_selected.png"), // 5
                load("options_music_off_selected.png"), // 6
                load("options_sound_on_selected.png"), // 7
                load("options_sound_off_selected.png"), // 8
                load("x_selected.png"), // 9
        };
        musicOn = true;
        soundOn = true;
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[0], 0 ,0);

        if(musicOn){ // Wenn es neu gezeichnet wird muss geguckt werden ob es an oder aus gemacht werden muss
            drawTool.drawImage(images[1], 0, 0);
        }else{
            drawTool.drawImage(images[2], 0, 0);
        }

        if(soundOn){ // Wenn es neu gezeichnet wird muss geguckt werden ob es an oder aus gemacht werden muss
            drawTool.drawImage(images[3], 0, 0);
        }else{
            drawTool.drawImage(images[4], 0, 0);
        }

        switch(programController.getWindow().getOptionsIndex()) { // Symbol markiert oder nicht
            case 1 -> {
                if(musicOn){
                    drawTool.drawImage(images[5], 0, 0);
                }else{
                    drawTool.drawImage(images[6], 0, 0);
                }
            }
            case 2 -> {
                if(soundOn){
                    drawTool.drawImage(images[7], 0, 0);
                }else{
                    drawTool.drawImage(images[8], 0, 0);
                }
            }
            case 3 -> drawTool.drawImage(images[9], 0, 0);
        }
    }

    public boolean isMusicOn() {
        return musicOn;
    }

    public void setMusicOn(boolean musicOn) {
        this.musicOn = musicOn;
    }

    public boolean isSoundOn() {
        return soundOn;
    }

    public void setSoundOn(boolean soundOn) {
        this.soundOn = soundOn;
    }
}