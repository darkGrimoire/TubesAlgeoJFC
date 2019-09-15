package MatriksDriver;
import MatriksLib.*;
import java.io.*;

class Driver 
{ 
    public static void main(String args[]) 
    { 
        MATRIKS M1=new MATRIKS(101, 101);
        // M1.SetMaksNeffKolom(10);
        // M1.SetMaksNeffBaris(10);
        // for(int i=1; i<=M1.GetMaksNeffBaris(); i++){
        //     for(int j=1; j<=M1.GetMaksNeffKolom(); j++){
        //         M1.SetNilai(i,j,0);
        //     }
        // }
        // M1.BacaMatriks();
        // System.out.println();
        // M1.TulisMatriks();
        // MATRIKS M2 = new MATRIKS(101,101);
        M1.BacaFileMatriks();
        M1.TulisMatriks();
    } 
} 