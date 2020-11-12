import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
        System.out.println("Guess the word Please");
        String answer = scan.nextLine();

        Game game = new Game(answer);
        Prompter prompter = new Prompter(game);
        while(game.getRemainingTries()>0 && !game.isWon()){
            prompter.promptForGuess();
            prompter.displayProgress();
        }
        prompter.displayOutcome();
    }
}
