package Library;

import Common.ReadAndWriteBrand;
import Model.Brand;

import java.util.List;

public class BrandManager {
    public void showBrand() {
        List<Brand> listBrand = ReadAndWriteBrand.readBrand();
        for (int i = 0; i < listBrand.size(); i++) {
            System.out.println((i+1) + ". " + listBrand.get(i).showInformation());
        }
    }
}
