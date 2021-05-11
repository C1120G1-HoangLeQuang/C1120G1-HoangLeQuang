package Library;

import Common.FuncReadAndWrite;
import Models.BenhAn;

import java.util.ArrayList;
import java.util.List;

public class QuanLyBenhAn {
    FuncReadAndWrite<BenhAn> funcReadAndWrite = new FuncReadAndWrite<>();

    public List<BenhAn> timBenhAn() {
        List<String[]> list = FuncReadAndWrite.readFile("medical_records.csv");
        List<BenhAn> listBenhAn = new ArrayList<>();
        BenhAn benhAn = null;
        for (String[] line : list) {
            listBenhAn.add(benhAn);
        }
        return listBenhAn;
    }
    public void them(BenhAn benhAn) {
        List<BenhAn> list = new ArrayList<>();
        list.add(benhAn);
        funcReadAndWrite.writeFile("medical_records.csv", list, true);
    }
    public void hienThi() {
        List<BenhAn> list = timBenhAn();
        int i = 1;
        for (BenhAn benhAn : list) {
            System.out.print(i + ". ");
            benhAn.hienThi();
            i++;
        }
    }
}
