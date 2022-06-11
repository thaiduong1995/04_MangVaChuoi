package bai3;

import java.util.Scanner;

public class HoGiaDinh {
    private String tenHoGD;
    private int soDien;

    public String getTenHoGD() {
        return tenHoGD;
    }

    public void setTenHoGD(String tenHoGD) {
        this.tenHoGD = tenHoGD;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public HoGiaDinh nhapSoDien(Scanner scanner) {
        System.out.print("Nhập tên chủ hộ: ");
        this.tenHoGD = scanner.nextLine();
        System.out.print("Nhập số điện năng tiêu thụ: ");
        this.soDien = Integer.parseInt(scanner.nextLine());
        return this;
    }

    public long tinhTienDien() {
        if (this.soDien <= 50) {
            return this.soDien * 1678;
        }
        else if (this.soDien <= 100) {
            return 50 * 1678 + (this.soDien - 50) * 1734;
        }
        else if (this.soDien <= 200) {
            return 50 * 1678 + 50 * 1734 + (this.soDien - 10) * 2014;
        }
        else if (this.soDien <= 300) {
            return 50 * 1678 + 50 * 1734 + 100 * 2014 + (this.soDien - 200) *2536;
        }
        else if (this.soDien <= 400) {
            return 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 *2536 + (this.soDien - 300) * 2834;
        }
        else {
            return 50 * 1678 + 50 * 1734 + 100 * 2014 + 100 *2536 + 100 * 2834 + (this.soDien - 400) * 2927;
        }
    }

    @Override
    public String toString() {
        return String.format("%-30s\t%6d\t%,d", this.tenHoGD, this.soDien, this.tinhTienDien());
    }
}
