package bai_tap_tu_luyen.quan_ly_nhan_vien.service.eplm;

import bai_tap_tu_luyen.quan_ly_nhan_vien.model.NhanVien;
import bai_tap_tu_luyen.quan_ly_nhan_vien.model.NhanVienFullTime;
import bai_tap_tu_luyen.quan_ly_nhan_vien.model.NhanVienPartTime;
import bai_tap_tu_luyen.quan_ly_nhan_vien.service.INhanVienService;

import java.util.*;

public class NhanVienService implements INhanVienService {
    Scanner scanner = new Scanner(System.in);
    private static List<NhanVien> nhanViens = new ArrayList<>();
    static {
        nhanViens.add(new NhanVienFullTime(1, "Tiến", 20, "093111", "minhtien", 10, 5, 1000));
        nhanViens.add(new NhanVienFullTime(2, "Trung", 16, "09154", "minhtrung", 5, 2, 50));
        nhanViens.add(new NhanVienPartTime(3, "Bia", 21, "091451", "minhchu", 5));
        nhanViens.add(new NhanVienPartTime(4, "Ngô", 15, "091451", "minhchu", 10));
    }

    @Override
    public void hienThiAll() {
        for (NhanVien nhanVien : nhanViens) {
            System.out.println(nhanVien);
        }
    }

    @Override
    public void themNhanVien() {
        NhanVien nhanVien = this.thongTinNhanVien();
        nhanViens.add(nhanVien);
        System.out.println("Đã thêm thành công");
    }

    @Override
    public void lietKeNhanVien() {
        System.out.println(tinhLuongTrungBinh());
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien instanceof NhanVienFullTime) {
                if (nhanVien.tinhLuong() < tinhLuongTrungBinh()) {
                    System.out.println(nhanVien.toString());
                }
            }
        }
    }

    @Override
    public void tinhLuong() {
        double sum = 0;
        for (NhanVien nhanVien : nhanViens) {
            if (nhanVien instanceof NhanVienPartTime) {
                sum += nhanVien.tinhLuong();
            }
        }
        System.out.println(sum);
    }

    @Override
    public void sapXep() {
        Comparator<NhanVien> nhanVienComparator = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.tinhLuong()>o2.tinhLuong()?1:-1;
            }
        };
        Collections.sort(nhanViens,nhanVienComparator);
        hienThiAll();
    }

    public NhanVien thongTinNhanVien() {
        System.out.println("------------------------------------------------");
        System.out.println("Thông tin chung cho tất cả nhân viên");
        System.out.println("Mời bạn nhập mã nhân viên");
        int maNhanVien = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập tên nhân viên");
        String tenNhanVien = scanner.nextLine();
        System.out.println("Mời bạn nhập tuổi nhân viên");
        int tuoiNhanVien = Integer.parseInt(scanner.nextLine());
        System.out.println("Mời bạn nhập phone nhân viên");
        String phoneNhanVien = scanner.nextLine();
        System.out.println("Mời bạn nhập mail nhân viên");
        String mailNhanVien = scanner.nextLine();
        System.out.println("Bạn muốn nhập thông tin cho nhân viên :");
        System.out.println("1. Nhân Viên FullTime");
        System.out.println("2. Nhân Viên PartTime");
        System.out.println("3.Exit");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Mời bạn nhập lương thưởng cho nhân viên");
                double luongThuong = Double.parseDouble(scanner.nextLine());
                System.out.println("Mời bạn nhập tiền phạt cho nhân viên");
                double tienPhat = Double.parseDouble(scanner.nextLine());
                System.out.println("Mời bạn nhập lương cứng cho nhân viên");
                double luongCung = Double.parseDouble(scanner.nextLine());
                NhanVienFullTime nhanVienFullTime = new NhanVienFullTime(maNhanVien, tenNhanVien, tuoiNhanVien, phoneNhanVien, mailNhanVien, luongThuong, tienPhat, luongCung);
                return nhanVienFullTime;
            case 2:
                System.out.println("Mời bạn nhập giờ làm việc cho nhân viên");
                double gioLamViec = Double.parseDouble(scanner.nextLine());
                NhanVienPartTime nhanVienPartTime = new NhanVienPartTime(maNhanVien, tenNhanVien, tuoiNhanVien, phoneNhanVien, mailNhanVien, gioLamViec);
                return nhanVienPartTime;
        }
        return null;
    }

    public static double tinhLuongTrungBinh() {
        double sum = 0;
        for (NhanVien nhanVien : nhanViens) {
            sum += nhanVien.tinhLuong();
        }
        return sum / nhanViens.size();
    }
}
