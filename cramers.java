import java.util.Scanner.*;
import java.util.*;
public class cramersrule
{

double arr[][], sol[];
int N;

    public void input()
    {
        Scanner s=new Scanner(System.in);
        System.out.println("Masukkan ukuran matriks: ");
        // N ukuran baris matriks
        N=s.nextInt();
        // arr matriksnya ukuran nxn
        arr = new double[N][];
        for(int i=1; i<=N; i++){
            arr[i]=new double[N];
        }

        // baca isi matriks
        sol = new double[N];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N+1; j++)
            {
                double k = s.nextDouble();
                // k adalah isi matriks
                if(j==N+1) sol[i] = k;
                else arr[i][j]=k;
            }
        }

    }



    public double Determinan (double arr[][]){
        double ratio,det;
        double temp[][] = new double [GetMaksNeffBaris()+1][GetMaksNeffKolom()+1];

        /* ALGORITMA */
        if(GetMaksNeffKolom() == 1) return arr[1][1];
        if(GetMaksNeffKolom() == 2){
            det = arr[1][1]*arr[2][2] - arr[1][2]*arr[2][1]
        }else{ //Mengisi matriks temp bertipe real
            for (int i=1; i<=GetMaksNeffBaris(); i++)
            {
                for (int j=1; j<=GetMaksNeffKolom(); j++)
                {
                    temp[i][j] = arr[i][j];
                }
            }

            // Membentuk matriks segitiga atas
            for (int i = 1; i <= GetMaksNeffBaris(); i++)
            {
                for (int j = 1; j <= GetMaksNeffKolom(); j++)
                {
                    if (j > i)
                    {
                        ratio = temp[j][i] / temp[i][i];
                        for (int k = 1; k <= GetMaksNeffBaris(); k++)
                        {
                            temp[j][k] -= ratio * temp[i][k];
                        }
                    }
                }
            }
            // Determinan didapatkan dari perkalian diagonalnya
            det = 1;
            for (int i = 1; i <= GetMaksNeffBaris(); i++) det *= temp[i][i];

            if (det == 0) return 0;
            else return det;
        }
}

    public double[] cramers(double arr[][],double sol[])
    {
        double cari[][] = new double[N][N];
        double ans[] = new double[N];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    if(k == i) cari[j][k] = sol[j];
                    else cari[j][k] = arr[j][k];      
                }
            }
            ans[i]=Determinan(cari)/Determinan(A);
        }
        for(int i=1; i<=N; i++) System.out.println(ans[i]);
        return x;
    }


    public static void main(String args[]){
        cramersrule d = new cramersrule();
        d.input();
        d.cramers(d.arr,d.sol);
        // buat kasus print
        // kalo determinan arr nya = 0 berarti gada solusi penyelesaian
        // sisanya tulis x1= , x2= ,dll
   }
}
//Caca
    //Begin
    // public double Determinan(){
    //     double ratio,det;
    //     double temp[][] = new double [this.GetMaksNeffBaris()+1][this.GetMaksNeffKolom()+1];

    //     /* ALGORITMA */
    //     if(this.GetMaksNeffKolom() == 1) return this.GetNilai(1,1);
    //     if(this.GetMaksNeffKolom() == 2){
    //         det = this.GetNilai(1,1)*this.GetNilai(2,2) - this.GetNilai(1,2)*this.GetNilai(2,1);
    //     }else{ //Mengisi matriks temp bertipe real
    //         for (int i=1; i<=GetMaksNeffBaris(); i++)
    //         {
    //             for (int j=1; j<=GetMaksNeffKolom(); j++)
    //             {
    //                 temp[i][j] = this.GetNilai(i,j);
    //             }
    //         }

    //         // Membentuk matriks segitiga atas
    //         for (int i = 1; i <= this.GetMaksNeffBaris(); i++)
    //         {
    //             for (int j = 1; j <= this.GetMaksNeffKolom(); j++)
    //             {
    //                 if (j > i)
    //                 {
    //                     ratio = temp[j][i] / temp[i][i];
    //                     for (int k = 1; k <= this.GetMaksNeffBaris(); k++)
    //                     {
    //                         temp[j][k] -= ratio * temp[i][k];
    //                     }
    //                 }
    //             }
    //         }
    //         // Determinan didapatkan dari perkalian diagonalnya
    //         det = 1;
    //         for (int i = 1; i <= this.GetMaksNeffBaris(); i++) det *= temp[i][i];

    //         if (det == 0) return 0;
    //         else return det;
    //     }
    // }

    // public double[] cramers()
    // {
    //     int N = this.GetMaksNeffKolom()-1; //Ukuran Matriks Koefisien
    //     MATRIKS mCari = new MATRIKS(N,N);
    //     MATRIKS mKoef = new MATRIKS(N,N);
    //     System.out.println(mKoef.GetMaksNeffKolom());
    //     double ans[] = new double[N+1];
    //     for(int i=1; i<=N; i++){
    //         for(int j=1; j<=N; j++){
    //             for(int k=1; k<=N; k++){
    //                 mKoef.GetNilai(j,k) = this.GetNilai(j,k);
    //                 if(k == i) mCari.GetNilai(j,k) = this.GetNilai(j,this.GetMaksNeffKolom());
    //                 else mCari.GetNilai(j,k) = this.GetNilai(j,k);      
    //             }
    //         }
    //         ans[i]=mCari.Determinan()/mKoef.Determinan();
    //     }
    //     for(int i=1; i<=N; i++) System.out.println(ans[i]);
    //     return ans;
    // }
    //End
    //Caca