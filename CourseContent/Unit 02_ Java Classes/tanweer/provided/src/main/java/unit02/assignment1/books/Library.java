package unit02.assignment1.books;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Library {
    public static final int MAX_BOOKS_CHECKED_OUT = 3;
    public static final int MAX_PATRONS = 50;
    
    private final int numBooks;
    private final Book[] shelves;
    private Patron[] patrons;
    private int patronCount;
    
    public Library (String bookListFile) throws IOException {
        FileReader reader = new FileReader (bookListFile);
        BufferedReader buffReader = new BufferedReader (reader);
        String line = buffReader.readLine ();
        numBooks = Integer.parseInt (line);
        shelves = new Book[numBooks];
        patrons = new Patron[MAX_PATRONS];
        patronCount = 0;

        int index = 0;
        while ((line = buffReader.readLine ()) != null) {
            String[] tokens = line.split (",");
            Book book = new Book (tokens[0], tokens[1]);
            shelves [index] = book;
            index++;
        }

        buffReader.close ();
    }

    private void addPatron (Patron patron) {
        patrons [patronCount] = patron;
        patronCount++;
    }

    private Book findBook (String title) {
        for (Book book: shelves) {
            if (book.getTitle().equals (title) && 
                book.getStatus() == BookStatus.AVAILABLE) {
                return book;
            }
        }
        return null;
    }

    private Patron findPatron (String name) {
        for (Patron patron : patrons) {
            if (patron != null && patron.toString().equals(name)) {
                return patron;
            }
        }
        return null;
    }

    public void checkoutBook (String patronName, String bookTitle) {
        Patron patron = findPatron (patronName);
        if (patron == null) {
            patron = new Patron (patronName);
            addPatron (patron);
        }

        Book book = findBook (bookTitle);
        if (book == null) {
            throw new IllegalArgumentException (bookTitle + " is not in the library");
        }

        for (Book pBook : patron.getBooks ()) {
            if (pBook.equals (book)) {
                throw new IllegalArgumentException ("Cannot check out two copies of a book");
            }
        }
        patron.addBook (book);
    }

    public void returnBook (String patronName, String bookTitle) {
        Patron patron = findPatron (patronName);
        if (patron == null) {
            throw new IllegalArgumentException (patron + " is not a patron of this library");
        }

        Book book = findBook (bookTitle);
        if (book == null) {
            throw new IllegalArgumentException (bookTitle + " is not in the library");
        }

        boolean bookBelongsToPatron = false;
        for (Book pBook : patron.getBooks ()) {
            if (pBook.equals (book)) {
               bookBelongsToPatron = true; 
            }
        }
        if (!bookBelongsToPatron) {
            throw new IllegalArgumentException ("Book not checked out by " + patron);
        }
        patron.returnBook (book);
        book.returnBook();  
    }

    private String[] parseCommand (String command) {
        String[] commands = command.split (" \"");
        if (commands.length >= 3) {
            commands[1] = commands[1].split ("\"")[0];
            commands[2] = commands[2].split ("\"")[0];
        }

        return commands;
    }

    public static void main (String[] args) {
        Library theLibrary;
        try {
            theLibrary = new Library ("data/book_list.txt");
        } catch (IOException ioe) {
            System.out.println ("Could not read book list, aborting program.");
            return;
        }

        System.out.println ("What would you like to do?");
        System.out.println ("  to checkout a book enter: c \"<patron name>\" \"<book name>\"");
        System.out.println ("  to return a book enter: r \"<patron name>\" \"<book name>\"");
        System.out.println ("  enter anything else to exit");
        
        Scanner in = new Scanner (System.in);
        for (;;) {
            String line = in.nextLine ();
            String[] commands = theLibrary.parseCommand (line);
            switch (commands[0]) {
                case "c":
                    try {
                        theLibrary.checkoutBook (commands[1], commands[2]);                  
                    } catch (IllegalArgumentException iae) {
                        System.out.println ("Could not checkout: " + iae.getMessage());
                    }
                break;
                case "r":
                    try {
                        theLibrary.returnBook(commands[1], commands[2]);
                    } catch (IllegalArgumentException iae) {
                        System.out.println ("Could not return: " + iae.getMessage());
                    }
                break;
                default:
                    System.out.println ("We hope you ejoyed your vist to the library.");
                    in.close ();
                    return;
            }
        }
    }
}
