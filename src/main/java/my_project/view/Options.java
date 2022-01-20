package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.GraphicalWindow;
import my_project.control.ProgramController;

import java.awt.image.BufferedImage;

public class Options extends GraphicalWindow {

    private final ProgramController programController;
    private final BufferedImage[] images;
    private boolean musicOn;
    private boolean soundOn;

    public Options(ViewController viewController, ProgramController programController) {
        super();
        this.programController = programController;
        images = new BufferedImage[]{ // Alle Bilder pre laden, damit es zu keinen Lags kommt, weil sonst die Images neu geladen werden
                createImage("src/main/resources/graphic/options_blank.png"), // 0
                createImage("src/main/resources/graphic/options_music_on.png"), // 1
                createImage("src/main/resources/graphic/options_music_off.png"), // 2
                createImage("src/main/resources/graphic/options_sound_on.png"), // 3
                createImage("src/main/resources/graphic/options_sound_off.png"), // 4
                createImage("src/main/resources/graphic/options_music_on_selected.png"), // 5
                createImage("src/main/resources/graphic/options_music_off_selected.png"), // 6
                createImage("src/main/resources/graphic/options_sound_on_selected.png"), // 7
                createImage("src/main/resources/graphic/options_sound_off_selected.png"), // 8
                createImage("src/main/resources/graphic/x_selected.png"), // 9
        };
        musicOn = true;
        soundOn = true;
        viewController.createScene();
    }

    @Override
    public void draw(DrawTool drawTool){
        drawTool.drawImage(images[0], 0 ,0);

        // Wenn es neu gezeichnet wird muss geguckt werden, ob es an oder aus gemacht werden muss
        drawTool.drawImage(images[musicOn ? 1 : 2], 0, 0);

        // Wenn es neu gezeichnet wird muss geguckt werden, ob es an oder aus gemacht werden muss
        drawTool.drawImage(images[soundOn ? 3 : 4], 0, 0);

        switch(programController.getWindow().getOptionsIndex()) { // Symbol markiert oder nicht
            case 1 -> drawTool.drawImage(images[musicOn ? 5 : 6], 0, 0);
            case 2 -> drawTool.drawImage(images[soundOn ? 7 : 8], 0, 0);
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