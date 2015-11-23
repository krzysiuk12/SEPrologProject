package pl.edu.agh.prolog.db;

/**
 *
 * @author ps_krzysztof
 */
public interface IQuestionable<T extends INameable> {

    public String getQuestion();

    public T getExpertVariable();

    public String getType();

}
