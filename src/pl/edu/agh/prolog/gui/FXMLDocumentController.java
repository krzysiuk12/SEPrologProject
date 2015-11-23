package pl.edu.agh.prolog.gui;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Pagination;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import pl.edu.agh.prolog.db.MovieInfo;
import pl.edu.agh.prolog.gui.images.ImageSourcePath;
import pl.edu.agh.prolog.service.PrologExpertConfiguration;
import pl.edu.agh.prolog.service.PrologExpertService;
import pl.edu.agh.prolog.service.QuestionsService;

/**
 *
 * @author ps_krzysztof
 */
public class FXMLDocumentController implements Initializable {

    private static final String MOVIE_TITLE_LABEL = "Tytuł: ";
    private static final String MOVIE_YEAR_LABEL = "Rok: ";
    private static final String MOVIE_DIRECTORS_LABEL = "Reżyseria: ";

    private final FileChooser fileChooser = new FileChooser();
    private List<PrologExpertConfiguration.Movie> movies;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private Label questionLabel;

    @FXML
    private Label questionNumberLabel;

    @FXML
    private Label questionTypeLabel;

    @FXML
    private Label helpPersonalityTypeNumberLabel;

    @FXML
    private Label personalityTypeNumberLabel;

    @FXML
    private Label moviesNumberLabel;

    @FXML
    private Button yesButton;

    @FXML
    private Button noButton;

    @FXML
    private Button loadExpertButton;
    
    @FXML
    private VBox resultMoviesVBox;

    @FXML
    private void addPositiveFeatureAction(ActionEvent event) {
        PrologExpertService.addPositive(QuestionsService.getCurrentQuestion().getExpertVariable());
        setValues();
    }

    @FXML
    private void addNegativeFeatureAction(ActionEvent event) {
        PrologExpertService.addNegative(QuestionsService.getCurrentQuestion().getExpertVariable());
        setValues();
    }
    
    @FXML
    private void loadExpertAction(ActionEvent event) {
        configureFileChooser(fileChooser);
        File file = fileChooser.showOpenDialog(JavaFXPrologApplication.getStage());
        if (file != null) {
            PrologExpertConfiguration.setExpertFilePath(file.getAbsolutePath());
            JavaFXPrologApplication.initializeQuestionStage();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    private static void configureFileChooser(final FileChooser fileChooser) {      
        fileChooser.setTitle("Otwórz eksperta...");
    }
 
    
    private VBox createPage(int pageNumber) {
        MovieInfo movieInfo = movies.get(pageNumber).getMovie();
        VBox vBox = new VBox();
        vBox.getChildren().add(createCenteredHBox(createImageView(vBox, movieInfo)));
        vBox.getChildren().add(createHBox(new Label(MOVIE_TITLE_LABEL + movieInfo.getTitle())));
        vBox.getChildren().add(createHBox(new Label(MOVIE_YEAR_LABEL + movieInfo.getYear())));
        vBox.getChildren().add(createHBox(new Label(MOVIE_DIRECTORS_LABEL + movieInfo.getDirectors())));
        return vBox;
    }

    private HBox createCenteredHBox(Node node) {
        HBox hbox = createHBox(node);
        hbox.setAlignment(Pos.CENTER);
        return hbox;
    }

    private HBox createHBox(Node node) {
        return new HBox(node);
    }

    private ImageView createImageView(VBox parent, MovieInfo movieInfo) {
        Image image = new Image(ImageSourcePath.class.getResourceAsStream(movieInfo.getPicture()));
        ImageView imageView = new ImageView(image);
        imageView.fitWidthProperty().set(200.0 / image.getHeight() * image.getWidth());
        imageView.fitHeightProperty().set(200.0);
        return imageView;
    }

    private void setValues() {
        QuestionsService.nextFeatureQuestion();
        if (QuestionsService.isNextFeatureQuestionAvailable()) {
            questionNumberLabel.setText("Pytanie " + QuestionsService.getCurrentQuestionNumber());
            questionTypeLabel.setText(QuestionsService.getCurrentQuestion().getType());
            questionLabel.setText(QuestionsService.getCurrentQuestion().getQuestion());
        } else {
            questionNumberLabel.setText("-");
            questionTypeLabel.setText("-");
            questionLabel.setText("Odpowiedziałeś na wszystkie pytania.");
            yesButton.setDisable(true);
            noButton.setDisable(true);
        }
        helpPersonalityTypeNumberLabel.setText(Integer.toString(PrologExpertService.getHelpPersonalityTypeFound().size()));
        personalityTypeNumberLabel.setText(Integer.toString(PrologExpertService.getPersonalityTypes().size()));
        movies = PrologExpertService.getMovies();
        moviesNumberLabel.setText(Integer.toString(PrologExpertService.getMovies().size()));
        initializeResultVBox();
    }

    private void initializeResultVBox() {
        resultMoviesVBox.getChildren().clear();
        resultMoviesVBox.setAlignment(Pos.CENTER);
        if (movies.isEmpty()) {
            Label label = new Label("Nie udało się dopasować filmów - odpowiedz na pytania.");
            label.setWrapText(true);
            label.setAlignment(Pos.CENTER);
            resultMoviesVBox.getChildren().add(label);
        } else {
            Pagination pagination = new Pagination(movies.size(), 0);
            pagination.setPageFactory((pageIndex) -> createPage(pageIndex));
            resultMoviesVBox.getChildren().add(pagination);
        }
    }

}
