package TubesAlgeoJFC;
import TubesAlgeoJFC.MATRIKS;
import java.io.*;

class Driver 
{ 
    public static void main(String args[]) 
    { 
        MATRIKS M=new MATRIKS(101, 101);
         M.SetMaksNeffKolom(5);
         M.SetMaksNeffBaris(2);

         M.SetNilai(1,1,1);
         M.SetNilai(1,2,1);
         M.SetNilai(1,3,2);
         M.SetNilai(1,4,2);
         M.SetNilai(1,5,5);
         M.SetNilai(2,1,0);
         M.SetNilai(2,2,1);
         M.SetNilai(2,3,0);
         M.SetNilai(2,4,2);
         M.SetNilai(2,5,1);
         M.SetNilai(3,1,3);
         M.SetNilai(3,2,9);
         M.SetNilai(3,3,4);
         M.SetNilai(3,4,3);
         M.SetNilai(3,5,1);
        //  for(int i=1; 5<=M1.GetMaksNeffBaris(); i++){
        //      for(int j=1; j<=M1.GetMaksNeffKolom(); j++){
        //          M1.SetNilai(i,j,3*i+2*j);
        //      }
        //  }
        // M1.BacaMatriks();
        System.out.println();
        // M1.TulisMatriks();
        // MATRIKS M2 = new MATRIKS(101,101);
        M.TulisMatriks();
        System.out.println();
        M.MetodeEliminasiGauss();
        M.TulisMatriks();
        System.out.println();
        M.TulisHasilGauss();
        M.MetodeEliminasiJordan();
        M.TulisMatriks();
        System.out.println();
        M.TulisHasilJordan();
        System.out.println();
        // Interpolasi(M);
    } 

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
} 