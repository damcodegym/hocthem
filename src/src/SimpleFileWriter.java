import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào tên file: ");
        String filePath = scanner.nextLine();

        System.out.print("Nhập vào chuỗi dữ liệu cần lưu: ");
        String data = scanner.nextLine();

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
            System.out.println("Dữ liệu đã được ghi vào file thành công.");
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
        }
    }
}
