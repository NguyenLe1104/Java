
package QuanLyCongTyBongDa;


public abstract class NhanVien {
    private String ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac;
    private Date ngaySinh;
    private boolean gioiTinh;
    private double luongCoDinh;
    public abstract double getLuong();
    public NhanVien() {
    }

    public NhanVien(String ma, String hoTen, String quocTich, String viTri, String cauLacBo, String noiCongTac, Date ngaySinh, boolean gioiTinh, double luongCoDinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.quocTich = quocTich;
        this.viTri = viTri;
        this.cauLacBo = cauLacBo;
        this.noiCongTac = noiCongTac;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.luongCoDinh = luongCoDinh;
    }


    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getQuocTich() {
        return quocTich;
    }
    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }
    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getCauLacBo() {
        return cauLacBo;
    }

    public void setCauLacBo(String cauLacBo) {
        this.cauLacBo = cauLacBo;
    }

    public String getNoiCongTac() {
        return noiCongTac;
    }

    public void setNoiCongTac(String noiCongTac) {
        this.noiCongTac = noiCongTac;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getLuongCoDinh() {
        return luongCoDinh;
    }

    public void setLuongCoDinh(double luongCoDinh) {
        this.luongCoDinh = luongCoDinh;
    }

    @Override
    public String toString() {
        return   ma + ", " + hoTen + ", " + quocTich + ", " + viTri + ", " + cauLacBo + ", " + noiCongTac + ", " + ngaySinh + ", " +
                gioiTinh + ", " + luongCoDinh ;
    }
    
    
    
}
