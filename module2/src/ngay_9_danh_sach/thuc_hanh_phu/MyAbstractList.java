package ngay_9_danh_sach.thuc_hanh_phu;

public abstract class MyAbstractList<E> implements InterfaceMyList<E> {
    protected int sizeList = 0;

    public MyAbstractList() {
    }
    public MyAbstractList(E[] object) {
        for (int i = 0; i < object.length; i++) {
            add(object[i]);
        }
    }

    @Override
    public void add(E e) {
        add(sizeList, e);
    }

    @Override
    public boolean isEmpty() {
        return sizeList == 0;
    }

    @Override
    public int size() {
        return sizeList;
    }

    @Override
    public boolean remove(E e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        } else {
            return false;
        }
    }
}
