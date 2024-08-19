import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWriteExample {

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            int ch;
            while ((ch = reader.read()) != -1) {
                content.append((char) ch);
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        }
        return content.toString();
    }

    public static boolean writeFile(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String filePath = "example.txt";
        String dataToWrite = "Xin chào, đây là dữ liệu thử nghiệm.";

        if (writeFile(filePath, dataToWrite)) {
            System.out.println("Ghi dữ liệu thành công.");
        } else {
            System.out.println("Ghi dữ liệu thất bại.");
        }

        String fileContent = readFile(filePath);
        System.out.println("Nội dung file: " + fileContent);
    }
}
