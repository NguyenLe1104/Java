
package QuanLyCongTyBongDa;

public class HuanLuyenVien extends NhanVien {
    private int soNamKinhNghiem;
    private String  trinhDo, phongCach;

    public HuanLuyenVien() {
    }

    public HuanLuyenVien(int soNamKinhNghiem, String trinhDo, String phongCach, String ma, String hoTen, String quocTich, String viTri, String cauLacBo, String noiCongTac, Date ngaySinh, boolean gioiTinh, double luongCoDinh) {
        super(ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gioiTinh, luongCoDinh);
        this.soNamKinhNghiem = soNamKinhNghiem;
        this.trinhDo = trinhDo;
        this.phongCach = phongCach;
    }
    
    public int getSoNamKinhNghiem() {
        return soNamKinhNghiem;
    }

    public void setSoNamKinhNghiem(int soNamKinhNghiem) {
        this.soNamKinhNghiem = soNamKinhNghiem;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public String getPhongCach() {
        return phongCach;
    }

    public void setPhongCach(String phongCach) {
        this.phongCach = phongCach;
    }

    @Override
    public String toString() {
        return super.toString() + ", soNamKinhNghiem=" + soNamKinhNghiem + ", trinhDo=" + trinhDo + ", phongCach=" + phongCach + ", "+getLuong();
    }
    
    @Override
    public double getLuong() {
        int heSoNamKinhNghiem=1200;
        return getLuongCoDinh()+(soNamKinhNghiem*heSoNamKinhNghiem);
    }   
    public static void main(String[] args) {
        HuanLuyenVien a = new HuanLuyenVien(25, "Gioi", "Tan cong",
                "H01", "Le Van Nguyen", "Viet Nam", "Thu mon", "Quang Nam", "Tn", new Date("11/04/2004"), true,3000);
        System.out.println(a);
       
    }
    
    
}
