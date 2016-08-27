package kr.ac.mashup.kongukongu.kongukongu.server;

public class ServerUserResult {
    private String nickname;
    private int regionNum;

    public ServerUserResult(String nickname, int regionNum) {
        this.nickname = nickname;
        this.regionNum = regionNum;
    }

    public String getNickname() {
        return nickname;
    }

    public int getRegionNum() {
        return regionNum;
    }
}
