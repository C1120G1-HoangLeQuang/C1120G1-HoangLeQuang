package Controller;

import Common.*;
import Library.QuanLyBenhAn;
import Models.BenhAn;
import Models.BenhAnThuong;
import Models.BenhAnVIP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    static Scanner scanner = new Scanner(System.in);
    static QuanLyBenhAn quanLyBenhAn = new QuanLyBenhAn();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.disPlayMainMenu();
    }
    public static void disPlayMainMenu() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" -------CHUONG TRINH QUAN LY BENH AN------\n" +
                            "1. Them moi\n" +
                            "2. Xoa\n" +
                            "3. Xem danh sach cac benh an\n" +
                            "4. Thoat");
                    int choiceMain = Integer.parseInt(scanner.nextLine());
                    switch (choiceMain) {
                        case 1:
                            themMoiBenhAn();
                            break;
                        case 2:

                            break;
                        case 3:
                            hienThiBenhAn();
                            break;
                        case 4:
                            System.exit(4);
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void themMoiBenhAn() {
        while (true) {
            try {
                while (true) {
                    System.out.println(" ---Chuc nang them moi banh an---\n" +
                            "1. Benh an thuong\n" +
                            "2. Benh an VIP\n" +
                            "3. Quay lai menu chinh\n" +
                            "4. Exit");
                    int choiceAddBenhAn = Integer.parseInt(scanner.nextLine());
                    switch (choiceAddBenhAn) {
                        case 1:
                            themBenhAnThuong();
                            break;
                        case 2:
                            themBenhAnVIP();
                            break;
                        case 3:
                            disPlayMainMenu();
                            break;
                        case 4:
                            break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("You have to enter integer number");
            }
        }
    }
    public static void themBenhAnThuong() {
        List<String> list = new ArrayList<>();
        int stt = 0;
        try {
            System.out.println("Nhap stt: ");
            stt = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to be enter integer number");
        }

        String maBA;
        do {
            System.out.print("Nhap ma benh an: ");
            maBA = scanner.nextLine();
        } while (!MaBARegex.maBA(maBA));
        list.add(maBA);

        String maBN;
        do {
            System.out.print("Nhap ma benh nhan: ");
            maBN = scanner.nextLine();
        } while (!MaBNRegex.maBN(maBN));
        list.add(maBN);

        String ten;
        System.out.print("Nhap ten benh nhan: ");
        ten = scanner.nextLine();
        list.add(ten);

        String ngayNhapVien;
        do {
            System.out.print("Nhap ngay nhap vien: ");
            ngayNhapVien = scanner.nextLine();
        } while (!NgayNhapRaRegex.ngayNhapRa(ngayNhapVien));
        list.add(ngayNhapVien);

        String ngayRaVien;
        do {
            System.out.print("Nhap ngay ra vien: ");
            ngayRaVien = scanner.nextLine();
        } while (!NgayNhapRaRegex.ngayNhapRa(ngayRaVien));
        list.add(ngayRaVien);

        String lyDo;
        System.out.print("Nhap ly do: ");
        lyDo = scanner.nextLine();
        list.add(lyDo);

        double chiPhi = 0;
        try {
            System.out.println("Nhap chi phi: ");
            chiPhi = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to be enter float number");
        }
        String[] benhAnThuongInfor = list.toArray(new String[0]);
        BenhAnThuong benhAnThuong = new BenhAnThuong(benhAnThuongInfor);
        quanLyBenhAn.them(benhAnThuong);
    }
    public static void themBenhAnVIP() {
        List<String> list = new ArrayList<>();
        int stt = 0;
        try {
            System.out.println("Nhap stt: ");
            stt = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("You have to be enter integer number");
        }

        String maBA;
        do {
            System.out.print("Nhap ma benh an: ");
            maBA = scanner.nextLine();
        } while (!MaBARegex.maBA(maBA));
        list.add(maBA);

        String maBN;
        do {
            System.out.print("Nhap ma benh nhan: ");
            maBN = scanner.nextLine();
        } while (!MaBNRegex.maBN(maBN));
        list.add(maBN);

        String ten;
        System.out.print("Nhap ten benh nhan: ");
        ten = scanner.nextLine();
        list.add(ten);

        String ngayNhapVien;
        do {
            System.out.print("Nhap ngay nhap vien: ");
            ngayNhapVien = scanner.nextLine();
        } while (!NgayNhapRaRegex.ngayNhapRa(ngayNhapVien));
        list.add(ngayNhapVien);

        String ngayRaVien;
        do {
            System.out.print("Nhap ngay ra vien: ");
            ngayRaVien = scanner.nextLine();
        } while (!NgayNhapRaRegex.ngayNhapRa(ngayRaVien));
        list.add(ngayRaVien);

        String lyDo;
        System.out.print("Nhap ly do: ");
        lyDo = scanner.nextLine();
        list.add(lyDo);

        String goiVIP;
        do {
            System.out.print("Nhap goi VIP: ");
            goiVIP = scanner.nextLine();
        } while (!GoiVIPRegex.goiVIP(goiVIP));
        list.add(goiVIP);

        String thoiHanVIP;
        do {
            System.out.print("Nhap thoi han VIP: ");
            thoiHanVIP = scanner.nextLine();
        } while (!ThoiHanVIP.thoihanVIP(thoiHanVIP));
        list.add(thoiHanVIP);
        String[] benhAnVIPInfor = list.toArray(new String[0]);
        BenhAnVIP benhAnVIP = new BenhAnVIP(benhAnVIPInfor);
        quanLyBenhAn.them(benhAnVIP);
    }
    public static void hienThiBenhAn() {
        System.out.println("---Benh Nhan List---");
        quanLyBenhAn.hienThi();
    }
}
