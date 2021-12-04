import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<String> comments = new ArrayList<>();
        comments.add("Всем привет");
        comments.add("Люблю вафли");
        comments.add("Продам енота");
        comments.add("Хай Икил");

        Set<String> blackList = new HashSet<>();
        blackList.add("продам");
        blackList.add("икил");
        blackList.add("UFO");

        new BlackList().filterComments(comments, blackList);

        for (String comment : comments) System.out.println(comment);
    }
}