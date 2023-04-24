package Lab1Buoi2;

import java.text.NumberFormat;
import java.util.Scanner;

public class Account {
private long sotk;
private String tentk;
private double sotien;
private String trangthai;

Scanner sc = new Scanner(System.in);

public Account(){
    this.sotk = 999999;
    this.tentk = null;
    this.sotien = 50;
}

public Account(long sotk, String tentk, double sotien ){
super();
this.sotk = sotk;
this.tentk = tentk;
this.sotien = sotien;

}
public long getSotk() {
    return sotk;
}
public void setSotk(long sotk) {
   if(sotk > 0 & sotk !=999999){
    this.sotk = sotk;
   }
   else{
    this.sotk = 999999;
    System.out.println("So tai khoan khong hop le");
   }
}
public String getTentk() {
    return tentk;
}
public void setTentk(String tentk) {
   if(tentk != null){
    this.tentk = tentk;
   }
   else{
    this.tentk = null;
    System.out.println("Ten tai khoang khong hop le");
   }
}
public double getSotien() {
    return sotien;
}
public void setSotien(double sotien) {
   if(sotien >= 50){
    this.sotien = sotien;
   }
   else{
    this.sotien = 50;
    System.out.println("So tien khong hop le");
   }
}
public String getTrangthai() {
    return trangthai;
}
public void setTrangthai(String trangthai) {
    this.trangthai = trangthai;
}
@Override
public String toString() {
    return "Account [sotk=" + sotk + ", tentk=" + tentk + ", sotien=" + sotien + ", trangthai=" + trangthai + "]";
}

public Account(long sotk, String tentk){
this.sotien = 50;
}
public double napTien() {
    double nap;
    System.out.print("Nhap so tien ban can nap: ");
    nap = sc.nextDouble();
    if (nap >= 0) {
        sotien = nap + sotien;
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(nap);
        System.out.println("ban vua nap " + str1 + " vao tai khoan.");
    } else {
        System.out.println("So tien nap vao khong hop le!");
    }
    return nap;
}
public double rutTien() {
    double phi = 5;
    double rut;
    System.out.print("Nhap so tien ban can rut: ");
    rut = sc.nextDouble();
    
    if (rut <= (sotien - phi)) {
        sotien = sotien- (rut + phi);
        NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
        String str1 = currencyEN.format(rut);
        System.out.println("Ban vua rut " + str1 + "Đ tu tai khoan. Phi là $5.");
    } else {
        System.out.println("So tien muon rut khong hop le!");
        return rutTien();
    }
    return rut;
}
public double daoHan() {
    double laiSuat = 0.035;
    sotien = sotien + sotien * laiSuat;
    NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
    String str1 = currencyEN.format(sotien);
    System.out.println("Ban vua duoc " + str1 + " tu dao han 1 thang");
    return sotien;
}
void inTK() {
    NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
    String str1 = currencyEN.format(sotien);
    System.out.printf("%-10d %-20s %-20s \n", sotk, tentk, str1);
}
class Main {
    static Scanner sc = new Scanner(System.in);
    static void nhapTK(Account tk) {
        System.out.println("Nhap so tai khoan: ");
        tk.setSotk(sc.nextInt());
        sc.nextLine();
        System.out.println("Nhap ten tai khoan: ");
        tk.setTentk(sc.nextLine());
        tk.setSotien(50);
    }
    public static void main(String[] args) {
        Account a[] = null;
        int k, b, n = 0;
        long s, d, c, f;
        boolean flag = true;
        do {
            System.out.println("Chon chuc nang: ");
            System.out.println("1. Them tai khoan\n" + "2. In thong tin\n " 
                 + "3.Nap tien\n" + "4.Rut tien\n"
                    + "5.Dao han\n" + "6.Chuyen khoan\n" + "So khac de thoat");
            b = sc.nextInt();
            switch (b) {
                case 1:
                    System.out.println("Nhap so luong khach hang ban muon nhap: ");
                    n = sc.nextInt();
                    a = new Account[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("Khaach hang so: " + (i+1));
                        a[i] = new Account();
                        nhapTK(a[i]);
                    }
                    break;
                case 2:
                    System.out.printf("%-10s %-20s %-20s\n", "So TK", "Ten TK", "So tien trong TK");
                    for (int i = 0; i < n; i++) {
                        a[i].inTK();
                    }
                    break;
                case 3:
                    System.out.println("Nhap so tai khoan khach hang can nap tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSotk();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].napTien();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Nhap so tai khoan khach hang can rut tien: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSotk();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].rutTien();
                        }
                    }
                    break;
                case 5:
                    System.out.println("Nhap so tai khoan khach hang can dao han: ");
                    s = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSotk();
                        if (s == d) {
                            System.out.println("Ban chon tai khoan: " + d);
                            a[i].daoHan();
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                case 6:
                    double chuyen,
                            nhan,
                            tienChuyen;
                    System.out.print("Nhap so tai khoan khach hang chuyen tien:: ");
                    s = sc.nextLong();
                    System.out.print("Nhap so tai khoan khach hang nhan tien: ");
                    c = sc.nextLong();
                    for (int i = 0; i < n; i++) {
                        d = a[i].getSotk();
                        if (s == d) {
                            chuyen = a[i].getSotien();
                            for (int j = 0; j < n; j++) {
                                f = a[j].getSotk();
                                if (c == f) {
                                    nhan = a[j].getSotien();
                                    System.out.println("Nhap so tien can chuyen");
                                    tienChuyen = sc.nextDouble();
                                    if (tienChuyen <= chuyen) {
                                        chuyen = chuyen - tienChuyen;
                                        nhan = nhan + tienChuyen;
                                        a[i].setSotien(chuyen);
                                        a[j].setSotien(nhan);
                                        System.out.println("Tai khoan so" + d + " vua chuyen: $" + tienChuyen);
                                        System.out.println("Tai khoan so " + f + " vua nhan: $" + tienChuyen);
                                    } else {
                                        System.out.println("So tien nhap khong hop le!");
                                    }
                                } else {
                                    System.out.println("");
                                }
                            }
                        } else {
                            System.out.println("");
                        }
                    }
                    break;
                default:
                    System.out.println("Bye!!");
                    flag = false;
                    break;
            }
        } while (flag);
    }
}
}
