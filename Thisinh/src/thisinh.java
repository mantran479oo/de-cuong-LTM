import java.io.Serializable;

public class thisinh implements Serializable {
    int hoten,cmt,date,adress;
    int diem1,diem2,diem3;
    public thisinh(int ht,int cm,int diachi,int ns,float d1,float d2,float d3){
        hoten=ht;
        cmt=cm;
        date=ns;
        adress=diachi;
    }

    public thisinh(int parseInt, float parseFloat, boolean parseBoolean) {
    }

    public void xuat(){
        System.out.println("Ho ten: "+hoten);
        System.out.println("CMT: "+cmt);
        System.out.println("Date: "+date);
        System.out.println("Adrees: "+adress);
        System.out.println("Diem mon 1: "+diem1);
        System.out.println("Diem mon 2: "+diem2);
        System.out.println("Diem mon 3: "+diem3);
    }


}
