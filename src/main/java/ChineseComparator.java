import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * @author: Joseph Li @ Dancincloud
 * Date: 11/7/21 11:53
 **/

public class ChineseComparator implements Comparator<String> {

    Collator collator = Collator.getInstance(Locale.CHINA);

    public int compare(String s1, String s2){
        return collator.compare(s1, s2);
    }

    public static void main(String[] args) {
        // "啊","这", "都", "能", "赢" => "a", "zhe", "dou", "neng", "ying"
        String[] words = new String[]{"啊","这", "都", "能", "赢"};
        Arrays.sort(words, new ChineseComparator());

        for(String word : words){
            System.out.print(word + ", ");
        }

        System.out.println();
    }
}