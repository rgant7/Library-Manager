import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create some book copies
        BookCopy copy1 = new BookCopy("Percy Jackson", "Coleens", "123456", "1", false, "good");
        BookCopy copy2 = new BookCopy("Percy Jackson", "Coleens", "123456", "2", false, "good");

        // Create a book with those copies
        HashMap<String, BookCopy> copies = new HashMap<>();
        copies.put(copy1.getId(), copy1);
        copies.put(copy2.getId(), copy2);
        Book percyJackson = new Book(copy1.getTitle(), copy1.getAuthor(), copy1.getISBN(), copies);

        // Create a library with that book
        HashMap<String, Book> books = new HashMap<>();
        books.put(percyJackson.getISBN(), percyJackson);
        Library library = new Library(books);

        // Create a faculty member and a student
        Faculty faculty = new Faculty("Smith", "Faculty ID");
        Student student = new Student("Steven", "Student ID");

        // These threads represent the faculty member and student checking out and returning books concurrently
        Thread thread1 = new Thread(() -> {
            Pair <Boolean, String> facultyPair1 = faculty.checkoutBook(library, copy1.getISBN(), copy1.getId());
            if(!facultyPair1.getValue1()){
                System.out.println(student.getName() + ", " + facultyPair1.getValue2());
            }

            Pair <Boolean, String> facultyPair2 = faculty.checkoutBook(library, copy2.getISBN(), copy2.getId());
            if(!facultyPair2.getValue1()){
                System.out.println(student.getName() + ", " + facultyPair2.getValue2());
            }
        });

        Thread thread2 = new Thread(() -> {
            Pair <Boolean, String> studentPair1 = student.checkoutBook(library, copy1.getISBN(), copy1.getId());
            if(!studentPair1.getValue1()){
                System.out.println(student.getName() + ", " + studentPair1.getValue2());
            }

            Pair <Boolean, String> studentPair2 = student.checkoutBook(library, copy2.getISBN(), copy2.getId());
            if(!studentPair2.getValue1()){
                System.out.println(student.getName() + ", " + studentPair2.getValue2());
            }
        });

        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("faculty books after checkout: " + faculty.borrowedBooksToString());
        System.out.println("student books after checkout: " + student.borrowedBooksToString());
    }
}