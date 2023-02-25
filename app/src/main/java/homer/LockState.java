package homer;

public class LockState {

    private boolean isLocked = false;

    public boolean isLocked() {
        return this.isLocked;
    }

    public void lock() {
        this.isLocked = true;
    }

    public void unlock() {
        this.isLocked = false;
    }

    @Override
    public String toString() {
        return "LockState [isLocked=" + isLocked + "]";
    }

}
