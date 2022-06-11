package bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyThiSinh ds = new QuanLyThiSinh();
        ds.nhapDiem(new Scanner(System.in));
        System.out.println(ds);
        ds.sort();
        System.out.println(ds);
        ds.topFive();
    }
}
