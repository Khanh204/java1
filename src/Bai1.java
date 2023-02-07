public class Bai1 {
    String ten;
    String sdt;

    public Bai1(String ten, String sdt) {
        this.ten = ten;
        this.sdt = sdt;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String toString(){
        return this.ten;
    }
}