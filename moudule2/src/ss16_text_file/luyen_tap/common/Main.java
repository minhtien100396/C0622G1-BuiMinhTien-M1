package ss16_text_file.luyen_tap.common;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Ghi tất cả danh sách học sinh vào file csv
     * File csv: tất cả các thuộc tính ngăn cách bởi dấu phẩy
     * Các học sinh sẽ lưu theo từng line
     */
    public static final String FILE_NAME = "src\\ss16_text_file\\luyen_tap\\common\\data\\hocsinh.csv";
    public static final String COMMA = ",";

    public static void main(String[] args) {
        //Output File
        HocSinh hocSinh1 = new HocSinh(1, "Tiến", "20/10/1996");
        HocSinh hocSinh2 = new HocSinh(2, "Bia", "20/3/2000");
        HocSinh hocSinh3 = new HocSinh(3, "Tuấn", "10/3/1900");
        List<HocSinh> hocSinhList = new ArrayList<>();
        hocSinhList.add(hocSinh1);
        hocSinhList.add(hocSinh2);
        hocSinhList.add(hocSinh3);
        String line = null;
        for (HocSinh hocSinh : hocSinhList) {
            line = hocSinh.getId() + COMMA + hocSinh.getName() + COMMA + hocSinh.getDateOfBirth();
            FileUltil.writerFile(FILE_NAME, line);

        }
        //Input File
        List<String> listLine = FileUltil.readFile(FILE_NAME);
        String[] lineSplit = listLine.get(0).split(COMMA);
        HocSinh hocSinh = new HocSinh(Integer.parseInt(lineSplit[0]), lineSplit[1], lineSplit[2]);
        System.out.println(hocSinh.getId() + " " + hocSinh.getName() + " " + hocSinh.getDateOfBirth());
    }
}
