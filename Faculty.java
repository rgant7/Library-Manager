public class Faculty extends Member {
    public Faculty(String name, String memberId) {
        super(name, memberId);
    }

    @Override
    public synchronized Pair<Boolean, String> checkoutBook(Library library, String ISBN, String copyId) {
        if(getBookCount() >= 10) { // Faculty can check out up to 10 books
            String errorMessage = "Error: Faculty members can only have 10 checked out books at a time. Please return a book.";
            return new Pair<>(false, errorMessage);
        }
        return super.checkoutBook(library, ISBN, copyId);
    }
}