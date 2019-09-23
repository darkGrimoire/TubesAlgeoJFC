package TubesAlgeoJFC;
import TubesAlgeoJFC.MATRIKS;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

class Driver 
{ 
    public static void main(String args[]) 
    { 
        Scanner input = new Scanner(System.in);
        MATRIKS M1 = new MATRIKS(100,100);
        MATRIKS M2 = new MATRIKS(100,100);
        MATRIKS M3 = new MATRIKS(100,100);
        String msg1, msg2, msg3;
        /* MAIN MENU*/
        while (true){
            msg1 = M1.IsEmpty() ? "Kosong" : "Terisi";
            msg2 = M2.IsEmpty() ? "Kosong" : "Terisi";
            msg3 = M3.IsEmpty() ? "Kosong" : "Terisi";
            System.out.println("\n\n*******************************************************************");
            System.out.println("*             TUGAS BESAR ALGEO JUNDU FRIED CHICKEN               *");
            System.out.println("*******************************************************************");
            System.out.println("                                  +-------------------------------+");
            System.out.println("[1] Baca Matriks                  | Copyrighted and Authored by:  |");
            System.out.println("[2] Tulis Matriks                 |     13518001 Chandrika A.     |");
            System.out.println("[3] Sistem Persamaan Linier       |     13518027 Jundullah        |");
            System.out.println("[4] Determinan                    |     13518125 Faris R. E.      |");
            System.out.println("[5] Matriks Balikan               +_______________________________+");
            System.out.println("[6] Matriks Kofaktor                                               ");
            System.out.printf ("[7] Adjoin                        Status Matriks: M1: %s\n",msg1);
            System.out.printf ("[8] Interpolasi Polinom                           M2: %s\n",msg2);
            System.out.printf ("[9] Keluar                                        M3: %s\n",msg3);
            System.out.print  (">> Menu Pilihan dan Matriks: ");
            int choice1 = input.nextInt();
            if (choice1==9){
                System.exit(0);
            }
            int matriksUsed = input.nextInt();
            if (matriksUsed==1){
                if (choice1==1){
                    System.out.println("\n[1] Baca Matriks dari Input");
                    System.out.println("[2] Baca Matriks dari File");
                    System.out.println(">> Menu Pilihan: ");
                    int choice2 = input.nextInt();
                    if (choice2==1){
                        M1.BacaMatriks();
                    }else if (choice2==2){
                        M1.BacaFileMatriks();
                    }else{
                        System.out.println("ERROR! Kembali ke menu awal.");
                    }
                }
                else if (M1.IsEmpty()){
                    System.out.println("Matriks M1 belum terisi! Mohon lakukan Baca Matriks terlebih dahulu.");
                }else{
                    switch(choice1){
                        case 2:
                            M1.TulisMatriks();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("ERROR! Kembali ke menu awal.");
                            break;
                    }
                }
            }
            else if (matriksUsed==2){
                if (choice1==1){
                    System.out.println("\n[1] Baca Matriks dari Input");
                    System.out.println("[2] Baca Matriks dari File");
                    System.out.println(">> Menu Pilihan: ");
                    int choice2 = input.nextInt();
                    if (choice2==1){
                        M2.BacaMatriks();
                    }else if (choice2==2){
                        M2.BacaFileMatriks();
                    }else{
                        System.out.println("ERROR! Kembali ke menu awal.");
                    }
                }
                else if (M2.IsEmpty()){
                    System.out.println("Matriks M2 belum terisi! Mohon lakukan Baca Matriks terlebih dahulu.");
                }else{
                    switch(choice1){
                        case 2:
                            M2.TulisMatriks();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("ERROR! Kembali ke menu awal.");
                            break;
                    }
                }
            }
            else if (matriksUsed==3){
                if (choice1==1){
                    System.out.println("\n[1] Baca Matriks dari Input");
                    System.out.println("[2] Baca Matriks dari File");
                    System.out.println(">> Menu Pilihan: ");
                    int choice2 = input.nextInt();
                    if (choice2==1){
                        M3.BacaMatriks();
                    }else if (choice2==2){
                        M3.BacaFileMatriks();
                    }else{
                        System.out.println("ERROR! Kembali ke menu awal.");
                    }
                }
                else if (M3.IsEmpty()){
                    System.out.println("Matriks M3 belum terisi! Mohon lakukan Baca Matriks terlebih dahulu.");
                }else{
                    switch(choice1){
                        case 2:
                            M3.TulisMatriks();
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            break;
                        default:
                            System.out.println("ERROR! Kembali ke menu awal.");
                            break;
                    }
                }
            }
        }
        // M.BacaFileMatriks();
        // M.TulisMatriks();

        // MATRIKS M=new MATRIKS(101, 101);
        //  M.SetMaksNeffKolom(5);
        //  M.SetMaksNeffBaris(2);
        //  for(int i=1; 5<=M1.GetMaksNeffBaris(); i++){
        //      for(int j=1; j<=M1.GetMaksNeffKolom(); j++){
        //          M1.SetNilai(i,j,3*i+2*j);
        //      }
        //  }

        //  M.SetNilai(1,1,1);
        //  M.SetNilai(1,2,1);
        //  M.SetNilai(1,3,2);
        //  M.SetNilai(1,4,2);
        //  M.SetNilai(1,5,5);
        //  M.SetNilai(2,1,0);
        //  M.SetNilai(2,2,1);
        //  M.SetNilai(2,3,0);
        //  M.SetNilai(2,4,2);
        //  M.SetNilai(2,5,1);
        //  M.SetNilai(3,1,3);
        //  M.SetNilai(3,2,9);
        //  M.SetNilai(3,3,4);
        //  M.SetNilai(3,4,3);
        //  M.SetNilai(3,5,1);
        // M.TulisMatriks();
        // System.out.println();
        // M.MetodeEliminasiGauss();
        // M.TulisMatriks();
        // System.out.println();
        // M.TulisHasilGauss();
        // M.MetodeEliminasiJordan();
        // M.TulisMatriks();
        // System.out.println();
        // M.TulisHasilJordan();
        // System.out.println();
        // // Interpolasi(M);
    } 


    //Jundu
    //begin
    public static void Interpolasi(MATRIKS M){
        MATRIKS SPL = new MATRIKS(101,101);
        SPL.SetMaksNeffBaris(M.GetMaksNeffBaris());
        SPL.SetMaksNeffKolom(M.GetMaksNeffBaris()+1);
        float temp;

        for (int i = 1; i <= SPL.GetMaksNeffBaris(); i++) {
            temp=1;
            for (int j = 1; j < SPL.GetMaksNeffKolom(); j++) {
                SPL.SetNilai(i, j, temp);
                temp*= M.GetNilai(i, 1);
            }
            SPL.SetNilai(i, SPL.GetMaksNeffKolom(), M.GetNilai(i, 2));
        }

        SPL.MetodeEliminasiGauss();
        SPL.MetodeEliminasiJordan();

        System.out.printf("y = ");
        System.out.printf("%.1f ",SPL.GetNilai(1, SPL.GetMaksNeffKolom()));
        for (int i = 2; i <= SPL.GetMaksNeffBaris(); i++) {
            if(0!=SPL.GetNilai(i, SPL.GetMaksNeffKolom())){
                if(SPL.GetNilai(i, SPL.GetMaksNeffKolom())>=0){
                    System.out.printf("+");    
                }
                System.out.printf("%.1fx^%d ",SPL.GetNilai(i, SPL.GetMaksNeffKolom()),i-1);
            }
        }
        System.out.printf("\n");
    }
    //end
    //Jundu

    
} 