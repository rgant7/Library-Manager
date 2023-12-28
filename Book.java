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

    public Pair<Boolean, String> checkoutCopy(String copyId){
        BookCopy copy = copies.get(copyId);
        if (copy == null){
            String errorMessage = "Error: book " + title + " with value of " + copyId + "does not exist";
            return new Pair<>(false, errorMessage);
        }
        else {
            return copy.checkoutCopy();
        }
    }

    public boolean returnCopy(String copyId){
        BookCopy copy = copies.get(copyId);
        if (copy == null){
            System.out.println("Error: book " + title + " with value of " + copyId + "does not exist");
            return false;
        }
        else {
            return copy.returnCopy();
        }
    }
}


