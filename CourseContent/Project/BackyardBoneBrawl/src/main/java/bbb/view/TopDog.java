package bbb.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import bbb.model.BackyardBoneBrawlGame;
import bbb.model.YardCoordinate;
import bbb.model.DigResult;
import bbb.model.GameState;
import bbb.model.Symbol;
import bbb.model.TurnResult;

public class TopDog {
    private final BackyardBoneBrawlGame game;
    private static final Map<Character,String> symbolColorCodes = new HashMap<>() {{
        put(Symbol.GRASS.getAsciiChar(), AnsiColorCodes.GREEN);
        put(Symbol.PART.getAsciiChar(), AnsiColorCodes.RED);
        put(Symbol.HOLE.getAsciiChar(), AnsiColorCodes.RESET);
        put(Symbol.STICK.getAsciiChar(), AnsiColorCodes.BROWN);
        put(Symbol.BONE.getAsciiChar(), AnsiColorCodes.LT_GRAY);
        put(Symbol.SQUEAKER.getAsciiChar(), AnsiColorCodes.BLUE);
        put(Symbol.SHOE.getAsciiChar(), AnsiColorCodes.PURPLE);
        put(Symbol.CHEW_ROPE.getAsciiChar(), AnsiColorCodes.YELLOW);
    }};

    public TopDog(BackyardBoneBrawlGame game) {
        this.game = game;
    }

    private boolean isGameOver(GameState gameState) {
        return gameState == GameState.PLAYER_WON || gameState == GameState.CYBERPUP_WON;
    }

    private YardCoordinate getDigCoordinate(Scanner scanner) {  
        System.out.print("\nEnter dig coordinates (e.g. A5) or 'quit': ");
        String input = scanner.nextLine().toUpperCase();
        if (input.toLowerCase().equals("quit"))
            return null;
        else
            return new YardCoordinate(input);
    }

    private void printYard(String yardString) {
        String[] lines = yardString.split("\n");
        for (int lineNum = 0; lineNum < lines.length; ++lineNum) {
            String line = lines[lineNum];
            for (int charNum = 0; charNum < line.length(); ++charNum) {
                char c = line.charAt(charNum);
                if (lineNum == 0)
                    System.out.print(c + " ");
                else if (charNum == 0)
                    System.out.print(c);
                else {
                    String output = " " + symbolColorCodes.get(c) + c + AnsiColorCodes.RESET;
                    System.out.print(output);
                }
            }   
            System.out.println();
        }
    }

    private void printYards(BackyardBoneBrawlGame game) {
        System.out.println("CyberPup's Board:");
        printYard(game.getCyberPupYard());
        System.out.println();
        System.out.println("Player's Board:");
        printYard(game.getPlayerYard());
    }

    private String getDigResultString(DigResult digResult) {
        switch (digResult) {
            case TOY_PART: return "Toy Part";
            case NOTHING: return "Nothing";
            case FULL_TOY: return "Final Toy Part";
            case INVALID: return "Invalid Coordinate";
            default: return "Unknown Dig Result";
        }
    }

    private void printValidTurnResult(TurnResult turnResult) {
        System.out.println("You dug at " + turnResult.getPlayerDigCoordinate()
                            + ": "
                            + getDigResultString(turnResult.getPlayerDigResult())
                            + "!");
        System.out.println("Computer dug at " + turnResult.getCyberPupDigCoordinate()
                            + ": "
                            + getDigResultString(turnResult.getCyberPupDigResult())
                            + "!");
        System.out.println();
    }

    public void play() {
        try (Scanner scanner = new Scanner(System.in)) {
            GameState gameState = game.getGameState();

            System.out.println("Welcome to Backyard Bone Brawl!");
            System.out.println("Can you dig it?");
            
            printYards(game);
            while (!isGameOver(gameState)) {
                YardCoordinate coord = getDigCoordinate(scanner);
                if (coord == null)
                    break;
                TurnResult turnResult = game.takeTurn(coord);
                if (turnResult.getPlayerDigResult() == DigResult.INVALID) {
                    System.out.println("Invalid coordinates. Please try again.");
                    continue;
                } else
                    printValidTurnResult(turnResult);
                printYards(game);
                gameState = game.getGameState();
            }
        
            if (gameState == GameState.IN_PROGRESS) // player quit
                System.out.println("\nGoodbye!");
            else {
                System.out.println("Game Over!");
                if (gameState == GameState.CYBERPUP_WON)
                    System.out.println("Computer wins!");
                else if (gameState == GameState.PLAYER_WON)
                    System.out.println("Hot Diggity Dog! You win!");
            }
        }
    }
}
