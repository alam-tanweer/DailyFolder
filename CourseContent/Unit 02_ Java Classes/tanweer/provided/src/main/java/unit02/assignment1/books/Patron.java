package unit02.assignment1.books;

public class Patron {
    private String name;
    private Book[] books;
    private int bookCount;
    
    public Patron (String name) {
        this.name = name;
        books = new Book [Library.MAX_BOOKS_CHECKED_OUT];
        bookCount = 0;
    }

    @Override
    public String toString () {
        return name;
    }

    public Book[] getBooks () {
        Book[] currentBooks = new Book [bookCount];
        int count = 0;
        for (Book book: books) {
            if (book != null) {
                currentBooks [count] = book;
                count++;
            }
        }
        return currentBooks;
    }

    public void addBook (Book book) {
        if (bookCount == books.length) {
            throw new IndexOutOfBoundsException ("Already have max books checked out.");
        }

        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                bookCount++;
                return;
            }
        }
    }

    public void returnBook (Book book) {
        int count = bookCount;
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].equals (book)) {
                books[i] = null;
                bookCount--;
            }
        }

        if (count == bookCount) {
            throw new IllegalArgumentException (book + " was not checked out by " + name);
        }
    }


}
