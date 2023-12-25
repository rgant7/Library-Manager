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

    public void checkoutCopy(String ISBN, String copyId){
        Book book = books.get(ISBN);
        if (book == null){
            System.out.println("Error: ISBN " + ISBN + "does not exist");
        }
        else {
            //functionality is abstracted away into Book class
            book.checkoutCopy(copyId);
        }
    }

    public void returnCopy(String ISBN, String copyId){
        Book book = books.get(ISBN);
        if (book == null){
            System.out.println("Error: ISBN " + ISBN + "does not exist");
        }
        else {
            //functionality is abstracted away into Book class
            book.returnCopy(copyId);
        }
    }
}
