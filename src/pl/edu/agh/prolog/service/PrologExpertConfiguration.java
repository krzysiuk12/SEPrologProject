package pl.edu.agh.prolog.service;

import java.util.Arrays;
import pl.edu.agh.prolog.db.INameable;
import pl.edu.agh.prolog.db.MovieInfo;

/**
 *
 * @author ps_krzysztof
 */
public class PrologExpertConfiguration {

    public static final String FEATURES_PREFIX = "jest";
    public static final String FEELINGS_PREFIX = "czuje";
    public static String EXPERT_FILE_PATH;
    
    public static enum Facts {
        
        CONSULT("consult"),
        MOVIE_IS("film_jest"),
        GENRE_IS("gatunek_jest"),
        PERSONALITY_TYPE("typ_osobowosci_jest"),
        HELP_PERSONALITY_TYPE("pomocniczy_typ_osobowosci_jest"),
        POSITIVE_FEATURE("pozytywna_cecha"),
        REMOVE_FACTS("wyczysc_fakty "),
        REMEMBER_POSITIVE_FEATURE("pamietaj_pozytywna_ceche"),
        REMEMBER_NEGATIVE_FEATURE("pamietaj_negatywna_ceche"),
        NEGATIVE_FEATURE("negatywna_cecha"),
        ;

        private final String factName;

        private Facts(String factName) {
            this.factName = factName;
        }

        public String getFactName() {
            return factName;
        }
        
    }
    
    public static enum Features implements INameable {
        
        DIRECT("bezposredni"),
        BRILLIANT("blyskotliwy"),
        PATIENT("cierpliwy"),
        EMPATHIC("empatyczny"),
        ENERGETIC("energiczny"),
        ENIGMATIC("enigmatyczny"),
        ENTHUSIASTIC("entuzjastyczny"),
        INDIVIDUALIST("indywidualista"),
        INSPIRING("inspirujacy"),
        COMPETENT("kompetentny"),
        LOGICAL("logiczny"),
        LOYAL("lojalny"),
        INDEPENDENT("niezalezny"),
        STRESS_RESISTANT("odporny_na_stres"),
        RESPONSIBLE("odpowiedzialny"),
        OPTIMISTIC("optymistyczny"),
        CONFIDENT("pewny_siebie"),
        HARDWORKING("pracowity"),
        PRACTICAL("praktyczny"),
        ENTERPRISING("przedsiebiorczy"),
        RATIONAL("racjonalny"),
        MATTER_OF_FACT("rzeczowy"),
        CORDIAL("serdeczny"),
        SPONTANEOUS("spontaniczny"),
        CONSCIENTIOUS("sumienny"),
        SOCIAL("towarzyski"),
        CREATIVE("tworczy"),
        TRUSTING("ufny"),
        SENSITIVE("wrazliwy"),
        PERSISTENT("wytrwaly"),
        DETACHED("zdystansowany"),
        ORGANIZED("zorganizowany");

        private final String featureName;

        private Features(String featureName) {
            this.featureName = featureName;
        }

        @Override
        public String getName() {
            return featureName;
        }
        
    }
    
    public static enum Fealings implements INameable {
        
        SADNESS("smutek"),
        BAD_MOOD("zly_nastroj"),
        DISCOURAGEMENT("zniechecenie"),
        LONELINESS("samotnosc"),
        TIREDNESS("zmeczenie"),
        GOOD_DAY("dobry_dzien"),
        CONTENTMENT("zadowolony_z_siebie"),
        MOTIVATION("zmotywowany"),
        JOY("radosc");

        private final String fealingName;

        private Fealings(String fealingName) {
            this.fealingName = fealingName;
        }

        @Override
        public String getName() {
            return fealingName;
        }
        
    }
    
    
    public static enum Movie {
        
        ABOUT_TIME(MovieInfo.ABOUT_TIME, "abouttime"),
        ALIEN(MovieInfo.ALIEN, "alien"),
        ARMAGEDDON(MovieInfo.ARMAGEDDON, "armageddon"),
        BIG_HERO_SIX(MovieInfo.BIG_HERO_SIX, "bigherosix"),
        BEAUTIFUL_MIND(MovieInfo.BEAUTIFUL_MIND, "beautifulmind"),
        DAYLIGHT(MovieInfo.DAYLIGHT, "daylight"),
        FORREST_GUMP(MovieInfo.FORREST_GUMP, "forrestgump"),
        INTOUCHABLES(MovieInfo.INTOUCHABLES, "intouchables"),
        LOVE_ACTUALLY(MovieInfo.LOVE_ACTUALLY, "loveactually"),
        ROMAN_HOLIDAY(MovieInfo.ROMAN_HOLIDAY, "romanholiday"),
        THE_GODFATHER(MovieInfo.THE_GODFATHER, "thegodfather"),
        THE_MATRIX(MovieInfo.THE_MATRIX, "thematrix"),
        THE_SHAWSHANK_REDEMPTION(MovieInfo.THE_SHAWSHANK_REDEMPTION, "theshawshankredemption"),
        THE_SHINING(MovieInfo.THE_SHINING, "theshining"),
        THE_TOURIST(MovieInfo.THE_TOURIST, "thetourist"),
        TITANIC(MovieInfo.TITANIC, "titanic"),
        TWILIGHT(MovieInfo.TWILIGHT, "twilight"),
        WAR_PHOTOGRAPHER(MovieInfo.WAR_PHOTOGRAPHER, "warphotographer");
    
        private final MovieInfo movie;
        private final String variableName;

        private Movie(MovieInfo movie, String variableName) {
            this.movie = movie;
            this.variableName = variableName;
        }

        public MovieInfo getMovie() {
            return movie;
        }

        public String getVariableName() {
            return variableName;
        }
        
        public static Movie getMovieByVariableName(String variableName) {
            return Arrays.asList(values()).stream().filter((movie) -> movie.getVariableName().equals(variableName)).distinct().findFirst().get();
        }
        
    }
    
    public static enum PersonalityTypes {
        
        ADMINISTRATOR("administrator"),
        COUNSELLOR("adwokat"),
        ANIMATOR("animator"),
        ARTIST("artysta"),
        ADVISER("doradca"),
        DIRECTOR("dyrektor"),
        ENTHUSIAST("entuzjasta"),
        IDEALIST("idealista"),
        INNOVATOR("innowator"),
        INSPECTOR("inspektor"),
        LOGICIAN("logik"),
        MENTOR("mentor"),
        ATTENDANT("opiekun"),
        PRACTITIONER("praktyk"),
        ANNOUNCER("prezenter"),
        STRATEGIST("strateg"),

        HOTHEAD("choleryk"),
        SANGUINE("sangwinik"),
        MELANCHOLIC("melancholik"),
        PHLEGMATIC("flegmatyk");

        private final String personalityType;

        private PersonalityTypes(String personalityType) {
            this.personalityType = personalityType;
        }

        public String getPersonalityType() {
            return personalityType;
        }
        
        public static PersonalityTypes getPersonalityTypeByVariableName(String variableName) {
            return Arrays.asList(values()).stream().filter((type) -> type.getPersonalityType().equals(variableName)).distinct().findFirst().get();
        }

    }
    
    public static void setExpertFilePath(String expertFilePath) {
        EXPERT_FILE_PATH = expertFilePath;
    }
    
}
