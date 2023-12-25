import java.util.HashMap;

public class Member {
    private String name;
    private HashMap<String, BookCopy> borrowedBooks;

    public Member(String name) {
        this.name = name;
        this.borrowedBooks = new HashMap<>();
    }

    public synchronized void checkoutBook(Library library, String ISBN, String copyId){
        library.checkoutCopy(ISBN, copyId);

        Book book = library.getBooks().get(ISBN);
        BookCopy copy = book.getCopies().get(copyId);
        
        borrowedBooks.put(copyId, copy);
    }

    public synchronized void returnBook(Library library, String ISBN, String copyId){
        library.returnCopy(ISBN, copyId);
        borrowedBooks.remove(copyId);
    }
}
