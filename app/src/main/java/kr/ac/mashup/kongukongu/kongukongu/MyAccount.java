package kr.ac.mashup.kongukongu.kongukongu;


public class MyAccount {

    static MyAccount instance;

    private String kakaoId = "";
    public static MyAccount getInstance(){

        if( instance == null){
            instance = new MyAccount();
        }
        return instance;
    }

    public String getKakaoId() {
        return kakaoId;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

}
