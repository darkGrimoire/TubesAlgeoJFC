package TubesAlgeoJFC;
import TubesAlgeoJFC.MATRIKS;
import java.io.*;

class Driver 
{ 
    public static void main(String args[]) 
    { 
        MATRIKS M1=new MATRIKS(101, 101);
         M1.SetMaksNeffKolom(4);
         M1.SetMaksNeffBaris(2);

         M1.SetNilai(2,1,2);
         M1.SetNilai(2,2,3);
         M1.SetNilai(2,3,0);
         M1.SetNilai(2,4,2);
         M1.SetNilai(2,5,1);
         M1.SetNilai(1,1,1);
         M1.SetNilai(1,2,1);
         M1.SetNilai(1,3,2);
         M1.SetNilai(1,4,1);
         M1.SetNilai(1,5,5);
         M1.SetNilai(3,1,1);
         M1.SetNilai(3,2,2);
         M1.SetNilai(3,3,4);
         M1.SetNilai(3,4,3);
         M1.SetNilai(3,5,1);
        //  for(int i=1; 5<=M1.GetMaksNeffBaris(); i++){
        //      for(int j=1; j<=M1.GetMaksNeffKolom(); j++){
        //          M1.SetNilai(i,j,3*i+2*j);
        //      }
        //  }
        // M1.BacaMatriks();
        // System.out.println();
        // M1.TulisMatriks();
        // MATRIKS M2 = new MATRIKS(101,101);
        M1.TulisMatriks();
        System.out.println();

        M1.MetodeEliminasiGauss();
        M1.TulisMatriks();
        //M1.TulisHasilGauss();
        System.out.println();

        M1.MetodeEliminasiJordan();
        M1.TulisMatriks();
        M1.TulisHasilJordan();
        //System.out.println();
    } 
} 