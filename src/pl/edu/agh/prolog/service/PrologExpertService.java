package pl.edu.agh.prolog.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jpl7.Atom;
import org.jpl7.Query;
import org.jpl7.Term;
import org.jpl7.Variable;
import pl.edu.agh.prolog.db.INameable;

/**
 *
 * @author ps_krzysztof
 */
public class PrologExpertService {

    public static void init(String expertFilePath) {
        Query consultQuery = createQuery(PrologExpertConfiguration.Facts.CONSULT.getFactName(), new Term[]{new Atom(expertFilePath)});
        System.out.println("INFO: Expert initialization: " + consultQuery.hasSolution());
    }

    public static List<PrologExpertConfiguration.PersonalityTypes> getPersonalityTypes() {
        try {
            Variable X = new Variable("X");
            Query query = createQuery(PrologExpertConfiguration.Facts.PERSONALITY_TYPE.getFactName(), new Term[]{X});
            Set<String> results = getUniqueResults(query, X);
            printMessage("Number of personality type", results);
            return mapToResultList(results, PrologExpertConfiguration.PersonalityTypes::getPersonalityTypeByVariableName);
        } catch (Exception ex) {
            return Collections.emptyList();
        }

    }

    public static List<PrologExpertConfiguration.PersonalityTypes> getHelpPersonalityTypeFound() {
        try {
            Variable X = new Variable("X");
            Query query = createQuery(PrologExpertConfiguration.Facts.HELP_PERSONALITY_TYPE.getFactName(), new Term[]{X});
            Set<String> results = getUniqueResults(query, X);
            printMessage("Number of help personality types", results);
            return mapToResultList(results, PrologExpertConfiguration.PersonalityTypes::getPersonalityTypeByVariableName);
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }
    
    public static void addPositive(INameable positiveFeature) {
        if(positiveFeature instanceof PrologExpertConfiguration.Features) {
            addPositiveFeature((PrologExpertConfiguration.Features) positiveFeature);
        } else if(positiveFeature instanceof PrologExpertConfiguration.Fealings) {
            addPositiveFealing((PrologExpertConfiguration.Fealings) positiveFeature);
        }
    }
    
    public static void addNegative(INameable negativeFeature) {
        if(negativeFeature instanceof PrologExpertConfiguration.Features) {
            addNegativeFeature((PrologExpertConfiguration.Features) negativeFeature);
        } else if(negativeFeature instanceof PrologExpertConfiguration.Fealings) {
            addNegativeFealing((PrologExpertConfiguration.Fealings) negativeFeature);
        }
    }

    private static void addPositiveFeature(PrologExpertConfiguration.Features feature) {
        Query query = createQuery(PrologExpertConfiguration.Facts.REMEMBER_POSITIVE_FEATURE.getFactName(), new Term[]{new Atom(PrologExpertConfiguration.FEATURES_PREFIX), new Atom(feature.getName())});
        printMessage("Add positive feature", query);
    }

    private static void addNegativeFeature(PrologExpertConfiguration.Features feature) {
        Query query = createQuery(PrologExpertConfiguration.Facts.REMEMBER_NEGATIVE_FEATURE.getFactName(), new Term[]{new Atom(PrologExpertConfiguration.FEATURES_PREFIX), new Atom(feature.getName())});
        printMessage("Add negative feature", query);
    }
    
    private static void addPositiveFealing(PrologExpertConfiguration.Fealings fealing) {
        Query query = createQuery(PrologExpertConfiguration.Facts.REMEMBER_POSITIVE_FEATURE.getFactName(), new Term[]{new Atom(PrologExpertConfiguration.FEELINGS_PREFIX), new Atom(fealing.getName())});
        printMessage("Add positive fealing", query);
    }

    private static void addNegativeFealing(PrologExpertConfiguration.Fealings fealing) {
        Query query = createQuery(PrologExpertConfiguration.Facts.REMEMBER_NEGATIVE_FEATURE.getFactName(), new Term[]{new Atom(PrologExpertConfiguration.FEELINGS_PREFIX), new Atom(fealing.getName())});
        printMessage("Add negative fealing", query);
    }

    public static List<PrologExpertConfiguration.Movie> getMovies() {
        try {
            Variable X = new Variable("X");
            Query query = createQuery(PrologExpertConfiguration.Facts.MOVIE_IS.getFactName(), new Term[]{X});
            Set<String> results = getUniqueResults(query, X);
            printMessage("All possible movies", results);
            return mapToResultList(results, PrologExpertConfiguration.Movie::getMovieByVariableName);
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }

    private static Query createQuery(String name, Term[] term) {
        return new Query(name, term);
    }

    private static Set<String> getUniqueResults(Query query, Variable var) {
        Set<String> uniqueResults = new HashSet<>();
        while (query.hasMoreElements()) {
            String resultValue = ((Term) ((HashMap) query.nextElement()).get(var.name())).toString();
            if (resultValue != null && !resultValue.isEmpty()) {
                uniqueResults.add(resultValue);
            }
        }
        return uniqueResults;
    }

    private static void printMessage(String message, Query query) {
        System.out.println("INFO: " + message + " - " + query.hasSolution());
    }

    private static void printMessage(String message, Set<String> results) {
        System.out.println("INFO: " + message + " - " + results + " (number of solutions: " + results.size() + ")");
    }

    private static <T> List<T> mapToResultList(Set<String> results, Function<String, T> mapperFunction) {
        return results.stream().map(mapperFunction).collect(Collectors.toList());
    }

}
