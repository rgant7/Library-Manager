public class Student extends Member {
    public Student(String name, String memberId) {
        super(name, memberId);
    }

    @Override
    public synchronized void checkoutBook(Library library, String ISBN, String copyId) {
        if(getBookCount() >= 8) { // Students can check out up to 5 books
            System.out.println("Error: Students can only have 5 checked out books at a time. Please return a book.");
            return;
        }
        super.checkoutBook(library, ISBN, copyId);
    }
}