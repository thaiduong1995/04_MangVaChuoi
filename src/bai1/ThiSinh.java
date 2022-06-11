package bai1;

import java.util.Scanner;

public class ThiSinh {
    private String hoTen;
    private float toan;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    private float van;
    private float anh;

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getVan() {
        return van;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public float getAnh() {
        return anh;
    }

    public void setAnh(float anh) {
        this.anh = anh;
    }

    public ThiSinh nhapDiem(Scanner scanner) {
        System.out.print("Nhập họ tên: ");
        this.hoTen = scanner.nextLine();
        System.out.print("Nhập điểm toán: ");
        this.toan = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập điểm văn: ");
        this.van = Float.parseFloat(scanner.nextLine());
        System.out.print("Nhập điểm tiếng anh: ");
        this.anh = Float.parseFloat(scanner.nextLine());
        return this;
    }

    public float tongDiem() {
        return this.toan + this.van + 2 * this.anh;
    }
}
