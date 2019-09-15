package TubesAlgeoJFC;
import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class MATRIKS 
{ 
    float isi[][]; // 1 - 100
    int maksNeffKolom;
    int maksNeffBaris;

    //konstruktor

    public MATRIKS(int maksBaris, int maksKolom){
        this.maksNeffBaris = 0;
        this.maksNeffKolom = 0;
        this.isi = new float[maksBaris][maksKolom];
    }

    // getter
    public int GetMaksNeffKolom(){
        return this.maksNeffKolom;
    }
    public int GetMaksNeffBaris(){
        return this.maksNeffBaris;
    }
    public float GetNilai(int baris,int kolom){
        return this.isi[baris][kolom];
    }

    //setter
    public void SetMaksNeffKolom(int kolomBaru){
        this.maksNeffKolom = kolomBaru;
    }
    public void SetMaksNeffBaris(int barisBaru){
        this.maksNeffBaris = barisBaru;
    }
    public void SetNilai(int baris,int kolom,float nilaiBaru){
        this.isi[baris][kolom] = nilaiBaru;
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
    // public void BacaFileMatriks(){
    //     int i=1;
    //     Scanner input = new Scanner(System.in);
    //     String namaFile = input.nextLine();
    //     Path lokasiFile = Paths.get(namaFile);
    //     if (Files.notExists(lokasiFile)){
    //         System.out.println("Filenya gaada anjing");
    //     }else{
    //         File file = new File(namaFile);

    //         try (BufferedReader br = new BufferedReader(new FileReader(file))){
    //             String st;

    //             while ((st = br.readLine()) != null){
    //                 System.out.println(st);
    //                 String[] nums = st.trim().split("\\s+");
    //                 for (int j=1;j<=nums.length+1;j++){
    //                     System.out.printf("%s,%d",nums[j-1],i);
    //                     this.SetNilai(i,j,Float.parseFloat(nums[j-1]));
    //                 }
    //                 i++;
    //                 this.SetMaksNeffKolom(nums.length);
    //             }
    //             this.SetMaksNeffBaris(i-1);
    //         }
    //         catch (IOException e){
    //             System.out.println("Teuing anjing error IO");
    //         }
    //         // catch (FileNotFoundException e){
    //         //     System.out.println("Teuing anjing error File");
    //         // }
    //     }
    // }
    public void BacaMatriks(){
        Scanner input = new Scanner(System.in);
        int b = input.nextInt();
        int k = input.nextInt();
        this.SetMaksNeffBaris(b);
        this.SetMaksNeffKolom(k);
        for (int i=1;i<=GetMaksNeffBaris();i++){
            for (int j=1;j<=GetMaksNeffKolom();j++){
                this.SetNilai(i,j,input.nextFloat());
            }
        }
    }

    //Jundu
    public void MetodeEliminasiGauss() {
        /*
        I.S. sembarang Augmented Matriks
        F.S. Augmented Matriks Echelon form
        */

        /* METODE ELIMINASI GAUSS */
        float pengali;
        for(int k=1;k<=this.GetMaksNeffKolom()-1;k++){
            for (int i=this.GetMaksNeffBaris();i>k;i--){
                
                if(this.GetNilai(i-1, k)==0)    {pengali = 0;}
                else    {pengali = this.GetNilai(i, k)/this.GetNilai(i-1, k);}
                
                for (int j=k;j<=this.GetMaksNeffKolom();j++){
                    this.SetNilai(i,j,
                        this.GetNilai(i,j)-this.GetNilai(i-1,j)*pengali
                    );
                }
            }
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
        for (int i = this.GetMaksNeffBaris()-1; i >= 1; i--) {
            for (int j =this.GetMaksNeffKolom()-1 ; j > i; j--) {
                this.SetNilai(i, this.GetMaksNeffKolom(), 
                    this.GetNilai(i, this.GetMaksNeffKolom())-
                    (this.GetNilai(i, j)*this.GetNilai(j, this.GetMaksNeffKolom()))
                );
                this.SetNilai(i, j, 0);
            }
        }
    }

    public void TulisHasilGauss() {
        /*PREKONDISI : MATRIKS DALAM BENTUK ECHELON FORM*/
        float hasil[] = new float[this.GetMaksNeffKolom()];
        for (int i = this.GetMaksNeffKolom()-1; i >=1 ; i--) {
            hasil[i] = this.GetNilai(i, this.GetMaksNeffKolom());
            for (int j = i+1; j <= GetMaksNeffKolom()-1; j++) {
                hasil[i]-=(this.GetNilai(i, j)*hasil[j]);
            }
        }
        for (int i = 1; i <= this.GetMaksNeffKolom()-1; i++) {
            System.out.printf(hasil[i]+" ");
        }
        System.out.println();
    }

    public void TulisHasilJordan() {
        /*PREKONDISI : MATRIKS DALAM BENTUK REDUCED ECHELON FORM*/
        for (int i = 1; i <= this.GetMaksNeffKolom()-1; i++) {
            System.out.printf(this.GetNilai(i, this.GetMaksNeffKolom())+" ");
        }
        System.out.println();
    }
}