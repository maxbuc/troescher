package spe.mch;

import java.util.ArrayList;

public class DVD {
    private int did;
    private String titel;
    private int laenge;
    private int erscheinungsjahr;
    private ArrayList<String> sprache;
    private String genre;
    private int fsk;
    private boolean verfuegbar;

    public DVD(int did, String titel, int laenge, int erscheinungsjahr, ArrayList<String> sprache, String genre, int fsk) {
        this.did = did;
        this.titel = titel;
        this.laenge = laenge;
        this.erscheinungsjahr = erscheinungsjahr;
        this.sprache = sprache;
        this.genre = genre;
        this.fsk = fsk;
    }

    public DVD(int did, String titel) {
        this.did = did;
        this.titel = titel;
    }

    
    
    public DVD() {
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public int getLaenge() {
        return laenge;
    }

    public void setLaenge(int laenge) {
        this.laenge = laenge;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    public ArrayList<String> getSprache() {
        return sprache;
    }

    public void setSprache(ArrayList<String> sprache) {
        this.sprache = sprache;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getFsk() {
        return fsk;
    }

    public void setFsk(int fsk) {
        this.fsk = fsk;
    }

    public boolean isVerfuegbar() {
        return verfuegbar;
    }

    public void setVerfuegbar(boolean verfuegbar) {
        this.verfuegbar = verfuegbar;
    }

    
   
}
