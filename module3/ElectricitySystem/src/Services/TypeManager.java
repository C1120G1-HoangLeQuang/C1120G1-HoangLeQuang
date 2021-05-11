package Services;

import Commons.ReadAndWriteType;
import Models.CustomerType;

import java.util.List;

public class TypeManager {
    public void showTypeCustomer() {
        List<CustomerType> typeManagerList = ReadAndWriteType.readType();
        for (int i = 0; i < typeManagerList.size(); i++) {
            System.out.println((i+1) + ". " + typeManagerList.get(i).showInformation());
        }
    }
}
