package kr.ac.mashup.kongukongu.kongukongu.home;

/**
 * Created by owner on 2016-08-27.
 */
public class HomeItemData {

    private int imgMain;
    private String text01;
    private String textt02;

    public HomeItemData(int imgMain, String text01, String textt02) {
        this.imgMain = imgMain;
        this.text01 = text01;
        this.textt02 = textt02;
    }

    public int getImgMain() {
        return imgMain;
    }

    public void setImgMain(int imgMain) {
        this.imgMain = imgMain;
    }

    public String getText01() {
        return text01;
    }

    public void setText01(String text01) {
        this.text01 = text01;
    }

    public String getTextt02() {
        return textt02;
    }

    public void setTextt02(String textt02) {
        this.textt02 = textt02;
    }
}
