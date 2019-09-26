public double DeterminanTriangular(){
        double ratio,det=1;
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

            // for (int i=1; i<=this.GetMaksNeffBaris(); i++)
            // {
            //     for (int j=1; j<=this.GetMaksNeffKolom(); j++)
            //     {
            //         System.out.printf("%.4f ",temp[i][j]);
            //     }
            //     System.out.printf("\n");
            // }

            // Membentuk matriks segitiga atas
            for(int i=1; i< this.GetMaksNeffBaris(); i++){
                int idx0=i;
                while(temp[idx0][i]==0 && idx0<this.GetMaksNeffBaris()) idx0++;
                if(idx0==this.GetMaksNeffBaris()+1) continue;
                if(idx0>this.GetMaksNeffBaris()){
                    return 0;
                }
                if(idx0!=i){
                    double [] bntr = temp[idx0];
                    temp[idx0] = temp[i];
                    temp [i] = bntr;
                    det *= -1.000000000;
                    
                    // for(int k=1; k<=this.GetMaksNeffBaris();k++){
                    //     double bntr = temp[idx0][k];
                    //     temp[idx0][k] = temp[i][k];
                    //     temp[i][k] = bntr;
                    // }
                }
            }

            // for (int i=1; i<=this.GetMaksNeffBaris(); i++)
            // {
            //     for (int j=1; j<=this.GetMaksNeffKolom(); j++)
            //     {
            //         System.out.printf("%.4f ",temp[i][j]);
            //     }
            //     System.out.printf("\n");
            // }

            for(int i=1; i< this.GetMaksNeffBaris(); i++){
                for(int j=i+1; j<=this.GetMaksNeffKolom(); j++){
                    if(temp[i][i]!=0){
                    ratio= temp[j][i] / temp [i][i];
                    for(int k=1; k<=this.GetMaksNeffKolom(); k++){
                        temp[j][k]-=ratio*temp[i][k];
                    }
                    }
                }
            }

            // for (int i=1; i<=this.GetMaksNeffBaris(); i++)
            // {
            //     for (int j=1; j<=this.GetMaksNeffKolom(); j++)
            //     {
            //         System.out.printf("%.4f ",temp[i][j]);
            //     }
            //     System.out.printf("\n");
            // }
            
            // Determinan didapatkan dari perkalian diagonalnya
            for (int i = 1; i <= this.GetMaksNeffBaris(); i++){
                det *= temp[i][i];
                //System.out.printf("%.4f ",temp[i][i]);
            }

            if (det == 0) return 0;
            else return det;
        }
    }