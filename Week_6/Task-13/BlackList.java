import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BlackList implements BlackListFilter {
    
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {

        Pattern pattern = Pattern.compile("[A-zА-я@0-9]+");

        for (int i = 0; i < comments.size(); i++) {
            Matcher matcher = pattern.matcher(comments.get(i));

            while (matcher.find()) {
                if (blackList.contains(matcher.group().toLowerCase(Locale.ROOT))) {
                    comments.remove(comments.get(i));
                    --i;
                    break;
                }
            }
        }
    }
}