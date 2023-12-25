import java.util.HashMap;

public class Book {
    private String title;
    private String author;
    private HashMap<String, BookCopies> copies;

    public Book(String title, String author, HashMap copies){
        this.title = title;
        this.author = author;
        this.copies = copies;
    }
}

