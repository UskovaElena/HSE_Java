public class Passenger {
    private int from;
    private int to;

    Passenger(int from, int to) {
        setFrom(from);
        setTo(to);
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
}
