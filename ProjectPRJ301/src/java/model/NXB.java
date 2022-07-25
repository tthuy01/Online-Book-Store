package model;

/**
 *
 * @author May Tinh Ha Anh
 */
public class NXB {
    private String maNXB;
    private String tenNXB;
    private String diaChi;

    public NXB() {
    }

    public NXB(String maNXB, String tenNXB, String diaChi) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
    }

    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
