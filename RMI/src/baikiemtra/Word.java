/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baikiemtra;

/**
 *
 * @author vuan
 */
public class Word {
    private String vietTat;
    private String dayDu;

    public Word() {
    }

    public Word(String vietTat, String dayDu) {
        this.vietTat = vietTat;
        this.dayDu = dayDu;
    }

    public String getVietTat() {
        return vietTat;
    }

    public void setVietTat(String vietTat) {
        this.vietTat = vietTat;
    }

    public String getDayDu() {
        return dayDu;
    }

    public void setDayDu(String dayDu) {
        this.dayDu = dayDu;
    }

    @Override
    public String toString() {
        return "Word{" + "vietTat=" + vietTat + ", dayDu=" + dayDu + '}';
    }

    
    
    
}
