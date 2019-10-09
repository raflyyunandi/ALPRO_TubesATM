package tubesALPRO;

import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.NumberFormatException;

public class ATM {
    Scanner sc = new Scanner(System.in);
    BufferedInputStream bis = null;
    PrintWriter pw = null;
    
    char ch;
    String isiRekeningTxt, konversiString;
    int data, konversiInt, inputMenu, transaksi;
    
    public void cekSaldo() {
        try {
            data = bis.read();
            ch = 0;
            System.out.print("SALDO ANDA SEKARANG : Rp. ");
            while(data != -1) {
                ch = (char) data;
                System.out.print(ch);
                data = bis.read();
            }
            System.out.println("");
        } catch(FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    
    public void tarikTunai() {
        try {
            data = bis.read();
            ch = 0;
            isiRekeningTxt = "";
            while(data != -1) {
                ch = (char) data;
                isiRekeningTxt += ch;
                data = bis.read();
            }
            konversiInt = Integer.parseInt(isiRekeningTxt);
            System.out.println("SALDO ANDA : Rp. "+ isiRekeningTxt);
            
            System.out.print("MASUKKAN JUMLAH PENARIKAN : ");
            inputMenu = sc.nextInt();
            transaksi = konversiInt - inputMenu;
            konversiString = Integer.toString(transaksi);
            openFileTulis();
            pw.print(konversiString);
            
            System.out.println("SISA SALDO ANDA : Rp. "+ transaksi);
            System.out.println("");
        } catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch(NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        }
    }
    
    public void deposit() {
        try {
            data = bis.read();
            ch = 0;
            isiRekeningTxt = "";
            while(data != -1) {
                ch = (char) data;
                isiRekeningTxt += ch;
                data = bis.read();
            }
            konversiInt = Integer.parseInt(isiRekeningTxt);
            System.out.println("SALDO TERAKHIR ANDA : Rp. "+ isiRekeningTxt);
            
            System.out.print("MASUKKAN JUMLAH TABUNGAN : ");
            inputMenu = sc.nextInt();
            transaksi = konversiInt+inputMenu;
            konversiString = Integer.toString(transaksi);
            
            openFileTulis();
            
            pw.print(konversiString);
            System.out.println("");
            System.out.println("SALDO ANDA SEKARANG : Rp. "+ transaksi);
            System.out.println("");
            
        } catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        } catch(NumberFormatException nfe) {
            System.err.println(nfe.getMessage());
        }
    }
    
    public void openFileBaca() {
        try {
            bis = new BufferedInputStream(new FileInputStream("rekening.txt"));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void openFileTulis() {
        try {
            pw = new PrintWriter("rekening.txt");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
    
    public void closeFileBaca() {
        try {
            if (bis != null) {
                bis.close();
            }
        } catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
    }
    
    public void closeFileTulis() {
        if (pw != null) {
            pw.close();
        }
    }
    
}
