import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class TextAnalytics {

    public TextAnalytics(File file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st = br.readLine();
        int count = 0;
        String[] words = new String[0];
        ArrayList<String> text = new ArrayList<String>();
        SortedSet<String> unical = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);


        while (st != null) {
            words = st.split("[^A-Za-zА-Яа-я]+");
            for (String w : words) {
                text.add(w);
                unical.add(w);
            }
            st = br.readLine();
        }
        Collections.sort(text, String.CASE_INSENSITIVE_ORDER);
        System.out.println(unical);
        System.out.println("Всего слов: " + text.size() + "\nУникальных: " + unical.size());
        String maxWord = "";
        int maxCnt = 0;
        for (String u : unical) {
            int cnt = 0;
            for (String t : text) {
                if (u.equalsIgnoreCase(t))
                    cnt++;
            }
            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxWord = u;
            } else if (cnt == maxCnt)
                maxWord += "\" и \"" + u;
            System.out.println(u + "[" + cnt + "]");
        }
        System.out.println("Чаще всего повторяется: \"" + maxWord + "\" (" + maxCnt + " раз)");
    }
}
