import java.util.concurrent.locks.ReentrantLock;

public class BookCopy {
    private String copyId;
    private boolean isCheckedOut;
    private String condition;
    private ReentrantLock checkoutLock = new ReentrantLock();
    private ReentrantLock returnLock = new ReentrantLock();

    BookCopy(String copyId, boolean isCheckedOut, String condition){
        this.copyId = copyId;
        this.isCheckedOut = isCheckedOut;
        this.condition = condition;
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

    public void checkoutCopy(){
        checkoutLock.lock();
        try{
            if(isCheckedOut){
                System.out.println("Error: This book is already checked out");
            }
            else{
                isCheckedOut = true;
            }
        }
        finally{
            checkoutLock.unlock();
        }
    }

    public void returnCopy(){
        returnLock.lock();
        try{
            if(!isCheckedOut){
                System.out.println("Error: This book has not been checked out");
            }
            else{
                isCheckedOut = false;
            }
        }
        finally{
            returnLock.unlock();
        }
    }
}