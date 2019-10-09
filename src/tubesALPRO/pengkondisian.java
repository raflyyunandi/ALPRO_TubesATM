package tubesALPRO;

import java.util.Scanner;
public class pengkondisian {
    ATM atm = new ATM();
    boolean found;
    int batasInput = 3;
    Scanner sc = new Scanner(System.in);
    
    public void tampilanMenu() {
        found = false;
        System.out.println("===PILIH MENU ===");
        System.out.println("1. Cek Saldo");
        System.out.println("2. Tarik Tunai");
        System.out.println("3. Deposit");
        System.out.println("00. Keluar");
        System.out.println("=================");
        
        while((found == false) && batasInput > 0) {
            System.out.println("");
            System.out.print("PILIH MENU : ");
            int inputMenu = sc.nextInt();
            System.out.println("");

            switch(inputMenu){
            case 1  :
                atm.openFileBaca();
                atm.cekSaldo();
                atm.closeFileBaca();
                found = true;
                break;
            case 2  :
                atm.openFileBaca();
                atm.tarikTunai();
                atm.closeFileBaca();
                atm.closeFileTulis();
                found = true;
                break;
            case 3  :
                atm.openFileBaca();
                atm.deposit();
                atm.closeFileBaca();
                atm.closeFileTulis();
                found = true;
                break;
            case 00  :
                System.out.println("TERIMA KASIH");
                System.out.println("SENANG BISA MEMBANTU ANDA :)");
                System.exit(0);
            default :
                System.out.println("MENU TIDAK ADA");
                batasInput -= 1;
                if(batasInput == 0) {
                    System.out.println("SILAHKAN LOGIN KEMBALI");
                }
            }
        }
    } 
}
