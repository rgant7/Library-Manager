public class BookCopy {
    private String id;
    private boolean isCheckedOut;
    private String condition;

    BookCopy(String id, boolean isCheckedOut, String condition){
        this.id = id;
        this.isCheckedOut = isCheckedOut;
        this.condition = condition;
    }

    public String getId() {
        return this.id;
    }

    public boolean getIsCheckedOut() {
        return this.isCheckedOut;
    }

    public String getCondition() {
        return this.condition;
    }

    public void setId(String id) {
        this.id = id;
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