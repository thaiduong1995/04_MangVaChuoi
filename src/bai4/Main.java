package bai4;

import bai3.QuanLyTienDien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opt;
        Scanner scanner = new Scanner(System.in);
        BangThanhTich result = new BangThanhTich();
        result.nhapThanhTich(new Scanner(System.in));
        do {
            System.out.println("Chương trình:");
            System.out.println("1. Bảng thành tích của các vận động viên");
            System.out.println("2. Vận động viên có thành tích cao nhất");
            System.out.println("3. Ba vận động viên có thành tích cao nhất");
            System.out.println("4. Bảng thành tích của các vận động viên sắp xếp danh sách theo bảng chữ cái");
            System.out.println("5. Tìm kiếm vận động viên theo chữ cái bắt đâu");
            System.out.println("6. Tìm kiếm vận động viên theo vần chứa trong tên");
            System.out.println("7. Bảng thành tích của các vận động viên sắp xếp danh sách theo độ dài tên");
            System.out.println("8. Danh sách vận động viên có thành tích cao thứ hai");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            opt = Integer.parseInt(scanner.nextLine());
            switch (opt) {
                case 1:
                    System.out.print(result);
                    break;
                case 2:
                    System.out.println(result.champion());
                    break;
                case 3:
                    result.topThree();
                    break;
                case 4:
                    result.sortName();
                    System.out.print(result);
                    break;
                case 5:
                    System.out.print("Nhập từ cần tìm: ");
                    String c = scanner.nextLine();
                    result.searchNameStart(c.charAt(0));
                    break;
                case 6:
                    System.out.print("Nhập từ cần tìm: ");
                    String name = scanner.nextLine();
                    result.search(name);
                    break;
                case 7:
                    result.sortLengthName();
                    System.out.println(result);
                    break;
                case 8:
                    result.dsVDVXepNhi();
                    break;
            }
        } while (opt != 0);
    }
}
