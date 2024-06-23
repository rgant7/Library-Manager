package com.librarymanager;

import java.util.concurrent.locks.ReentrantLock;

public class BookCopy extends Book {
    private String copyId;
    private boolean isCheckedOut;
    private String condition;
    private ReentrantLock checkoutLock = new ReentrantLock();
    private ReentrantLock returnLock = new ReentrantLock();

    BookCopy(String title, String author, String ISBN, String copyId, boolean isCheckedOut, String condition){
        super(title, author, ISBN, null);
        this.copyId = copyId;
        this.isCheckedOut = isCheckedOut;
        this.condition = condition;
    }

    BookCopy(){
        super("title", "author", "ISBN", null);
        this.copyId = "copyId";
        this.isCheckedOut = false;
        this.condition = "condition";
    }

    public String getId() {
        return this.copyId;
    }

    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setId(String copyId) {
        this.copyId = copyId;
    }

    public void setIsCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Pair <Boolean, String> checkoutCopy(){
        checkoutLock.lock();
        try{
            if(isCheckedOut){
                String errorMessage = "Error: Book \"" + getTitle() + "\" with ID \"" + getId() + "\" is already checked out.";
                return new Pair<>(false, errorMessage);
            }
            else{
                isCheckedOut = true;
                return new Pair <>(true, "");
            }
        }
        finally{
            checkoutLock.unlock();
        }
    }

    public boolean returnCopy(){
        returnLock.lock();
        try{
            if(!isCheckedOut){
                System.out.println("Error: This book has not been checked out");
                return false;
            }
            else{
                isCheckedOut = false;
                return true;
            }
        }
        finally{
            returnLock.unlock();
        }
    }
}