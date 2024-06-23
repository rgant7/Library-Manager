package com.librarymanager;

import java.util.HashMap;

public class Member {
    private String name;
    private String memberId;
    private HashMap<String, BookCopy> borrowedBooks;
    private int bookCount;

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.bookCount = 0;
        this.borrowedBooks = new HashMap<String, BookCopy>();
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
        bookCount = this.borrowedBooks.size();
    }

    public synchronized Pair<Boolean, String> checkoutBook(Library library, String ISBN, String copyId){
        if(bookCount >= 5){
            String errorMessage = "Error: Members can only have 5 checked out books at a time. Please return a books";
            return new Pair<>(false, errorMessage);
        }
        Pair<Boolean, String> checkoutPair = library.checkoutCopy(ISBN, copyId);
        if (checkoutPair.getValue1()){
            Book book = library.getBooks().get(ISBN);
            BookCopy copy = book.getCopies().get(copyId);
            
            borrowedBooks.put(copyId, copy);
            bookCount = borrowedBooks.size();
        }

        return checkoutPair;
    }

    public synchronized void returnBook(Library library, String ISBN, String copyId){
        library.returnCopy(ISBN, copyId);
        borrowedBooks.remove(copyId);
        bookCount = borrowedBooks.size();
    }

    public String borrowedBooksToString(){
        String returnedString = "\n";
        for (BookCopy value : borrowedBooks.values()) {
            returnedString += value.getTitle() + ", ID: " + value.getId() + '\n';
        }
        return returnedString;
    }
}
