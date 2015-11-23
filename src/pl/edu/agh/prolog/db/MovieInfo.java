package pl.edu.agh.prolog.db;

/**
 *
 * @author ps_krzysztof
 */
public enum MovieInfo {

    ABOUT_TIME("Czas na miłość", 2013, "Richard Curtis", "AboutTime.jpg"),
    ALIEN("Obcy - 8. pasażer \"Nostromo\"", 1979, "Ridley Scott", "Alien.jpg"),
    ARMAGEDDON("Armageddon", 1998, "Michael Bay", "Armageddon.jpg"),
    BEAUTIFUL_MIND("Piękny umysł", 2001, "Ron Howard", "BeautifulMind.jpg"),
    BIG_HERO_SIX("Wielka Szóstka", 2014, "Don Hall, Chris Williams", "BigHeroSix.jpg"),
    DAYLIGHT("Tunel", 1996, "Rob Cohen", "Daylight.jpg"),
    FORREST_GUMP("Forrest Gump", 1994, "Robert Zemeckis", "ForrestGump.jpg"),
    INTOUCHABLES("Intouchables", 2011, "Olivier Nakache, Eric Toledano", "Intouchables.jpg"),
    LOVE_ACTUALLY("To właśnie miłość", 2003, "Richard Curtis", "LoveActually.jpg"),
    ROMAN_HOLIDAY("Rzymskie wakacje", 1953, "William Wyler", "RomanHoliday.jpg"),
    THE_GODFATHER("Ojciec chrzestny", 1972, "Francis Ford Coppola", "TheGodfather.jpg"),
    THE_MATRIX("Matrix", 1999, "Andy Wachowski, Lana Wachowski", "TheMatrix.jpg"),
    THE_SHAWSHANK_REDEMPTION("Skazani na Shawshank", 1994, "Frank Darabont", "TheShawshankRedemption.jpg"),
    THE_SHINING("Lśnienie", 1980, "Stanley Kubrick", "TheShining.jpg"),
    THE_TOURIST("The Tourist", 2010, "Florian Henckel von Donnersmarck", "TheTourist.jpg"),
    TITANIC("Titanic", 1997, "James Cameron", "Titanic.jpg"),
    TWILIGHT("Zmierzch", 2008, "Catherine Hardwicke", "Twilight.jpg"),
    WAR_PHOTOGRAPHER("Fotograf wojenny", 2001, "Christian Frei", "WarPhotographer.jpg");
    
    private final String title;
    private final int year;
    private final String directors;
    private final String picture;

    private MovieInfo(String title, int year, String directors, String picture) {
        this.title = title;
        this.year = year;
        this.directors = directors;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getDirectors() {
        return directors;
    }

    public String getPicture() {
        return picture;
    }
    

    
    
    
}
