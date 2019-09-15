package MatriksLib;
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
        for (int i=1;i<=GetMaksNeffBaris();i++){
            System.out.printf("Arr[%3d]: |",i);
            for (int j=1;j<=GetMaksNeffKolom();j++){
                System.out.printf("  %8.2f",GetNilai(i,j));
            }
            System.out.println("|");
        }
    }
    public void BacaFileMatriks(){
        int i=1;
        Scanner input = new Scanner(System.in);
        String namaFile = input.nextLine();
        Path lokasiFile = Paths.get(namaFile);
        if (Files.notExists(lokasiFile)){
            System.out.println("Filenya gaada anjing");
        }else{
            File file = new File(namaFile);

            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                String st;

                while ((st = br.readLine()) != null){
                    System.out.println(st);
                    String[] nums = st.trim().split("\\s+");
                    for (int j=1;j<=nums.length+1;j++){
                        System.out.printf("%s,%d",nums[j-1],i);
                        this.SetNilai(i,j,Float.parseFloat(nums[j-1]));
                    }
                    i++;
                    this.SetMaksNeffKolom(nums.length);
                }
                this.SetMaksNeffBaris(i-1);
            }
            catch (IOException e){
                System.out.println("Teuing anjing error IO");
            }
            // catch (FileNotFoundException e){
            //     System.out.println("Teuing anjing error File");
            // }
        }
    }
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
} 