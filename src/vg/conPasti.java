package vg;

public abstract class conPasti extends Viaggi{
    private  boolean PensioneComp;

    public conPasti(String destinazione, int durata, double costo, boolean PensioneComp){
        super(destinazione,  durata, costo);
        this.PensioneComp=PensioneComp;
    }

    public conPasti(String destinazione, int durata, double costobase) {
        super(destinazione, durata, costobase);
    }

    public boolean GetPensioneComp() {
        return PensioneComp;
    }

    public void setPensioneComp(boolean pensioneComp) {
        PensioneComp = pensioneComp;
    }
    public String toString() {
        return super.toString() + " pensioneCompleta " + this.PensioneComp;
    }
    public boolean equals(Object o){
        if(o instanceof Viaggi){
            Viaggi r=(Viaggi) o;
            return super.equals(o) && this.PensioneComp==GetPensioneComp();
        }
        return false;
    }
    public double getCosto() {
        if (GetPensioneComp()) {
            return super.getCosto() + getDurata()*35;
        }
        return super.getCosto() + getDurata()*25;
    }
}
