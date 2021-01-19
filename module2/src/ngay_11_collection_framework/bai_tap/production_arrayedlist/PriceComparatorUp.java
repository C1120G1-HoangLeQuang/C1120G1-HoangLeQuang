package ngay_11_collection_framework.bai_tap.production_arrayedlist;

import java.util.Comparator;

public class PriceComparatorUp implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else {
            return 0;
        }
    }
}
