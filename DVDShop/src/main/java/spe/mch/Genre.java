package spe.mch;

public class Genre {
    private int number;
    private String name;

    public Genre(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public Genre() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
