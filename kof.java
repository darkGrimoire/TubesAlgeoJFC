public MATRIKS delrowcol(int p, int q){
    MATRIKS newm = new MATRIKS(this.GetMaksNeffBaris(),this.GetMaksNeffKolom());
    int a=1,b=1;
    for(int i=1; i<=this.GetMaksNeffBaris(); i++){
        for(int j=1; j<=this.GetMaksNeffKolom(); j++){
            if(a!=i && b!=j){
                newm.isi[a][b]=this.isi[i][j];
                b++;
                if(b>this.GetMaksNeffKolom()-1){
                    b=1;
                    a++;
                }
            }
        }
    }
    return newm;
}

public double countkof(int p, int q){
    if((p+q)%2 != 0 ){
        return determinan(delrowcol(p,q))*(-1);
    }else return (this.delrowcol(p,q)).determinan();
}

public MATRIKS kofaktor(){
    MATRIKS kof = new MATRIKS(this.GetMaksNeffBaris()+1,this.GetMaksNeffKolom()+1);
    for(int i=1; i<=this.GetMaksNeffBaris(); i++){
        for(int j=1; j<=this.GetMaksNeffKolom(); j++){
            kof.isi[i][j]=this.countkof(i,j);
        }
    }
    return kof;
}

public MATRIKS transpose(){
    MATRIKS trans = new MATRIKS(this.GetMaksNeffBaris()+1,this.GetMaksNeffKolom()+1);
    for(int i=1; i<=this.GetMaksNeffBaris(); i++){
        for(int j=1; j<=this.GetMaksNeffKolom(); j++){
            trans.isi[i][j]=this.isi[j][i];
        }
    }
    return trans;
}

public MATRIKS adjoin(){
    return (this.kofaktor).transpose;
}