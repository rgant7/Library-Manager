public class Student extends Member {
    public Student(String name, String memberId) {
        super(name, memberId);
    }

    @Override
    public synchronized Pair<Boolean, String> checkoutBook(Library library, String ISBN, String copyId) {
        if(getBookCount() >= 8) { // Students can check out up to 5 books
            String errorMessage = "Error: Students can only have 5 checked out books at a time. Please return a book.";
            return new Pair<>(false, errorMessage);
        }
        return super.checkoutBook(library, ISBN, copyId);
    }
}