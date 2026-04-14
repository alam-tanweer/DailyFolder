package unit08.assignment1.pacman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import unit08.weighted.WPath;

public class MazeMaker {
    public static PacManMaze loadMaze(String filename) throws IOException {
        try(FileReader fr = new FileReader(filename);
            BufferedReader reader = new BufferedReader(fr)) {
            PacManMaze maze = new PacManMaze();
            String line = reader.readLine();
            while(line != null) {
                String[] cells = line.split(" ");
                Cell cell = parseCell(cells[0]);
                if(!maze.contains(cell)) {
                    maze.add(cell);
                }
                for(int i=1; i<cells.length; i++) {
                    Cell neighbor = parseCell(cells[i]);
                    if(!maze.contains(neighbor)) {
                        maze.add(neighbor);
                    }
                    double weight = cell.isGhost() || neighbor.isGhost() ?
                        5000 : 1;
                    maze.connect(cell, neighbor, weight);
                }
                line = reader.readLine();
            }

            return maze;
        }
    }

    public static Cell parseCell(String cellString) {
        String[] tokens = cellString.split("-");

        CellType state = null;
        switch(tokens[0]) {
            case "PE":
                state = CellType.PELLET;
                break;
            case "PP":
                state = CellType.POWER_PELLET;
                break;
            case "GH":
                state = CellType.GHOST;
                break;
            case "PM":
                state = CellType.PAC_MAN;
                break;
            default:
                throw new IllegalStateException("Unknown cell state " 
                    + tokens[0]);
        }
        int row = Integer.parseInt(tokens[1]);
        int col = Integer.parseInt(tokens[2]);
        return new Cell(row, col, state);
    }

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a .maz filename: ");
        String filename = scanner.nextLine();
        scanner.close();
        try {
            PacManMaze maze = MazeMaker.loadMaze(filename);
            List<Cell> cells = maze.getPowerPellets();
            Cell pacMan = maze.getPacMan();

            Cell from = pacMan;
            while(cells.size() > 0) {
                Cell to = cells.remove(cells.size() - 1);
                WPath<Cell> path = maze.dijkstrasPath(from, to);
                System.out.println(path);
                from = to;
            }
        } catch(IOException e) {
            System.err.println("Could not load file: " + filename);
        }
    }

}
