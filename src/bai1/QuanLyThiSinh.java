package bai1;

import java.util.*;

public class QuanLyThiSinh {
    private ArrayList<ThiSinh> dsThiSinh = new ArrayList<>();

    public ArrayList<ThiSinh> getDsThiSinh() {
        return dsThiSinh;
    }

    public void setDsThiSinh(ArrayList<ThiSinh> dsThiSinh) {
        this.dsThiSinh = dsThiSinh;
    }

    public ArrayList<ThiSinh> nhapDiem(Scanner scanner) {
        System.out.print("Nhập số lượng thí sinh: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1);
            this.dsThiSinh.add(new ThiSinh().nhapDiem(scanner));
        }
        return this.dsThiSinh;
    }

    @Override
    public String toString() {
        System.out.println("STT\tDanh sách thí sinh            \tTổng điểm");
        String result = "";
        for (int i = 0; i < this.dsThiSinh.size(); i++) {
            result += String.format("%3d\t%-30s\t%.2f\n", i + 1, this.dsThiSinh.get(i).getHoTen(),
                    this.dsThiSinh.get(i).tongDiem());
        }
        return result;
    }

    public ArrayList<ThiSinh> sort() {
        Collections.sort(this.dsThiSinh, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh o1, ThiSinh o2) {
                if (o1.tongDiem() > o2.tongDiem()) return 1;
                else if (o1.tongDiem() < o2.tongDiem()) return -1;
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
        return this.dsThiSinh;
    }

    public void topFive() {
        this.sort();
        System.out.println("Năm thí sinh có tổng điểm cao nhất");
        System.out.println("STT\tDanh sách thí sinh            \tTổng điểm");
        for (int i = this.dsThiSinh.size() - 5; i < this.dsThiSinh.size(); i++) {
            System.out.printf("%3d\t%-30s\t%.2f\n", i + 1, this.dsThiSinh.get(i).getHoTen(),
                    this.dsThiSinh.get(i).tongDiem());
        }
    }
}
