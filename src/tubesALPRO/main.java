package tubesALPRO;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pin = 123;
        int pinInputLimit;
        
        pengkondisian kondisi = new pengkondisian();
        boolean ulangiTransaksi = true;
        int transaksiLagi;
        
        while(ulangiTransaksi == true) {
        pinInputLimit = 3;
        System.out.println(" == SELAMAT DATANG ==");
        System.out.println("======= LOGIN =======");
        while(pinInputLimit > 0) {
            System.out.print("MASUKKAN PIN : ");
            int inputPin = sc.nextInt();
            if(inputPin == pin) {
                System.out.println("");
                System.out.println("[***LOGIN BERHASIL***]");
                System.out.println("");
                kondisi.tampilanMenu();
                pinInputLimit = 0;
            }
            else {
                System.out.println("[***LOGIN GAGAL***]");
                pinInputLimit -= 1;
                if(pinInputLimit == 0) {
                    System.out.println("[ATM TERBLOKIR]");
                }
            }
        }
        System.out.println("LAKUKAN TRANSAKSI LAIN?");
        System.out.println("1 = YA, 0 = TIDAK");
        System.out.println("=================");
        System.out.println("");
        
            transaksiLagi = sc.nextInt();
            if(transaksiLagi != 0) {
                if(transaksiLagi == 1) {
                    ulangiTransaksi = true;
                } else {
                    ulangiTransaksi = false;
                System.out.println("SALAH INPUT!!!");
                }
            }
            else {
                ulangiTransaksi = false;
                System.out.println("TERIMA KASIH");
                System.out.println("SENANG BISA MEMBANTU ANDA :)");
            }
        }
    }
}
