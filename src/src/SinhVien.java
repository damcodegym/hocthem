import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class SinhVien {
    private String maSV;
    private String tenSV;
    private double diemToan;
    private double diemLy;
    private double diemHoa;

    public SinhVien(String maSV, String tenSV, double diemToan, double diemLy, double diemHoa) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public double getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(double diemToan) {
        this.diemToan = diemToan;
    }

    public double getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(double diemLy) {
        this.diemLy = diemLy;
    }

    public double getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(double diemHoa) {
        this.diemHoa = diemHoa;
    }

    // Phương thức toString
    @Override
    public String toString() {
        return maSV + "," + tenSV + "," + diemToan + "," + diemLy + "," + diemHoa;
    }

    public static SinhVien fromString(String str) {
        String[] parts = str.split(",");
        return new SinhVien(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]), Double.parseDouble(parts[4]));
    }


    public static boolean saveSinhVienToFile(SinhVien sv, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(sv.toString() + "\n");
            return true;
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi ghi file: " + e.getMessage());
            return false;
        }
    }

    public static SinhVien[] readSinhVienFromFile(String filePath) {
        List<SinhVien> sinhVienList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sinhVienList.add(SinhVien.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
            return null;
        }
        return sinhVienList.toArray(new SinhVien[0]);
    }

    public static void main(String[] args) {
        String filePath = "sinhvien.txt";

        SinhVien sv1 = new SinhVien("001", "Nguyen Van A", 8.5, 7.0, 9.0);
        SinhVien sv2 = new SinhVien("002", "Tran Thi B", 6.5, 8.0, 7.5);

        if (saveSinhVienToFile(sv1, filePath)) {
            System.out.println("Lưu thông tin sinh viên SV001 thành công.");
        } else {
            System.out.println("Lưu thông tin sinh viên SV001 thất bại.");
        }

        if (saveSinhVienToFile(sv2, filePath)) {
            System.out.println("Lưu thông tin sinh viên SV002 thành công.");
        } else {
            System.out.println("Lưu thông tin sinh viên SV002 thất bại.");
        }

        SinhVien[] sinhVienArray = readSinhVienFromFile(filePath);
        if (sinhVienArray != null) {
            System.out.println("Dữ liệu sinh viên trong file:");
            for (SinhVien sv : sinhVienArray) {
                System.out.println(sv);
            }
        } else {
            System.out.println("Không có dữ liệu sinh viên trong file.");
        }
    }
}
