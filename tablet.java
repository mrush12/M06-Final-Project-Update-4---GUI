public class tablet {
    private String Apple;
    private String Amazon;
    private String Samsung;

    public Electronic(String Apple, String Motorola, String Samsung) {
        this.Iphone = Apple;
        this.Motorola = Amazon;
        this.Samsung = Samsung;
    }

    // Getters and setters for the Tablet's properties
    // ...

    @Override
    public String toString() {
        return "tablet{" +
                "Apple='" + Ipad + '\'' +
                ", Motorola='" + Motorola + '\'' +
                ", Samsung=" + Samsung +
                '}';
    }
}
