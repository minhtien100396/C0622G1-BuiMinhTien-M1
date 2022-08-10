package ss7_abstraction_interface.bai_tap.quan_ly_nhan_vien.model;

import java.util.ArrayList;
import java.util.List;

public class QuanLyNhanVien {
    private List<NhanVien> nhanVienList;

    public QuanLyNhanVien() {
    }

    public List<NhanVien> getNhanVienList() {
        return nhanVienList;
    }

    public void setNhanVienList(List<NhanVien> nhanVienList) {
        this.nhanVienList = nhanVienList;
    }

    public void hienThiNhanVien() {
        //For each
        System.out.println("Danh sách tất cả nhân viên");
        for (NhanVien nhanVien : nhanVienList) {
            System.out.println(nhanVien);
        }

//        //For thường  NhanVienList.size() = Array.length
//        for (int i = 0; i <NhanVienList.size() ; i++) {
//            NhanVienList.get(i);
//        }
    }

    public void themNhanVien(NhanVien nhanVien) {
        nhanVienList.add(nhanVien);
    }

    public void hienThiLuongTrungBinh() {
        //Liệt kê danh sách nhân viên fulltime có mức lương thấp hơn mức lương trung bình.
        double sum = 0;
        double luongTrungBinh;
        List<NhanVienFullTime> nhanVienFullTimesList = new ArrayList<>();
        for (NhanVien nhanVien : nhanVienList) {
            sum += nhanVien.getLuong();
        }
        luongTrungBinh = sum / nhanVienList.size();
        System.out.println("Lương trung bình của công ty là: " + luongTrungBinh);
        for (NhanVien nhanVien : nhanVienList) {
            if (nhanVien instanceof NhanVienFullTime && nhanVien.getLuong() < luongTrungBinh) {
                nhanVienFullTimesList.add((NhanVienFullTime) nhanVien);
            }
        }
        System.out.println("Danh sách nhân viên có lương thấp lương hơn trung bình là:");
        if (!nhanVienFullTimesList.isEmpty()) {
            for (NhanVienFullTime nhanVienFullTime : nhanVienFullTimesList) {
                System.out.println(nhanVienFullTime);
            }
        } else {
            System.out.println("Không có nhân viên nào phù hợp");
        }
    }

    public void tinhLuongPhaiTra() {
        //Tính số lương phải trả cho các nhân Viên
        double sum = 0;
        for (NhanVien nhanVien : nhanVienList) {
            if (nhanVien instanceof NhanVienPartTime) {
                sum += (nhanVien).getLuong();
            }
        }
        System.out.println("Tổng lương của nhân viên part time là: " + sum);
    }

    public void sapXepNhanVienFullTime() {
        //Sắp xếp nhân viên full time theo số lương tăng dần
        List<NhanVienFullTime> nhanVienFullTimeList = new ArrayList<>();
        for (NhanVien nhanVien : nhanVienList) {
            if (nhanVien instanceof NhanVienFullTime) {
                nhanVienFullTimeList.add(((NhanVienFullTime) nhanVien));
            }
        }

        for (int i = 0; i < nhanVienFullTimeList.size(); i++) {
            for (int j = 0; j < nhanVienFullTimeList.size() - 1; j++) {
                if (nhanVienFullTimeList.get(j).getLuong() > nhanVienFullTimeList.get(j + 1).getLuong()) {
                    NhanVienFullTime temp = nhanVienFullTimeList.get(j);
                    nhanVienFullTimeList.set(j, nhanVienFullTimeList.get(j + 1));
                    nhanVienFullTimeList.set(j + 1, temp);
                }
            }
        }
        System.out.println("Danh sách nhân viên FullTime sau khi sắp xếp theo lương tăng dần là: ");
        for (NhanVienFullTime nhanVienFullTime : nhanVienFullTimeList) {
            System.out.println(nhanVienFullTime);
        }
    }

}
