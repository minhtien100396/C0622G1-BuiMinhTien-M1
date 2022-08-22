package ss16_text_file.luyen_tap.common2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "src\\ss16_text_file\\luyen_tap\\common2\\data\\2.csv";
    public static void main(String[] args) {
        List<HocSinh2> hocSinh2List = new ArrayList<>();
        HocSinh2 hocSinh2 = new HocSinh2(1,"Tiến","20/12/12");
        HocSinh2 hocSinh3 = new HocSinh2(2,"Trung","20/12/2001");
        HocSinh2 hocSinh4 = new HocSinh2(3,"Bia","20/12/1992");
        hocSinh2List.add(hocSinh2);
        hocSinh2List.add(hocSinh3);
        hocSinh2List.add(hocSinh4);
        //Output FIle
        String line = null;
        for (HocSinh2 hocSinh:hocSinh2List) {
            line=hocSinh.getId()+","+hocSinh.getName()+","+hocSinh.getDateOfBirth();
            FileReadAndWriter.fileWriter(FILE_NAME,line);
        }

        //Input File

        List<String> listLine = FileReadAndWriter.fileReader(FILE_NAME);
        System.out.println(listLine.get(0));
        String[] newListLine = listLine.get(0).split(",");
        HocSinh2 hocSinh = new HocSinh2(Integer.parseInt(newListLine[0]),newListLine[1],newListLine[2]);
        System.out.println(hocSinh.getId()+" "+hocSinh.getName()+" "+hocSinh.getDateOfBirth());
    }
}
