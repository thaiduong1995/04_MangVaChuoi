package bai3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opt;
        Scanner scanner = new Scanner(System.in);
        QuanLyTienDien ds = new QuanLyTienDien();
        ds.nhapSoDien();
        do {
            System.out.println("Chương trình:");
            System.out.println("1. Danh sách điện năng tiêu thụ của mỗi hộ gia đình");
            System.out.println("2. Ba hộ tiêu thụ điện năng nhiều nhất");
            System.out.println("3. Tìm kiếm hộ gia đình theo tên");
            System.out.println("4. Sắp xếp danh sách theo bảng chữ cái");
            System.out.println("5. Sắp xếp danh sách theo mức tiêu thụ điện năng");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print(ds);
                    break;
                case 2:
                    ds.sortKWH();
                    int count = 1;
                    System.out.println("Ba hộ tiêu thụ điện năng nhiều nhất");
                    System.out.println("STT\tTên hộ                        \tSố kWh\tSố tiền phải trả");
                    for (int i = ds.getDsHGD().size() - 3; i < ds.getDsHGD().size(); i++) {
                        System.out.printf("%3d\t%s\n", count, ds.getDsHGD().get(i));
                    }
                    break;
                case 3:
                    System.out.print("Nhập tên hộ gia đình cần tìm: ");
                    String name = scanner.nextLine();
                    ds.search(name);
                    break;
                case 4:
                    ds.sortName();
                    System.out.println(ds);
                    break;
                case 5:
                    ds.sortKWH();
                    System.out.println(ds);
                    break;
            }
        } while (opt != 0);
    }
}
