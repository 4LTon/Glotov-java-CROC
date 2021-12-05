package Recommend;

public class User {
    private final String viewingHistory;

    public User (String viewingHistory) {
        this.viewingHistory = viewingHistory;
    }

    @Override
    public String toString() {
        return viewingHistory;
    }
}
