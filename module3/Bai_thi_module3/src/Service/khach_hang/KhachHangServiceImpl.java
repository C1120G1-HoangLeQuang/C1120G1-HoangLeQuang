//package Service.khach_hang;
//
//import Model.Khachhang;
//import Repository.khach_hang.KhachHangRepository;
//import Repository.khach_hang.KhachHangRepositoryImpl;
//
//import java.util.List;
//
//public class KhachHangServiceImpl implements KhachHangService{
//    KhachHangRepository khachHangRepository = new KhachHangRepositoryImpl();
//
//    @Override
//    public List<Khachhang> findAll() {
//        return khachHangRepository.findAll();
//    }
//
//    @Override
//    public void save(Khachhang khachhang) {
//        khachHangRepository.save(khachhang);
//    }
//
//    @Override
//    public Khachhang findById(String id) {
//        return khachHangRepository.findById(id);
//    }
//
//    @Override
//    public boolean update(Khachhang khachhang) {
//        return khachHangRepository.update(khachhang);
//    }
//
//    @Override
//    public boolean delete(String id) {
//        return khachHangRepository.delete(id);
//    }
//
//    @Override
//    public List<Khachhang> findByEverything(String search) {
//        return khachHangRepository.findByEverything(search);
//    }
//}
