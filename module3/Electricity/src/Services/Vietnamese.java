package Services;

import Common.FuncReadAndWrite;
import Model.VietnameseCustomer;

import java.util.ArrayList;
import java.util.List;

public class Vietnamese {
    FuncReadAndWrite<VietnameseCustomer> funcReadAndWrite = new FuncReadAndWrite<>();
    public void add(VietnameseCustomer vietnameseCustomer) {
        List<VietnameseCustomer> list = new ArrayList<>();
        list.add(vietnameseCustomer);
        funcReadAndWrite.writeFile("Customer.csv", list, true);
    }
}
