import java.util.HashMap;

public class Library {
    private HashMap <String, Book> books;

    public Library(HashMap<String, Book> books){
        this.books = books;
    }

    public HashMap<String, Book> getBooks(){
        return books;
    }

    public void setBooks(HashMap<String, Book> books){
        this.books = books;
    }

    public Pair<Boolean, String> checkoutCopy(String ISBN, String copyId){
        Book book = books.get(ISBN);
        if (book == null){
            String errorMessage = "Error: ISBN " + ISBN + "does not exist";
            return new Pair<>(false, errorMessage);
        }
        else {
            return book.checkoutCopy(copyId);
        }
    }

    public boolean returnCopy(String ISBN, String copyId){
        Book book = books.get(ISBN);
        if (book == null){
            System.out.println("Error: ISBN " + ISBN + "does not exist");
            return false;
        }
        else {
            //functionality is abstracted away into Book class
            return book.returnCopy(copyId);
        }
    }
}
