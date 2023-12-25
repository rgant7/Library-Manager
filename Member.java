import java.util.HashMap;

public class Member {
    private String name;
    private String memberId;
    private HashMap<String, BookCopy> borrowedBooks;
    private int bookCount = borrowedBooks.size();

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.bookCount = 0;
        this.borrowedBooks = new HashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public int getBookCount() {
        return this.bookCount;
    }

    public HashMap<String, BookCopy> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public void setBorrowedBooks(HashMap<String, BookCopy> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public synchronized void checkoutBook(Library library, String ISBN, String copyId){
        if(bookCount >= 5){
            System.out.println("Error: Members can only have 5 checked out books at a time. Please return a books");
            return;
        }
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
