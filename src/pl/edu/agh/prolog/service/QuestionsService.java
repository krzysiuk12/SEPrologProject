package pl.edu.agh.prolog.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import pl.edu.agh.prolog.db.INameable;
import pl.edu.agh.prolog.db.IQuestionable;
import pl.edu.agh.prolog.db.Questions;

/**
 *
 * @author ps_krzysztof
 */
public class QuestionsService {

    private static IQuestionable<? extends INameable> currentQuestion;
    private static List<IQuestionable<? extends INameable>> questions;
    
    public static void init() {
        questions = new ArrayList<>(Arrays.asList(Questions.Features.values()));
        Collections.shuffle(questions);
        for(IQuestionable<? extends INameable> question : Questions.Fealings.values()) {
            questions.add(new Random().nextInt(questions.size() - 5) + 5, question);
        }
        nextFeatureQuestion();
    }

    public static void nextFeatureQuestion() {
        if(getQuestions() == null) {
            setCurrentFeatureQuestion(getQuestions().get(0));        
        } else if(isNextFeatureQuestionAvailable()) {
            setCurrentFeatureQuestion(getQuestions().get(getQuestions().indexOf(getCurrentQuestion()) + 1));
        }
    }
    
    public static boolean isNextFeatureQuestionAvailable() {
        return getCurrentQuestionNumber() != getQuestions().size();
    }
    
    public static int getCurrentQuestionNumber() {
        return getQuestions().indexOf(getCurrentQuestion()) + 1;
    }
    
    public static IQuestionable<? extends INameable> getCurrentQuestion() {
        return currentQuestion;
    }

    public static void setCurrentFeatureQuestion(IQuestionable<? extends INameable> currentQuestion) {
        QuestionsService.currentQuestion = currentQuestion;
    }
    
    public static List<IQuestionable<? extends INameable>> getQuestions() {
        return questions;
    }
    
    
    
}
