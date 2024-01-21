
package QuanLyCongTyBongDa;

public class CauThu extends NhanVien {
    private int soBanThang, soKienTao, soCuuThua;
    @Override
    public double getLuong() { 
        int heSoBanThang=1500, heSoKienTao=1000, heSoCuuThua=1500;     
        return getLuongCoDinh()+(soBanThang*heSoBanThang)+(soKienTao*heSoKienTao)+(soCuuThua*heSoCuuThua);      
    }

    public CauThu() {
    }

    public CauThu(int soBanThang, int soKienTao, int soCuuThua, String ma, String hoTen, String quocTich, String viTri, String cauLacBo, String noiCongTac, Date ngaySinh, boolean gioiTinh, double luongCoDinh) {
        super(ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gioiTinh, luongCoDinh);
        this.soBanThang = soBanThang;
        this.soKienTao = soKienTao;
        this.soCuuThua = soCuuThua;
    }
    public int getSoBanThang() {
        return soBanThang;
    }

    public void setSoBanThang(int soBanThang) {
        this.soBanThang = soBanThang;
    }

    public int getSoKienTao() {
        return soKienTao;
    }

    public void setSoKienTao(int soKienTao) {
        this.soKienTao = soKienTao;
    }

    public int getSoCuuThua() {
        return soCuuThua;
    }

    public void setSoCuuThua(int soCuuThua) {
        this.soCuuThua = soCuuThua;
    }
    @Override
    public String toString() {
        return super.toString() + ", soBanThang=" + soBanThang + ", soKienTao=" + soKienTao + ", soCuuThua=" + soCuuThua + ", "+getLuong();
    }
    
    
    public static void main(String[] args) {
        CauThu a = new CauThu(12, 5, 0, "C01", "Nguyen Cong Phuong", 
                "Viet Nam", "tien dao", "HAGL", "TN", new Date("21/1/1995"), true, 3000);
        System.out.println(a);
    }
    
    
}
