import java.util.HashMap;

public class Book {
    private String title;
    private String author;
    private String ISBN;
    private HashMap<String, BookCopy> copies;

    public Book(String title, String author, String ISBN, HashMap<String, BookCopy> copies){
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.copies = copies;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public HashMap<String, BookCopy> getCopies() {
        return copies;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setCopies(HashMap<String, BookCopy> copies) {
        this.copies = copies;
    }

    public void checkoutCopy(String id){
        BookCopy copy = copies.get(id);
        if (copy == null){
            System.out.println("Error: book " + title + " with value of " + id + "does not exist");
        }
        else {
            copy.checkoutCopy();
        }
    }

    public void returnCopy(String id){
        BookCopy copy = copies.get(id);
        if (copy == null){
            System.out.println("Error: book " + title + " with value of " + id + "does not exist");
        }
        else {
            copy.returnCopy();
        }
    }
}


