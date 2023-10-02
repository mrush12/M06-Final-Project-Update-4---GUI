public class cellPhone {
    private String Iphone;
    private String Motorola;
    private String Samsung;

    public Electronic(String Iphone, String Motorola, String Samsung) {
        this.Iphone = Iphone;
        this.Motorola = Motorola;
        this.Samsung = Samsung;
    }

    // Getters and setters for the cell Phone's properties
    // ...

    @Override
    public String toString() {
        return "cellPhone{" +
                "Iphone='" + Iphone + '\'' +
                ", Motorola='" + Motorola + '\'' +
                ", Samsung=" + Samsung +
                '}';
    }
}
