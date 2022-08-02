package src.main.models;

import java.util.Arrays;

import javax.xml.catalog.CatalogFeatures.Feature;

public class Team {

    private String house;
    private String keeper;
    private String seeker;
    private String[] chasers;

    private static final String POSITION_CHASER = "chaser";
    private static final String POSITION_SEEKER = "seeker";
    private static final String POSITION_KEEPER = "keeper";

    // defining the constructor
    public Team(String house, String keeper, String seeker, String[] chasers) {

        if (house == null || keeper == null || seeker == null) {
            throw new IllegalArgumentException("Field cannot be null");
        }

        if (house.isBlank() || keeper.isBlank() || seeker.isBlank()) {
            throw new IllegalArgumentException("Field cannot be blank");
        }

        if (chasers.length != 3) {
            throw new IllegalArgumentException("3 chaser required");
        }

        if (hasBlank(chasers) || hasNull(chasers)) {
            throw new IllegalArgumentException("illegal elements");
        }

        this.chasers = Arrays.copyOf(chasers, chasers.length);
        this.house = house;
        this.keeper = keeper;
        this.seeker = seeker;
    }

    // defining the copy contructor
    public Team(Team Source) {
        this.chasers = Arrays.copyOf(Source.chasers, Source.chasers.length);
        this.house = Source.house;
        this.keeper = Source.keeper;
        this.seeker = Source.seeker;
    }

    // defining the getters
    public String[] getChasers() {
        return Arrays.copyOf(chasers, chasers.length);
    }

    public String getHouse() {
        return house;
    }

    public String getKeeper() {
        return keeper;
    }

    public String getSeeker() {
        return seeker;
    }

    public void setChasers(String[] chasers) {

        if (chasers.length != 3 || hasBlank(chasers) || hasNull(chasers)) {
            throw new IllegalArgumentException("invalid chasers content");
        }
        this.chasers = chasers;
    }

    public void setHouse(String house) {

        checkParameter(house);
        this.house = house;
    }

    public void setKeeper(String keeper) {
        checkParameter(keeper);
        this.keeper = keeper;
    }

    public void setSeeker(String seeker) {
        checkParameter(seeker);
        this.seeker = seeker;
    }

    public String toString() {
        return "House: " + this.house + "\n" +
                "Keeper: " + this.keeper + "\n" +
                "Seeker: " + this.seeker + "\n" +
                "Chasers: " + Arrays.toString(this.chasers) + "\n";
    }

    public static boolean hasNull(String[] array) {
        // stream approach
        return Arrays.stream(array).anyMatch((item) -> item == null);
    }

    public static boolean hasBlank(String[] arrays) {
        return Arrays.stream(arrays).anyMatch((items) -> items.isBlank());
    }

    public void checkParameter(String parameter) {
        if (parameter == null || parameter.isBlank()) {
            throw new IllegalArgumentException(parameter + " cannot be null or blank");
        }
    }

    /*
     * FREQUENTLY ASKED QUESTIONS:
     * 
     * Question: the constants are final, so why can't we make them public? It's not
     * possible for the caller to update them.
     * Answer: Even if the constant is final, I prefer to expose a method instead of
     * the variable. But if you want to expose the variable, that's also correct.
     * 
     */

    public static String getPositionChaser() {
        return POSITION_CHASER;
    }

    public static String getPositionSeeker() {
        return POSITION_SEEKER;
    }

    public static String getPositionKeeper() {
        return POSITION_KEEPER;
    }

}
