
package QuanLyCongTyBongDa;


public class Date {
    private int ngay, thang, nam;

    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    public Date(String nd){
        String s[]=nd.split("/");
        this.ngay=Integer.parseInt(s[0]);
        this.thang=Integer.parseInt(s[1]);
        this.nam=Integer.parseInt(s[2]);
    }


    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    @Override
    public String toString() {
        return  ngay + "/" + thang + "/" + nam ;
    }
    public static void main(String[] args) {
        Date a = new Date("21/11/2020");
        System.out.println(a);
    }
}
