public class BookCopy {
    private String copyId;
    private boolean isCheckedOut;
    private String condition;

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
        isCheckedOut = true;
    }

    public void returnCopy(){
        isCheckedOut = false;
    }
}