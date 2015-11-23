package pl.edu.agh.prolog.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.edu.agh.prolog.service.PrologExpertConfiguration;
import pl.edu.agh.prolog.service.PrologExpertService;
import pl.edu.agh.prolog.service.QuestionsService;

/**
 *
 * @author ps_krzysztof
 */
public class JavaFXPrologApplication extends Application {

    private static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        JavaFXPrologApplication.stage = stage;
        initializeStage("StartFXML.fxml");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void initializeQuestionStage() {
        try {
            initializeExpert();
            initializeStage("QuestionsFXML.fxml");
        } catch (IOException ex) {
            Logger.getLogger(JavaFXPrologApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void initializeStage(String fxmlDocumentName) throws IOException {
        Scene scene = new Scene(FXMLLoader.load(JavaFXPrologApplication.class.getResource(fxmlDocumentName)));
        getStage().setScene(scene);
        getStage().setResizable(false);
        getStage().show();
    }

    private static void initializeExpert() {
        PrologExpertService.init(PrologExpertConfiguration.EXPERT_FILE_PATH);
        QuestionsService.init();
    }

}
