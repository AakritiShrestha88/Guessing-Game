public class Game {
    private String input ;
    private String hits ;
    private String misses ;
    public static final  int MAX_MISSES = 7;

    public Game(String input) {
        this.input = input.toLowerCase();
        /**Parameters are for user input, stuff
         that the method doesn't already know.
         The hits and misses attributes are not user input.
         They are part of the Game object's state and are already within its scope,
         which means applyGuess() can access them directly.
         */
        hits = "";
        misses="";
    }
    private char normalizeGuess(char letter){
        if(!Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        letter = Character.toLowerCase(letter);
        if(misses.indexOf(letter)!=-1||hits.indexOf(letter) !=-1){
            throw new IllegalArgumentException(letter + "has already been guessed");
        }
        return letter;
    }
    public boolean applyGuess(String letter){
        if(letter.length()==0){
            throw new IllegalArgumentException("Please enter letter");
        }
        return applyGuess(letter.charAt(0));
    }
     public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit=input.indexOf(letter)!=-1;
        if(isHit){
            hits +=letter;
        }else{
            misses +=letter;
        }
        return isHit;
     }


     public int getRemainingTries(){
        return MAX_MISSES-misses.length();
     }

     public String getCurrentProgress(){
        String isProgress="";
        for(char letter:input.toCharArray()){
            char display ='-';
            if(hits.indexOf(letter)!=-1){
                display = letter;
            }
            isProgress+=display;
        }
        return isProgress;
     }

     public boolean isWon(){
        return getCurrentProgress().indexOf('-')==-1;
     }

    public String getInput() {
        return input;
    }
}
