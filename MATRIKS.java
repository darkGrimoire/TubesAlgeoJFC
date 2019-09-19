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
        float pengali;
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
        /*PREKONDISI : AUGMENTED MATRIKS DALAM BENTUK REDUCED ECHELON FORM*/
        //Matriks X
        System.out.printf("(");
        for (int j = 1; j <=this.GetMaksNeffBaris(); j++) {
            System.out.printf("%3c%d",'x',j);
        }
        System.out.printf(") = ");
        
        //Matriks b
        System.out.printf("(");
        for (int j = 1; j <=this.GetMaksNeffBaris(); j++) {
            System.out.printf("  %5.2f",this.GetNilai(j,this.GetMaksNeffKolom()));
        }
        System.out.printf(") ");
        
        //Matriks Translasi
        for (int i = 2; i <= this.GetMaksNeffKolom()-1; i++) {
            if(this.GetNilai(1, i)!=0){
                System.out.printf("-p(");
                for (int j = 1; j <=this.GetMaksNeffBaris(); j++) {
                    System.out.printf("  %5.2f",this.GetNilai(j,i));
                }
                System.out.printf(") ");
            }
        }

        System.out.println();
    }
}