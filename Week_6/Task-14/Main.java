

public class Main {
    public static void main(String[] args) {
//        System.out.println(GetFiles.moviesToHashMap().size());

        for (int i : GetFiles.viewsList()) {
            System.out.printf("%s, ", i);
        }
    }
}