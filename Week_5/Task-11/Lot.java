public class Lot {
    private volatile int cost;
    private volatile String nameOfBuyer;
    private final long timeOfSale; // время задается в формате POSIX

    public Lot(int cost, long timeOfSale) {
        this.cost = cost; // задаем стартовую цену лота
        this.timeOfSale = timeOfSale; // задаем время до продажи лота
    }

    public void showThis() {
        System.out.println(this);
    }

    public void bid(int cost, String nameOfBuyer, long time) {
        if (cost > this.cost && time < this.timeOfSale) {
            synchronized (this) {
                if (cost > this.cost) {
                    this.cost = cost;
                    this.nameOfBuyer = nameOfBuyer;
                }
            }
        } else {
            System.out.println("Your bid is less than existing one or the auction is end");
        }
    }

    public String whoWon(long time) {
        if (time >= timeOfSale) return "The winner is: " + this.nameOfBuyer;
        else return "Lot is active!";
    }
}
