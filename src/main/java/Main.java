import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя файла для чтения в формате имя_файла.txt");
        String fileName = sc.next();
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("Введите путь к файлу \"" + fileName + "\"");
            String filePath = sc.next();
            file = new File(filePath + "\\" + fileName);
            try {
                Reader reader = new FileReader(file);
            } catch (Exception e){
                System.err.println("Файл не найден");
            }

        }

        try {
            TextAnalytics textAnalytics = new TextAnalytics(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}