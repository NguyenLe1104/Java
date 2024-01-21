
package QuanLyCongTyBongDa;

import QuanLyCongTyBongDa.HuanLuyenVien;
import QuanLyCongTyBongDa.CauThu;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;
public class DanhSachNhanVien {
    private ArrayList<NhanVien> a = new ArrayList<>();
    public void docFile(String tenFile){
        try {
            File f = new File(tenFile);
            if(f.exists()){
                System.out.println("Ok");
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    String s[]=read.nextLine().split(", ");
                    String ma = s[0];
                    String hoTen = s[1];
                    String quocTich = s[2];
                    String viTri = s[3];
                    String cauLacBo = s[4];
                    String noiCongTac = s[5];
                    Date ngaySinh = new Date(s[6]);
                    boolean gt = Boolean.parseBoolean(s[7]);           
                    double luongCoDinh = Double.parseDouble(s[8]);
                    if(s[0].startsWith("C")){
                        int soBanThang = Integer.parseInt(s[9]);
                        int soKienTao = Integer.parseInt(s[10]);
                        int soCuuThua = Integer.parseInt(s[11]);
                        a.add(new CauThu(soBanThang, soKienTao, soCuuThua, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh));
                    }else{
                        int soNamKinhNghiem = Integer.parseInt(s[9]);
                        String trinhDo = s[10];
                        String phongCach = s[11];          
                        a.add(new HuanLuyenVien(soNamKinhNghiem, trinhDo, phongCach, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh));
                    }
                   
                }
            }
            else System.out.println("Khong doc duoc file");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }    
    public boolean xoaTheoMa(String ma){
        for(NhanVien x:a){
            if(x.getMa().equalsIgnoreCase(ma)){
                a.remove(x);
                return true;
            }
        }
        return false;
    }
    public void testXoa(){
        Scanner kb = new Scanner(System.in);
        System.out.print("1.Nhap ma can xoa: ");
        String ma = kb.nextLine();
        if(xoaTheoMa(ma)){
            xuat(a);
        }
        else{
            System.out.println("Ma khong ton tai");
        }
    }
    public boolean themNhanVien(NhanVien y){
        for(NhanVien x:a){
            if(x.getMa().equalsIgnoreCase(y.getMa())){
                return false;
            }
        }
        a.add(y);
        return true;
    }
    public boolean kiemTraMaTonTai(String ma) {
    for (NhanVien nv : a) {
        if (nv.getMa().equalsIgnoreCase(ma)) {
            return true;
        }
    }
    return false;
}
    public void testThem(){
        Scanner kb = new Scanner(System.in);
        String ma;
        System.out.println("2.Them nhan vien");
        do{
            System.out.print("Nhap ma moi:");
            ma = kb.nextLine();
            if(kiemTraMaTonTai(ma))
                System.out.println("Ma da ton tai. Vui long nhap lai");
        } while(kiemTraMaTonTai(ma));       
        System.out.print("Nhap ho ten : ");
        String hoTen = kb.nextLine();
        System.out.print("Nhap quoc tich : ");
        String quocTich = kb.nextLine();
        String viTri;
        System.out.print("Nhap vi tri: ");
        viTri = kb.nextLine();
        System.out.print("Nhap cau lac bo : ");
        String cauLacBo = kb.nextLine();
        String noiCongTac;
        double luongCoDinh = kb.nextDouble();
        do{
            System.out.print("Nhap noi lam viec(TN/NN) : ");
            noiCongTac = kb.nextLine();
        }while(!noiCongTac.equalsIgnoreCase("TN") && !noiCongTac.equalsIgnoreCase("NN"));
        System.out.print("Nhap ngay thang nam sinh(dd/mm/yyyy): ");
        String ngayThangNam = kb.nextLine();
        Date ngaySinh = new Date(ngayThangNam);
        System.out.print("Nhap gioi tinh(true/false): ");
        boolean gt = kb.nextBoolean();
        kb.nextLine();           
        NhanVien nv;
        if(ma.startsWith("C")){
            System.out.print("Nhap so ban thang: ");
            int soBanThang = kb.nextInt();
            System.out.print("Nhap so kien tao: ");
            int soKienTao = kb.nextInt();
            System.out.print("Nhap so cuu thua: ");
            int soCuuThua = kb.nextInt();
            nv = new CauThu(soBanThang, soKienTao, soCuuThua, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh);
        }
        else{
            System.out.print("Nhap so nam kinh nghiem: ");
            int soNamKinhNghiem = kb.nextInt();    
            kb.nextLine();
            System.out.print("Nhap trinh do(gioi/kha/trungbinh): ");
            String trinhDo = kb.nextLine();     
            System.out.print("Nhap phong cach huan luyen: ");
            String phongCach = kb.nextLine();
            nv = new HuanLuyenVien(soNamKinhNghiem, trinhDo, phongCach, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh);
        }
        if(themNhanVien(nv)){
            System.out.println("Da them vao danh sach");
            xuat(a);
        }else{
            System.out.println("Ma da ton tai");
        }
    }
    public NhanVien timKiemTheoMa(String ma) {        
        for (NhanVien x : a) {
            if (x.getMa().equalsIgnoreCase(ma)) {               
                return x;
            }
        }
        return null;
    }
    public void testTimKiem(){
        Scanner kb = new Scanner(System.in);
        System.out.print("3.Nhap ma cau thu hoac huan luyen vien muon tim: ");
        String ma = kb.nextLine();
        NhanVien kq = timKiemTheoMa(ma);
        if(timKiemTheoMa(ma)!=null){
            ArrayList<NhanVien> b = new ArrayList<>();
            b.add(kq);
            xuat(b);
        }
         else{
            System.out.println("Ma khong ton tai");
        }
    }
    public boolean suaThongTin(String ma, NhanVien nv) {
        for (int i = 0; i < a.size(); i++) {
           NhanVien x = a.get(i);
           if (x.getMa().equalsIgnoreCase(ma)) {
               a.set(i, nv);
               return true;
           }
       }
       return false;
   }
    public void testSua() {
        Scanner kb = new Scanner(System.in);
        System.out.print("4.Nhap ma muon sua: ");
        String ma = kb.nextLine();
        if(kiemTraMaTonTai(ma)){
            System.out.print("Nhap ho ten : ");
            String hoTen = kb.nextLine();
            System.out.print("Nhap quoc tich : ");
            String quocTich = kb.nextLine();
            String viTri;
            System.out.print("Nhap vi tri: ");
            viTri = kb.nextLine();            
            System.out.print("Nhap cau lac bo : ");
            String cauLacBo = kb.nextLine();
            String noiCongTac;
            do{
                System.out.print("Nhap noi lam viec(TN/NN) : ");
                noiCongTac = kb.nextLine();
            }while(!noiCongTac.equalsIgnoreCase("TN") && !noiCongTac.equalsIgnoreCase("NN"));
            System.out.print("Nhap ngay thang nam sinh(dd/mm/yyyy): ");
            String ngayThangNam = kb.nextLine();
            Date ngaySinh = new Date(ngayThangNam);
            System.out.print("Nhap gioi tinh(true/false): ");
            boolean gt = kb.nextBoolean();
            kb.nextLine();         
            double luongCoDinh = 3000;
            NhanVien nv;
            if(ma.startsWith("C")){
                System.out.print("Nhap so ban thang: ");
                int soBanThang = kb.nextInt();
                System.out.print("Nhap so kien tao: ");
                int soKienTao = kb.nextInt();
                System.out.print("Nhap so cuu thua: ");
                int soCuuThua = kb.nextInt();
                nv = new CauThu(soBanThang, soKienTao, soCuuThua, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh);
            }
            else{
                System.out.print("Nhap so nam kinh nghiem: ");
                int soNamKinhNghiem = kb.nextInt();    
                kb.nextLine();
                System.out.print("Nhap trinh do(gioi/kha/trungbinh): ");
                String trinhDo = kb.nextLine();     
                System.out.print("Nhap phong cach huan luyen: ");
                String phongCach = kb.nextLine();
                nv = new HuanLuyenVien(soNamKinhNghiem, trinhDo, phongCach, ma, hoTen, quocTich, viTri, cauLacBo, noiCongTac, ngaySinh, gt, luongCoDinh);
            }
            if(suaThongTin(ma, nv)){
                System.out.println("Sua thanh cong");
                xuat(a);
            }
            else System.out.println("Khong the sua thong tin");
            }
        else System.out.println("Ma da ton tai");
    }
    
    public ArrayList maxLuong(){
        ArrayList<NhanVien> b = new ArrayList<>();
        double max = Double.MIN_VALUE;
        for (NhanVien x : a) {            
            if (x.getLuong()> max) {
                max = x.getLuong();
                b.clear();  
                b.add(x);
                }
            else if(x.getLuong()==max){
                b.add(x);
            }
            }       
        return b;
    }
     public ArrayList maxSoCuuThua(){
         ArrayList<NhanVien> b = new ArrayList<>();
        int maxSoCuuThua = Integer.MIN_VALUE;
        for (NhanVien x : a) {
            if (x instanceof CauThu) {
                if (((CauThu) x).getSoCuuThua() > maxSoCuuThua) {
                    maxSoCuuThua = ((CauThu) x).getSoCuuThua();      
                    b.clear();  
                    b.add(x);
                }
                else if(((CauThu) x).getSoCuuThua()==maxSoCuuThua){
                     b.add(x);
            }
            }
        }   
        return b;
        }
    public ArrayList huanLuyenVienItKinhNghiemNhat(){
        ArrayList<NhanVien> b = new ArrayList<>();
        int minKinhNghiem = Integer.MAX_VALUE;
        for(NhanVien x:a){
            if(x instanceof HuanLuyenVien){
                if(((HuanLuyenVien) x).getSoNamKinhNghiem()<minKinhNghiem){
                    minKinhNghiem = ((HuanLuyenVien) x).getSoNamKinhNghiem();
                     b.clear();  
                    b.add(x);
                }
                else if(((HuanLuyenVien) x).getSoNamKinhNghiem()==minKinhNghiem){
                    b.add(x);
                }
            }
        }
        return b;
    }
    
    public ArrayList inDanhSachCauThuHuanLuyenVien(String tenLop){
        ArrayList<NhanVien> b = new ArrayList<>();
        for(NhanVien x:a){
            if(x.getClass().getSimpleName().equalsIgnoreCase(tenLop))
                b.add(x);
        }
        return b;       
    }
    public int tongSoBanThang(){
        int s=0;
        for(NhanVien x:a){
            if(x instanceof CauThu){
                s=s+((CauThu) x).getSoBanThang();
            }
        }
        return s;
    }

    public ArrayList<NhanVien> sapXepGiamTheoLuong(){
        ArrayList<NhanVien> b = new ArrayList<>(a);
        Collections.sort(b, new Comparator<NhanVien>(){
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return Double.compare(o2.getLuong(), o1.getLuong());
            }           
        });
      
        return b;
    }
    public void ghiFile(String tenFile) {
        try {
            FileWriter fileWriter = new FileWriter(tenFile);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (NhanVien  x: a) {
                if ( x instanceof CauThu) {
                    printWriter.println(((CauThu) x).toString());
                } else if (x instanceof HuanLuyenVien) {
                    printWriter.println(((HuanLuyenVien) x).toString());
                }
            }
            printWriter.close();
            System.out.println("10.Ghi file thanh cong");
        } catch (Exception e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
    public NhanVien getPostion(int pos){
        return a.get(pos);
    }
    public int maxC(){
        int index = 0;
        double max = 0;
        for(int i = 0;i<a.size();i++){
           if(a.get(i) instanceof CauThu){
               double cuuThuaValue = ((CauThu) a.get(i)).getSoCuuThua();
               if(cuuThuaValue>max){
                   max = cuuThuaValue;
                   index = i;
               }
           } 
        }
        return index;
    }
    public int min(){
        int index = 0;
        double min = Double.MAX_VALUE;
        for(int i=0; i<a.size(); i++){
            if(a.get(i) instanceof HuanLuyenVien){
                double kn = ((HuanLuyenVien) a.get(i)).getSoNamKinhNghiem();
                if(kn<min){
                    min = kn;
                    index = i;
                }
            }
        }
        return index;
    }
    public int maxL(){
        int index = 0;
        double max = 0;
        for(int i = 0;i<a.size();i++){
            if(a.get(i).getLuong() > max){
                max = a.get(i).getLuong();
                index = i;
            }
        }
        return index;
    }
    public DanhSachNhanVien() {
    }

    public ArrayList<NhanVien> getA() {
        return a;
    }

    public void setA(ArrayList<NhanVien> a) {
        this.a = a;
    }
       
    public void output(){
        xuat(a);
        System.out.println("Danh sach cau thu");
        xuat(inDanhSachCauThuHuanLuyenVien("CauThu"));
        System.out.println("Danh sach huan luyen vien");
        xuat(inDanhSachCauThuHuanLuyenVien("HuanLuyenVien"));
        testXoa();
        testThem();
        testTimKiem();
        testSua();
        System.out.println("5.Nguoi co luong cao nhat ");  
        xuat(maxLuong());
        System.out.println("6.Cau thu co so cuu thua cao nhat: ");
        xuat(maxSoCuuThua());
        System.out.println("7.Huan luyen vien it kinh nghiem nhat: ");
        xuat(huanLuyenVienItKinhNghiemNhat());
        System.out.println("8.Tong so ban thang: "+tongSoBanThang());           
        System.out.println("9.Danh sach sau khi sap xep giam theo luong");
        xuat(sapXepGiamTheoLuong());
        ghiFile("CT_HLV.txt");
    }
    public void xuat(ArrayList a){
        for(Object x:a){
            System.out.println(x);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DanhSachNhanVien a = new DanhSachNhanVien();
        a.docFile("CauThu.txt");
        a.output();
    }
}
