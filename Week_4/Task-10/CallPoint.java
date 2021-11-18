public class CallPoint implements Comparable<CallPoint> {
    private final long time;
    private final boolean isStartOfContact;

    public CallPoint(Long time, boolean isStartOfContact) {
        this.time = time;
        this.isStartOfContact = isStartOfContact; // TRUE - начало звонка; FALSE - конце звонка
    }

    public boolean isStartOfContact() {
        return isStartOfContact;
    }

    @Override
    public String toString() {
        return "Time: " + time + "; isStartOfContact: " + isStartOfContact;
    }

    // переопределяем метод для сортировки
    @Override
    public int compareTo(CallPoint p1) {
        if (this.time < p1.time) return -1;
        else if (this.time == p1.time) {
            // первой выводится точка со статусом TRUE
            if (this.isStartOfContact) return -1;
            else return 1;
        }
        return 1;
    }
}
