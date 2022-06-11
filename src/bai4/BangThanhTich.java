package bai4;

import bai3.HoGiaDinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BangThanhTich {
    private ArrayList<VDV> dsVDV = new ArrayList<>();

    public ArrayList<VDV> getDsVDV() {
        return dsVDV;
    }

    public void setDsVDV(ArrayList<VDV> dsVDV) {
        this.dsVDV = dsVDV;
    }

    public ArrayList<VDV> nhapThanhTich(Scanner scanner) {
        System.out.print("Nhập số lượng vận động viên: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1);
            this.dsVDV.add(new VDV().nhapThanhTich(scanner));
        }
        return this.dsVDV;
    }

    @Override
    public String toString() {
        System.out.println("STT\tDanh sách vận động viên       \tLần 1\tLần 2\tLần 3\tTổng thành tích");
        String result = "";
        for (int i = 0; i < this.dsVDV.size(); i++) {
            result += String.format("%3d\t%-30s\t%4d\t%4d\t%4d\t\t%d\n", i + 1, this.dsVDV.get(i).getHoTen(),
                    this.dsVDV.get(i).getLan1(), this.dsVDV.get(i).getLan2(), this.dsVDV.get(i).getLan3(),
                    this.dsVDV.get(i).tongThanhTich());
        }
        return result;
    }

    public ArrayList<VDV> sort() {
        Collections.sort(this.dsVDV, new Comparator<VDV>() {
            @Override
            public int compare(VDV o1, VDV o2) {
                if (o1.tongThanhTich() > o2.tongThanhTich()) return 1;
                else if (o1.tongThanhTich() < o2.tongThanhTich()) return -1;
                else {
                    o1.getHoTen().trim();
                    o2.getHoTen().trim();
                    String name1 =
                            o1.getHoTen().substring(o1.getHoTen().lastIndexOf(" ") + 1, o1.getHoTen().length());
                    String name2 =
                            o2.getHoTen().substring(o1.getHoTen().lastIndexOf(" ") + 1, o2.getHoTen().length());
                    return name1.compareTo(name2);
                }
            }
        });
        return this.dsVDV;
    }

    public VDV champion() {
        this.sort();
        return this.dsVDV.get(this.dsVDV.size() - 1);
    }

    public void topThree() {
        this.sort();
        System.out.println("Ba vận động viên có tổng thành tích cao nhất");
        System.out.println("STT\tDanh sách vận động viên       \tLần 1\tLần 2\tLần 3\tTổng thành tích");
        for (int i = this.dsVDV.size() - 3; i < this.dsVDV.size(); i++) {
            System.out.printf("%3d\t%-30s\t%4d\t%4d\t%4d\t\t%d\n", i + 1, this.dsVDV.get(i).getHoTen(),
                    this.dsVDV.get(i).getLan1(), this.dsVDV.get(i).getLan2(), this.dsVDV.get(i).getLan3(),
                    this.dsVDV.get(i).tongThanhTich());
        }
    }

    public ArrayList<VDV> sortName() {
        Collections.sort(this.dsVDV, new Comparator<VDV>() {
            @Override
            public int compare(VDV o1, VDV o2) {
                o1.getHoTen().trim();
                o2.getHoTen().trim();
                String name1 =
                        o1.getHoTen().substring(o1.getHoTen().lastIndexOf(" ") + 1, o1.getHoTen().length());
                String name2 =
                        o2.getHoTen().substring(o2.getHoTen().lastIndexOf(" ") + 1, o2.getHoTen().length());
                if (name1.compareToIgnoreCase(name2) < 0) return -1;
                else if (name1.compareToIgnoreCase(name2) > 0) return 1;
                else {
                    if (o1.tongThanhTich() > o2.tongThanhTich()) return 1;
                    else return -1;
                }
            }
        });
        return this.dsVDV;
    }

    public void search(String name) {
        int count = 1;
        boolean flag = true;
        System.out.println("Kết quả tìm kiếm: ");
        System.out.println("STT\tDanh sách vận động viên       \tLần 1\tLần 2\tLần 3\tTổng thành tích");
        for (VDV vdv :
                this.dsVDV) {
            String fullName = vdv.getHoTen().trim();
            String lastName = fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length());
            if (lastName.contains(name)) {
                System.out.printf("%3d\t%-30s\t%4d\t%4d\t%4d\t\t%d\n", count, vdv.getHoTen(),
                        vdv.getLan1(), vdv.getLan2(), vdv.getLan3(), vdv.tongThanhTich());
                count++;
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Không có vận động viên nào có tên chứa " + name);
        }
    }

    public void searchNameStart(char c) {
        int count = 1;
        boolean flag = true;
        System.out.println("Kết quả tìm kiếm: ");
        System.out.println("STT\tDanh sách vận động viên       \tLần 1\tLần 2\tLần 3\tTổng thành tích");
        for (VDV vdv :
                this.dsVDV) {
            String fullName = vdv.getHoTen().trim();
            String lastName = fullName.substring(fullName.lastIndexOf(" ") + 1, fullName.length());
            if (lastName.charAt(0) == c) {
                System.out.printf("%3d\t%-30s\t%4d\t%4d\t%4d\t\t%d\n", count, vdv.getHoTen(),
                        vdv.getLan1(), vdv.getLan2(), vdv.getLan3(), vdv.tongThanhTich());
                count++;
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Không có vận động viên nào có tên bắt đầu bằng " + c);
        }
    }

    public ArrayList<VDV> sortLengthName() {
        Collections.sort(this.dsVDV, new Comparator<VDV>() {
            @Override
            public int compare(VDV o1, VDV o2) {
                o1.getHoTen().trim();
                o2.getHoTen().trim();
                String name1 =
                        o1.getHoTen().substring(o1.getHoTen().lastIndexOf(" ") + 1, o1.getHoTen().length());
                String name2 =
                        o2.getHoTen().substring(o2.getHoTen().lastIndexOf(" ") + 1, o2.getHoTen().length());
                if (name1.length() > name2.length()) return 1;
                else if (name1.length() < name2.length()) return -1;
                else {
                    return name1.compareTo(name2);
                }
            }
        });
        return this.dsVDV;
    }

    public void dsVDVXepNhi() {
        this.sort();
        int max = this.dsVDV.get(this.dsVDV.size() - 1).tongThanhTich();
        int second = 0;
        int index = 0;
        for (int i = this.dsVDV.size() - 2; i >= 0; i--) {
            if (this.dsVDV.get(i).tongThanhTich() < max) {
                second = this.dsVDV.get(i).tongThanhTich();
                index = i;
                break;
            }
        }
        int count = 1;
        System.out.println("Danh sách vận động viên xếp thứ hai: ");
        System.out.println("STT\tDanh sách vận động viên       \tLần 1\tLần 2\tLần 3\tTổng thành tích");
        while (this.dsVDV.get(index).tongThanhTich() == second) {
            System.out.printf("%3d\t%-30s\t%4d\t%4d\t%4d\t\t%d\n", count, this.dsVDV.get(index).getHoTen(),
                    this.dsVDV.get(index).getLan1(), this.dsVDV.get(index).getLan2(), this.dsVDV.get(index).getLan3(),
                    this.dsVDV.get(index).tongThanhTich());
            index--;
            count++;
            if (index < 0) break;
        }
    }
}
