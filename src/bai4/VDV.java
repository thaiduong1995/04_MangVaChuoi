package bai4;

import java.util.Scanner;

public class VDV {
    private String hoTen;
    private int lan1;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    private int lan2;
    private int lan3;

    public int getLan1() {
        return lan1;
    }

    public void setLan1(int lan1) {
        this.lan1 = lan1;
    }

    public int getLan2() {
        return lan2;
    }

    public void setLan2(int lan2) {
        this.lan2 = lan2;
    }

    public int getLan3() {
        return lan3;
    }

    public void setLan3(int lan3) {
        this.lan3 = lan3;
    }

    public VDV nhapThanhTich(Scanner scanner) {
        System.out.print("Nhập họ tên: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhập thành tích lần 1: ");
        this.lan1 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập thành tích lần 2: ");
        this.lan2 = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập thành tích lần 3: ");
        this.lan3 = Integer.parseInt(scanner.nextLine());
        return this;
    }

    public int tongThanhTich() {
        return this.lan1 + this.lan2 + this.lan3;
    }

    @Override
    public String toString() {
        return String.format("Họ tên: %s\nThành tích:\nLần 1\tLần 2\tLần 3\tTổng thành tích\n", this.hoTen) +
        String.format("%4d\t%4d\t%4d\t%d", this.lan1, this.lan2, this.lan3, this.tongThanhTich());
    }
}
