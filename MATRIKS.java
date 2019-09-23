package TubesAlgeoJFC;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class MATRIKS 
{ 
    double isi[][]; // 1 - 100
    int maksNeffKolom;
    int maksNeffBaris;

    //konstruktor

    public MATRIKS(int maksBaris, int maksKolom){
        this.maksNeffBaris = 0;
        this.maksNeffKolom = 0;
        this.isi = new double[maksBaris+1][maksKolom+1];
    }

    // getter
    public int GetMaksNeffKolom(){
        return this.maksNeffKolom;
    }
    public int GetMaksNeffBaris(){
        return this.maksNeffBaris;
    }
    public double GetNilai(int baris,int kolom){
        return this.isi[baris][kolom];
    }

    //setter
    public void SetMaksNeffKolom(int kolomBaru){
        this.maksNeffKolom = kolomBaru;
    }
    public void SetMaksNeffBaris(int barisBaru){
        this.maksNeffBaris = barisBaru;
    }
    public void SetNilai(int baris,int kolom,double nilaiBaru){
        this.isi[baris][kolom] = nilaiBaru;
    }

    //is
    public boolean IsEmpty(){
        return ((this.GetMaksNeffBaris()==0) && (this.GetMaksNeffKolom()==0));
    }

    //debug purpoos
    public void TulisMatriks(){
        for (int i=1;i<=this.GetMaksNeffBaris();i++){
            System.out.printf("Arr[%3d]: |",i);
            for (int j=1;j<=this.GetMaksNeffKolom();j++){
                System.out.printf("  %8.2f",this.GetNilai(i,j));
            }
            System.out.println("|");
        }
    }
    public void BacaFileMatriks(){
        int i=1;
        Scanner input = new Scanner(System.in);
        System.out.print("Nama File: ");
        String namaFile = input.nextLine();
        if (Files.notExists(Paths.get(namaFile))){
            System.out.println("Filenya gaada anjing");
        }else{
            try {
                Scanner scanner = new Scanner(new File(namaFile));
                while (scanner.hasNextLine()) {
                    String st = scanner.nextLine();
                    // System.out.println(st);
                    String[] nums = st.trim().split(" ");
                    // System.out.println(nums.length);
                    for (int j=0;j<nums.length;j++){
                        // System.out.printf("%s|%d|%d\n",nums[j],i,j);
                        // System.out.println(j);
                        this.SetNilai(i,j+1,Double.parseDouble(nums[j]));
                    }
                    i++;
                    this.SetMaksNeffKolom(nums.length);
                }
                this.SetMaksNeffBaris(i-1);
                scanner.close();
            } 
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void BacaMatriks(){
        Scanner input = new Scanner(System.in);
        System.out.print("Jumlah Baris: ");
        int b = input.nextInt();
        System.out.print("Jumlah Kolom: ");
        int k = input.nextInt();
        this.SetMaksNeffBaris(b);
        this.SetMaksNeffKolom(k);
        for (int i=1;i<=this.GetMaksNeffBaris();i++){
            for (int j=1;j<=this.GetMaksNeffKolom();j++){
                this.SetNilai(i,j,input.nextDouble());
            }
        }
    }

    //Caca
    //Begin
    // public double Determinan(){
    //     double ratio,det;
    //     // double temp[][] = new double [GetMaksNeffBaris()+1][GetMaksNeffKolom()+1];

    //     /* ALGORITMA */
    //     // if(GetMaksNeffKolom() == 1) return arr[1][1];
    //     // if(GetMaksNeffKolom() == 2){
    //     //     det = arr[1][1]*arr[2][2] - arr[1][2]*arr[2][1]
    //     // }else{ //Mengisi matriks temp bertipe real
    //     //     for (int i=1; i<=GetMaksNeffBaris(); i++)
    //     //     {
    //     //         for (int j=1; j<=GetMaksNeffKolom(); j++)
    //     //         {
    //     //             temp[i][j] = arr[i][j];
    //     //         }
    //     //     }

    //         // Membentuk matriks segitiga atas
    //         for (int i = 1; i <= this.GetMaksNeffBaris(); i++)
    //         {
    //             for (int j = 1; j <= this.GetMaksNeffKolom(); j++)
    //             {
    //                 if (j > i)
    //                 {
    //                     // ratio = temp[j][i] / temp[i][i];
    //                     ratio = this.GetNilai(j, i) / this.GetNilai(i, i);
    //                     for (int k = 1; k <= this.GetMaksNeffBaris(); k++)
    //                     {
    //                         // temp[j][k] -= ratio * temp[i][k];
    //                         this.GetNilai(j, k) -= ratio * this.GetNilai(i, k);
    //                     }
    //                 }
    //             }
    //         }
    //         // Determinan didapatkan dari perkalian diagonalnya
    //         det = 1;
    //         // for (int i = 1; i <= this.GetMaksNeffBaris(); i++) det *= temp[i][i];
    //         for (int i = 1; i <= this.GetMaksNeffBaris(); i++) det *= this.GetNilai(i,i);

    //         if (det == 0) return 0;
    //         else return det;
    //     }

    // public double[] cramers(double arr[][],double sol[])
    // {
    //     double cari[][] = new double[N][N];
    //     double ans[] = new double[N];
    //     for(int i=1; i<=N; i++){
    //         for(int j=1; j<=N; j++){
    //             for(int k=1; k<=N; k++){
    //                 if(k == i) cari[j][k] = sol[j];
    //                 else cari[j][k] = arr[j][k];      
    //             }
    //         }
    //         ans[i]=Determinan(cari)/Determinan(A);
    //     }
    //     for(int i=1; i<=N; i++) System.out.println(ans[i]);
    //     return x;
    // }
    //End
    //Caca

    //Jundu
    //Begin
    public void MetodeEliminasiGauss() {
        /*
        I.S. sembarang Augmented Matriks
        F.S. Augmented Matriks Echelon form
        */
        /* PENGONDISIAN AWAL UNTUK MATRIKS TERTENTU */
        for (int i=1;i<=this.GetMaksNeffBaris();i++){
                int counterBaris = 1;
                while (this.GetNilai(i,i)==0 && counterBaris<=this.GetMaksNeffBaris())
                {    
                    if(counterBaris!=i){
                        for (int j=1;j<=this.GetMaksNeffKolom();j++){
                            this.SetNilai(i, j, 
                                this.GetNilai(i, j) + this.GetNilai(counterBaris, j)
                            );
                        }
                    }
                    counterBaris++;  
                }
        }
        /* METODE ELIMINASI GAUSS */
        double pengali;
        for(int k=1;k<=this.GetMaksNeffKolom()-1;k++){
            /* OPERASI BARIS ELEMENTER */
            for (int i=this.GetMaksNeffBaris();i>k;i--){
                
                if(this.GetNilai(i-1, k)==0)    {pengali = 0;}
                else    {pengali = this.GetNilai(i, k)/this.GetNilai(i-1, k);}
                
                for (int j=k;j<=this.GetMaksNeffKolom();j++){
                    this.SetNilai(i,j,
                        this.GetNilai(i,j)-this.GetNilai(i-1,j)*pengali
                    );
                }
            }
            /* SCALING */
            for (int j=this.GetMaksNeffKolom();j>=k;j--){
                this.SetNilai(k,j,
                    this.GetNilai(k,j)/this.GetNilai(k,k)
                );
            }
        }
    }

    public void MetodeEliminasiJordan() {
        /*
        I.S. Augmented Matriks yang sudah Echelon form
        F.S. Augmented Matriks Reduced Echelon form
        PREKONDISI : MATRIKS HARUS SUDAH ECHELON FORM
        */
        /* METODE ELIMINASI JORDAN */
        int baris = 1,barisSebelum=0;
        for (int k = 1; k < this.GetMaksNeffKolom(); k++) {
            while (this.GetNilai(baris, k)!=1 && baris<this.GetMaksNeffBaris()){
                baris++; 
            }
            //System.out.println(baris);
            if(baris!=barisSebelum && baris<=this.GetMaksNeffBaris()){
                for (int i = 1; i < baris; i++) {
                    for (int j = this.GetMaksNeffKolom(); j >= k; j--) {
                        this.SetNilai(i,j,
                            this.GetNilai(i, j)-(this.GetNilai(baris, j)*this.GetNilai(i, k))
                        );
                    }
                }
                barisSebelum = baris;
                baris++;
            }
        }
    }

    public void TulisHasilGauss() {
        /*PREKONDISI : AUGMENTED MATRIKS DALAM BENTUK ECHELON FORM*/
        double hasil[][] = new double[this.GetMaksNeffKolom()+1][this.GetMaksNeffKolom()+1];
        int indeksX = this.GetMaksNeffKolom()-1;
        
        for (int i = this.GetMaksNeffBaris(); i >=1 ; i--) {
            int j = indeksX;
            while((this.GetNilai(i, j)!=1 || this.GetNilai(i, j-1)!=0) && j>1){
                hasil[indeksX][indeksX] = 1;
                hasil[0][indeksX] = 1;
                indeksX--;
                j--;
            }
            hasil[indeksX][0] = this.GetNilai(i, this.GetMaksNeffKolom());
            for (int k = indeksX+1; k <= this.GetMaksNeffKolom(); k++) {
                for (int jj = 0; jj <= this.GetMaksNeffKolom(); jj++) {
                    hasil[indeksX][jj]-=(hasil[k][jj]*this.GetNilai(i, k));
                }
            }
            indeksX--;
        }

        hasil[0][0] = 1;
        for (int i = 1; i <= this.GetMaksNeffKolom()-1; i++) {
            System.out.printf("%3c%d",'x',i);
            for (int j = 0; j <= this.GetMaksNeffKolom()-1; j++) {
                if(hasil[0][j]==1)
                    System.out.printf("  %5.0f",hasil[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void TulisHasilJordan() {
        /*PREKONDISI : AUGMENTED MATRIKS DALAM BENTUK REDUCED ECHELON FORM*/
        boolean isnVarBebas[] = new boolean[this.GetMaksNeffKolom()];
        for (int i = 1; i <= this.GetMaksNeffKolom()-1; i++) {
            isnVarBebas[i] = true;
            for (int j = 1; j <= this.GetMaksNeffBaris(); j++) {
                if(i!=j){
                    isnVarBebas[i] = isnVarBebas[i] && (this.GetNilai(j, i)==0);
                }
            }
        }

        for (int i = 1; i <= this.GetMaksNeffKolom()-1; i++) {
            System.out.printf("%3c%d",'x',i);
            if(isnVarBebas[i]){
                System.out.printf("  %5.0f",this.GetNilai(i, this.GetMaksNeffKolom()));
                for (int j = i; j <= this.GetMaksNeffKolom()-1; j++) {
                    if(this.GetNilai(i, j)==0)
                        this.SetNilai(i, j,-0f);
                    if(!isnVarBebas[j])
                        System.out.printf("  %5.0f",-1*this.GetNilai(i, j));
                }
            }
            else{
                System.out.printf("  %5.0f",0.0);
                for (int j = 1; j <= this.GetMaksNeffKolom()-1; j++) {
                    if(!isnVarBebas[j]){
                        if(i==j){
                            System.out.printf("  %5.0f",1.0);
                        }else{
                           System.out.printf("  %5.0f",0.0);
                        }
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    //end
    //Jundu


}

