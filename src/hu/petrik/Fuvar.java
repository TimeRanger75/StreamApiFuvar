package hu.petrik;

public class Fuvar {
    private int t_azosito;
    private String indulas;
    private int utazas;
    private double tavolsag;
    private double veteldij;
    private double borravalo;
    private String fizetes_modja;



    public Fuvar(String sor){
        String[] adatok=sor.replace(",",".").split(";");
        this.t_azosito=Integer.parseInt(adatok[0]);
        this.indulas=adatok[1];
        this.utazas=Integer.parseInt(adatok[2]);
        this.tavolsag=Double.parseDouble(adatok[3]);
        this.veteldij=Double.parseDouble(adatok[4]);
        this.borravalo=Double.parseDouble(adatok[5]);
        this.fizetes_modja=adatok[6];
    }

    public Fuvar(int t_azosito, String indulas, int utazas, double tavolsag, double veteldij, double borravalo, String fizetes_modja, double bevetel) {
        this.t_azosito = t_azosito;
        this.indulas = indulas;
        this.utazas = utazas;
        this.tavolsag = tavolsag;
        this.veteldij = veteldij;
        this.borravalo = borravalo;
        this.fizetes_modja = fizetes_modja;
    }


    public int getT_azosito() {
        return t_azosito;
    }

    public String getIndulas() {
        return indulas;
    }

    public int getUtazas() {
        return utazas;
    }

    public double getTavolsag() {
        return tavolsag;
    }

    public double getVeteldij() {
        return veteldij;
    }

    public double getBorravalo() {
        return borravalo;
    }

    public String getFizetes_modja() {
        return fizetes_modja;
    }

    public double getBevetel(){
        return veteldij+borravalo;
    }

    public double getArany_bokezo(){
        return borravalo/veteldij;
    }

    @Override
    public String toString() {
        return "Fuvar{" +
                "t_azosito=" + t_azosito +
                ", indulas='" + indulas + '\'' +
                ", utazas=" + utazas +
                ", tavolsag=" + tavolsag +
                ", veteldij=" + veteldij +
                ", borravalo=" + borravalo +
                ", fizetes_modja='" + fizetes_modja + '\'' +
                '}';
    }
}
