import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jerzy Kisielewski
 * @version 1.0
 */
public class Player {
    private String name = "";
    private Integer bornYear = 0;
    private Boolean agree;


    /**
     * creates player
     * @param name nickname of the player
     * @param bornYear born year of the player
     * @param agree agree on the
     */
    public Player(String name, Integer bornYear, Boolean agree) {
        if(createPlayer(agree, name, bornYear)){
            this.name = name;
            this.bornYear = bornYear;
            this.agree = agree;
        }
        else {
            System.out.println("creating player denied");
        }
    }

    /**
     * checks if you can create a player
     * @param agree same as in Player method
     * @param name same as in Player method
     * @param bornYear same as in Player method
     */
    public Boolean createPlayer(Boolean agree, String name, Integer bornYear){
        if(hasNotForbiddenSign(name) && isOfAge(bornYear) && agree){
            return true;
        }
        return false;
    }

    public void setName(String name){
        if(hasNotForbiddenSign(name)){
            this.name = name;
        }
        else {
            System.out.println("setting name denied");
        }
    }

    public void setBornYear(Integer bornYear){
        if(isOfAge(bornYear)){
            this.bornYear = bornYear;
        }
        else {
            System.out.println("setting born year denied");
        }
    }

    public Boolean getAgree(){
        return this.agree;
    }

    public String getName(){
        return this.name;
    }

    public Integer getBornYear(){
        return this.bornYear;
    }

    /**
     * checks if player is at least 18 years old
     * @param bornYear born year of the player
     * @return
     */
    private boolean isOfAge(Integer bornYear){
        Integer minAge = 18;
        String currentData = String.valueOf(java.time.LocalDate.now()).substring(0, 4);
        if((bornYear + minAge) <= Integer.parseInt(currentData)){
            return true;
        }
        return false;
    }

    /**
     * checks if nickname does not contain a forbidden character
     * @param name nickname of the player
     * @return
     */
    private boolean hasNotForbiddenSign(String name){
        Pattern pattern = Pattern.compile("[^A-Za-z0-9_]");
        Matcher matcher = pattern.matcher(name);
        boolean hasSpecialSign = matcher.find();
        if(!hasSpecialSign){
            return true;
        }
        return false;
    }
}
