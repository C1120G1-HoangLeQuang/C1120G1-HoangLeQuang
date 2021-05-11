package Library;

import Common.ReadAndWriteType;
import Common.ReadAndWriteVietnamese;
import Model.TypeCustomer;
import Model.VietnameseCustomer;
import Validate.IdVietnameseRegex;
import Validate.NameCustomerRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VietnameseManager {
    Scanner scanner = new Scanner(System.in);
    TypeManager typeManager = new TypeManager();
    VietnameseCustomer vietnameseCustomer = new VietnameseCustomer();
    public void addVietnamese() {
        List<VietnameseCustomer> listVietnamese = new ArrayList<>();
        List<TypeCustomer> typeCustomerList = ReadAndWriteType.readType();
        String idVNCustomer;
        do {
            System.out.print("Enter Id customer: ");
            idVNCustomer = scanner.nextLine();
        } while (!IdVietnameseRegex.idVietnamese(idVNCustomer));
        String name;
        do {
            System.out.print("Enter name customer: ");
            name = scanner.nextLine();
        } while (!NameCustomerRegex.nameCustomer(name));
        typeManager.showTypeCustomer();
        System.out.println("Enter stt of type customer");
        int idType = Integer.parseInt(scanner.nextLine());
        String typeCustomer = typeCustomerList.get(idType - 1).getNameType();
        vietnameseCustomer.setTypeCustomer(typeCustomer);
        int limitedUsing = 0;
        try {
            System.out.println("Enter limited using: ");
            limitedUsing = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to be enter integer number");
        }
        VietnameseCustomer vietnameseCustomer = new VietnameseCustomer(idVNCustomer, name, typeCustomer, limitedUsing);
        listVietnamese.add(vietnameseCustomer);
        ReadAndWriteVietnamese.writeVietnamese(listVietnamese, true);
    }
    public void showCustomer() {

    }
}
