package bai3;

import bai1.ThiSinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyTienDien {
    private ArrayList<HoGiaDinh> dsHGD = new ArrayList<>();

    public ArrayList<HoGiaDinh> getDsHGD() {
        return dsHGD;
    }

    public void setDsHGD(ArrayList<HoGiaDinh> dsHGD) {
        this.dsHGD = dsHGD;
    }

    public ArrayList<HoGiaDinh> nhapSoDien() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + 1);
            this.dsHGD.add(new HoGiaDinh().nhapSoDien(new Scanner(System.in)));
        }
        return this.dsHGD;
    }

    @Override
    public String toString() {
        String result = "STT\tTên hộ                        \tSố kWh\tSố tiền phải trả\n";
        for (int i = 0; i < this.dsHGD.size(); i++) {
            result += String.format("%3d\t%s\n", i + 1, this.dsHGD.get(i));
        }
        return result;
    }

    public ArrayList<HoGiaDinh> sortKWH() {
        Collections.sort(this.dsHGD, new Comparator<HoGiaDinh>() {
            @Override
            public int compare(HoGiaDinh o1, HoGiaDinh o2) {
                if (o1.tinhTienDien() > o2.tinhTienDien()) return 1;
                else if (o1.tinhTienDien() < o2.tinhTienDien()) return -1;
                else {
                    o1.getTenHoGD().trim();
                    o2.getTenHoGD().trim();
                    String name1 =
                            o1.getTenHoGD().substring(o1.getTenHoGD().lastIndexOf(" ") + 1, o1.getTenHoGD().length());
                    String name2 =
                            o2.getTenHoGD().substring(o1.getTenHoGD().lastIndexOf(" ") + 1, o2.getTenHoGD().length());
                    return name1.compareToIgnoreCase(name2);
                }
            }
        });
        return this.dsHGD;
    }

    public ArrayList<HoGiaDinh> sortName() {
        Collections.sort(this.dsHGD, new Comparator<HoGiaDinh>() {
            @Override
            public int compare(HoGiaDinh o1, HoGiaDinh o2) {
                o1.getTenHoGD().trim();
                o2.getTenHoGD().trim();
                String name1 =
                        o1.getTenHoGD().substring(o1.getTenHoGD().lastIndexOf(" ") + 1, o1.getTenHoGD().length());
                String name2 =
                        o2.getTenHoGD().substring(o2.getTenHoGD().lastIndexOf(" ") + 1, o2.getTenHoGD().length());
                if (name1.compareToIgnoreCase(name2) < 0) return -1;
                else if (name1.compareToIgnoreCase(name2) > 0) return 1;
                else {
                    if (o1.tinhTienDien() > o2.tinhTienDien()) return 1;
                    else return -1;
                }
            }
        });
        return this.dsHGD;
    }

    public void search(String name) {
        int count = 1;
        boolean flag = true;
        System.out.println("Kết quả tìm kiếm: ");
        System.out.println("STT\tTên hộ                        \tSố kWh\tSố tiền phải trả");
        for (HoGiaDinh giaDinh :
                this.dsHGD) {
            String fullName = giaDinh.getTenHoGD().trim();
            String lastName = fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length());
            if (lastName.equalsIgnoreCase(name)) {
                System.out.printf("%3d\t%s\n", count, giaDinh);
                count++;
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Không có gia đình nào tên là " + name);
        }
    }
}
