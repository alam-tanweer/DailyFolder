package unit02.assignment1.books;

public class Book {
    private String title;
    private String author;
    private BookStatus status;

    public Book (String title, String author) {
        this.title = title;
        this.author = author;
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public boolean equals (Object o) {
        if (o instanceof Book) {
            Book other = (Book) o;
            if (title == other.title && author == other.author) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString () {
        return "\"" + title + "\", " + author;
    }

    public String getTitle () {
        return title;
    }

    public String getAuthor () {
        return author;
    }

    public BookStatus getStatus () {
        return status;
    }

    public void checkout () {
        status = BookStatus.CHECKED_OUT;
    }

    public void returnBook () {
        status = BookStatus.AVAILABLE;
    }
}
