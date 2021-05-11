package Library;

import Common.FuncReadAndWrite;
import Common.ReadAndWriteForeign;
import Common.ReadAndWriteType;
import Common.ReadAndWriteVietnamese;
import Model.ForeignCustomer;
import Model.TypeCustomer;
import Model.VietnameseCustomer;
import Validate.IdForeignRegex;
import Validate.IdVietnameseRegex;
import Validate.NameCustomerRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ForeignManager {
    Scanner scanner = new Scanner(System.in);
    public void addForeign() {
        List<ForeignCustomer> foreignCustomerList = new ArrayList<>();
        String idForeign;
        do {
            System.out.print("Enter Id customer: ");
            idForeign = scanner.nextLine();
        } while (!IdForeignRegex.idForeign(idForeign));
        String name;
        do {
            System.out.print("Enter name customer: ");
            name = scanner.nextLine();
        } while (!NameCustomerRegex.nameCustomer(name));
        System.out.print("Enter nationality: ");
        String nationality = scanner.nextLine();
        ForeignCustomer foreignCustomer = new ForeignCustomer(idForeign, name, nationality);
        foreignCustomerList.add(foreignCustomer);
    }
}
