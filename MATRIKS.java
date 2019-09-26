package TubesAlgeoJFC;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;
import java.lang.Math;

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
    public boolean IsAugmented(){
        return ((this.GetMaksNeffKolom()>this.GetMaksNeffBaris()) && (this.GetMaksNeffKolom()-this.GetMaksNeffBaris()==1));
    }
    public boolean IsKoefisien(){
        return (this.GetMaksNeffBaris()==this.GetMaksNeffKolom());
    }

    //debug purpoos
    public void TulisMatriks(){
        for (int i=1;i<=this.GetMaksNeffBaris();i++){
            System.out.printf("Arr[%3d]: |",i);
            for (int j=1;j<=this.GetMaksNeffKolom();j++){
                System.out.printf("  %9.6f",this.GetNilai(i,j));
            }
            System.out.println("|");
        }
    }
    public void TulisFileMatriks(){
        Scanner input = new Scanner(System.in);
        System.out.print("Nama File: ");
        String namaFile = input.nextLine();
        try {
            FileWriter fileWriter = new FileWriter(namaFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (int i=1;i<=this.GetMaksNeffBaris();i++){
                // System.out.printf("Arr[%3d]: |",i);
                for (int j=1;j<this.GetMaksNeffKolom();j++){
                    printWriter.printf("%.6f ",this.GetNilai(i,j));
                }
                // System.out.println("|");
                printWriter.printf("%.6f\n",this.GetNilai(i,this.GetMaksNeffKolom()));
            }
            printWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
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

    public MATRIKS KaliMatriks(MATRIKS A, MATRIKS B){
        /* KAMUS */
        int i,j,k;
        double temp;
        /* ALGORITMA */
        temp = 0;
        MATRIKS mHasil = new MATRIKS(A.GetMaksNeffBaris(),B.GetMaksNeffKolom());
        for (i=1;i<=A.GetMaksNeffBaris();i++){
            for (j=1;j<=B.GetMaksNeffKolom();j++){
                for (k=1;k<=A.GetMaksNeffKolom();k++){
                    temp += A.GetNilai(i,k) * B.GetNilai(k,j);
                }
                mHasil.SetNilai(i,j,temp);
                temp=0;
            }
        } 
        return mHasil;
    }

    public double DeterminanKofaktor(){
    /* Prekondisi: IsBujurSangkar(M) */
    /* Menghitung nilai determinan M */
        /* KAMUS */
        int i,j;
        int x,subi,subj;
        double det;
        /* ALGORITMA */
        MATRIKS subMatrix = new MATRIKS(this.GetMaksNeffBaris()-1,this.GetMaksNeffKolom()-1);
        subMatrix.SetMaksNeffBaris(this.GetMaksNeffBaris()-1);
        subMatrix.SetMaksNeffKolom(this.GetMaksNeffKolom()-1);
        det = 0;
        // System.out.printf("%d",this.GetMaksNeffKolom());
        if (this.GetMaksNeffKolom() == 1){
            return this.GetNilai(1,1);
        }
        else if (this.GetMaksNeffKolom() == 2){
            return ((this.GetNilai(1,1) * this.GetNilai(2,2)) - (this.GetNilai(1,2) * this.GetNilai(2,1)));
        }else{
            for (x=1;x<=this.GetMaksNeffKolom();x++){
                subi = 1;
                for (i=2;i<=this.GetMaksNeffKolom();i++){
                    subj = 1;
                    for (j=1;j<=this.GetMaksNeffKolom();j++){
                        if (j==x) continue;
                        subMatrix.SetNilai(subi,subj,this.GetNilai(i,j));
                        subj++;
                    }
                    subi++;
                }
                // subMatrix.TulisMatriks();
                det = det + (Math.pow(-1,x-1) * this.GetNilai(1,x) * subMatrix.DeterminanKofaktor());
            }
        }
        return det;
    }

    //Caca
    //Begin
    public double DeterminanTriangular(){
        double ratio,det;
        double temp[][] = new double [this.GetMaksNeffBaris()+1][this.GetMaksNeffKolom()+1];

        /* ALGORITMA */
        if(this.GetMaksNeffKolom() == 1) return this.GetNilai(1,1);
        if(this.GetMaksNeffKolom() == 2){
            return this.GetNilai(1,1)*this.GetNilai(2,2) - this.GetNilai(1,2)*this.GetNilai(2,1);
        }else{ //Mengisi matriks temp bertipe real
            for (int i=1; i<=this.GetMaksNeffBaris(); i++)
            {
                for (int j=1; j<=this.GetMaksNeffKolom(); j++)
                {
                    temp[i][j] = this.GetNilai(i,j);
                }
            }

            // Membentuk matriks segitiga atas
            for (int i = 1; i <= this.GetMaksNeffBaris(); i++)
            {
                for (int j = 1; j <= this.GetMaksNeffKolom(); j++)
                {
                    if (j > i)
                    {
                        ratio = temp[j][i] / temp[i][i];
                        for (int k = 1; k <= this.GetMaksNeffBaris(); k++)
                        {
                            temp[j][k] -= ratio * temp[i][k];
                        }
                    }
                }
            }
            // Determinan didapatkan dari perkalian diagonalnya
            det = 1;
            for (int i = 1; i <= this.GetMaksNeffBaris(); i++){
                det *= temp[i][i];
                System.out.printf("%.4f",temp[i][i]);
            }

            if (det == 0) return 0;
            else return det;
        }
    }

    public double[] cramers()
    {
        int N = this.GetMaksNeffKolom()-1; //Ukuran Matriks Koefisien
        MATRIKS mCari = new MATRIKS(N,N);
        MATRIKS mKoef = new MATRIKS(N,N);
        double ans[] = new double[N+1];
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                for(int k=1; k<=N; k++){
                    mKoef.SetNilai(j,k,this.GetNilai(j,k));
                    if(k == i) mCari.SetNilai(j,k,this.GetNilai(j,this.GetMaksNeffKolom()));
                    else mCari.SetNilai(j,k,this.GetNilai(j,k));
                }
            }
            mCari.TulisMatriks();
            ans[i]=mCari.DeterminanTriangular()/mKoef.DeterminanTriangular();
        }
        // for(int i=1; i<=N; i++) System.out.println(ans[i]);
        return ans;
    }
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

    //Faris
    //Begin
    public void InverseGaussJordan(){
        int neffKAwal;
        if (this.IsAugmented()){
            neffKAwal = this.GetMaksNeffKolom()-1;
            this.SetMaksNeffKolom((this.GetMaksNeffKolom()-1)*2);
        }else{
            neffKAwal = this.GetMaksNeffKolom();
            this.SetMaksNeffKolom(this.GetMaksNeffKolom()*2);
        }
        //Augmenting Identity Matrix:
        for(int i=1; i<=this.GetMaksNeffBaris(); i++){
            for(int j=neffKAwal+1; j<=this.GetMaksNeffKolom(); j++){
                if (i==j-neffKAwal){
                    this.SetNilai(i,j,1);
                }
                else {
                    this.SetNilai(i,j,0);
                }
            }
        }
        this.MetodeEliminasiGauss();
        this.MetodeEliminasiJordan();
        //Disposing Identity Matrix:
        for (int i=1; i<=this.GetMaksNeffBaris();i++){
            for (int j=1;j<=neffKAwal;j++){
                this.SetNilai(i,j,this.GetNilai(i,neffKAwal+j));
            }
        }
        this.SetMaksNeffKolom(neffKAwal);
    }
    //End
    //Faris

}

