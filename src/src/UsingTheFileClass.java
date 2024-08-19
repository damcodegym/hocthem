import java.io.File;
import java.io.IOException;

public class UsingTheFileClass {
    public static void main(String[] args) {
        String filePath = "example.txt";

        File file = new File(filePath);

        try {
            if (file.exists()) {
                System.out.println("File đã tồn tại.");
            } else {
                if (file.createNewFile()) {
                    System.out.println("File đã được tạo thành công.");
                } else {
                    System.out.println("Không thể tạo file.");
                }
            }

            if (file.isDirectory()) {
                System.out.println("Đây là một thư mục.");
            } else {
                System.out.println("Đây không phải là một thư mục.");
            }

            System.out.println("Đường dẫn của file: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
