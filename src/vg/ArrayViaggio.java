package vg;

public class ArrayViaggio {
    private Viaggi [] viag;
    private int inseriti;

    public ArrayViaggio(Viaggi[] viaggios, int inseriti) {
        this.viag = viaggios;
        this.inseriti=inseriti;
    }
    public ArrayViaggio(int nViaggio) {
        this(new Viaggi[nViaggio],0);
    }

    public ArrayViaggio() {
        this(new Viaggi[100],0);
    }


    public Viaggi[] getViaggio() {
        return viag;
    }

    public void setViaggio(Viaggi[] viaggio) {
        this.viag = viaggio;
    }

    public int getInseriti() {
        return inseriti;
    }
    public void setInseriti(int inseriti) {
        this.inseriti = inseriti;
    }

    public String toString() {
        String s="Elenco:\n";
        for (int i=0;i<this.inseriti;i++){
            s=s+ viag[i].toString()+", costo: "+ viag[i].getCostoViaggio()+" \n";
        }
        return s;
    }

    public boolean equals(Object o){
        if(o instanceof ArrayViaggio){
            ArrayViaggio r=(ArrayViaggio) o;
            for (int i=0;i<this.inseriti;i++){
                if (!viag[i].equals(r.getViaggio()[i])){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public boolean inserisci(Viaggi viaggio){
        if (this.inseriti== viag.length)
            return false;
        else {
            viag[this.inseriti] = viaggio;
            this.inseriti++;
            return true;
        }
    }

    public double getCostoMedio(){
        double costo=0.0;
        for (int i=0;i<this.inseriti;i++){
            costo+= viag[i].getCostoViaggio();
        }
        return costo/this.inseriti;
    }

    public int getPosizionePacchettoMin(){
        double costoMin= viag[0].getCostoViaggio();
        int posMin=0;
        for (int i=0;i<this.inseriti;i++){
            if (costoMin> viag[i].getCostoViaggio()){
                costoMin= viag[i].getCostoViaggio();
                posMin=i;
            }
        }
        return posMin;
    }

    public int getPosizionePacchettoMax(){
        double costoMax= viag[0].getCostoViaggio();
        int posMax=0;
        for (int i=0;i<this.inseriti;i++){
            if (costoMax< viag[i].getCostoViaggio()){
                costoMax= viag[i].getCostoViaggio();
                posMax=i;
            }
        }
        return posMax;
    }

    public String getMinMax(){
        return "Max: "+ viag[getPosizionePacchettoMax()].toString()+"\n\n Min: "+ viag[getPosizionePacchettoMin()].toString();
    }
}