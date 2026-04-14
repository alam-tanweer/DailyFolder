package unit08.assignment2.minesweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import unit08.backtracker.Backtracker;
import unit08.backtracker.Configuration;

public class MineSweeper implements Configuration <MineSweeper> {

    private static final char MINE = '*';
    private static final char FLAG = 'F';

    private final String board [];
    private final int index;
    private final int rows;
    private final int columns;
    private final int count;
    private final char map [];


    public MineSweeper (String mapFile, int row, int col) {
        // This code is a little messier than required due to making the map final.
        // It could be simplified by using a modifiable map even though the map will 
        // never change.
        int rows = 0;
        int cols = 0;
        String line = null;
        BufferedReader in = null;
        try {
            FileReader fin = new FileReader (mapFile);
            in = new BufferedReader (fin);
            line = in.readLine ();
            String[] values = line.strip().split (" ");
            rows = Integer.parseInt (values [0]);
            cols = Integer.parseInt (values [1]);
        } catch (IOException ioe) {
            System.out.println (ioe.getMessage ());
        }

        map = new char [rows * cols];
        int lineCount = 0;

        try {
            line = in.readLine ();
            while (line != null) {
                for (int i = 0; i < line.length (); i++) {
                    map [cols * lineCount + i] = line.charAt (i);
                }
                lineCount++;
                line = in.readLine ();
            }
            in.close ();
        } catch (IOException ioe) {
            System.out.println (ioe.getMessage ());
        }

        board = new String [rows * cols];
        this.rows = rows;
        this.columns = cols;
        this.index = row * columns + col - 1;
        count = 0;
    }

    public MineSweeper (MineSweeper orig) {
        board = Arrays.copyOf (orig.board, orig.board.length);
        columns = orig.columns;
        rows = orig.rows;
        this.index = (orig.index + 1) % board.length;
        count = orig.count + 1;
        this.map = orig.map;
    }

    private MineSweeper next (String value) {
        MineSweeper successor = new MineSweeper (this);
        successor.board [index] = value;
        return successor;
    }

    @Override
    public Collection <MineSweeper> getSuccessors () {
        List <MineSweeper> successors = new ArrayList<> ();
        successors.add (next ((count + 1) + ""));
        successors.add (next ((count + 1) + "" + FLAG));

        return successors;
    }

    @Override
    public boolean isValid () {
        String current = board [index];
        return (map [index] != MINE) || (current.charAt (current.length() - 1) == FLAG);     
    }

    @Override
    public boolean isGoal () {
        return count == board.length;
    }

    @Override
    public String toString() {
        StringBuilder sBuilder = new StringBuilder ();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                sBuilder.append (String.format ("%6s", board [row * columns + col]));
                sBuilder.append (' ');
            }
            sBuilder.append ("\n");
        }

        return sBuilder.toString ();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        System.out.print ("Enter the map file: ");
        String filename = in.nextLine ();
        System.out.print ("Enter the row and column to start your sweep: ");
        int row = in.nextInt ();
        int col = in.nextInt ();
        in.close ();

        MineSweeper ms = new MineSweeper (filename, row, col);
        Backtracker <MineSweeper> bt = new Backtracker<> (false);
        MineSweeper solution = bt.solve (ms);
        System.out.println (solution);
    }
    
}
