package game.frontend;

import game.backend.CandyGame;
import game.backend.level.Level2;
import game.backend.level.Level3;
import game.backend.level.Levels;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
    private Stage window;
    private Scene rootScene;

    public Controller setPrimaryStage(Stage stage) {
        this.window = stage;
        return this;
    }

    public void setRootScene(Scene rootScene) {
        this.rootScene = rootScene;
    }

    public void Level1(ActionEvent actionEvent) {
        selectLevel(Level2.class);
        //Stage.getWindows().get(0).hide();
    }

    public void Level2(ActionEvent actionEvent){
        selectLevel(Level2.class);
        //Stage.getWindows().get(0).hide();
    }

    public void Level3(ActionEvent actionEvent) {
        selectLevel(Level3.class);
    }

    public void selectLevel(Class<?> level) {
        CandyGame game = new CandyGame((Class<? extends Levels>) level);
        CandyFrame frame = new CandyFrame(game, window, rootScene);
        Scene scene = new Scene(frame);
        window.setScene(scene);
    }
}
