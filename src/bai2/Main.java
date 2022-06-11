package bai2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng từ tiếng anh: ");
        int n = Integer.parseInt(scanner.nextLine());
        String[] strEnglish = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập từ thứ " + (i + 1) + " : ");
            strEnglish[i] = scanner.nextLine();
        }
        System.out.println("Các từ vừa nhập là: " + Arrays.toString(strEnglish));
        System.out.print("Nhập từ cần tìm: ");
        String str = scanner.nextLine();
        boolean flag = false;
        for (String s :
                strEnglish) {
            if (str.equals(s)) {
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println(str + " có trong danh sách");
        } else {
            System.out.println(str + " không có trong danh sách");
        }
        Arrays.sort(strEnglish);
        System.out.println("Danh sách sau khi sắp xếp: " + Arrays.toString(strEnglish));
    }
}
