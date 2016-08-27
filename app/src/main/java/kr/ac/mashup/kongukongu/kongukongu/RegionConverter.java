package kr.ac.mashup.kongukongu.kongukongu;

public class RegionConverter {

    static RegionConverter instance;

    private String regionString = "";

    public static RegionConverter getInstance(){

        if( instance == null){
            instance = new RegionConverter();
        }
        return instance;
    }

    public String getRegionString() {
        return regionString;
    }

    public void RegionNumToString(int regionNum) {
        switch (regionNum){
            case 1:
                this.regionString = "강남구";
                break;
            case 2:
                this.regionString = "강동구";
                break;
            case 3:
                this.regionString = "강북구";
                break;
            case 4:
                this.regionString = "강서구";
                break;
            case 5:
                this.regionString = "관악구";
                break;
            case 6:
                this.regionString = "광진구";
                break;
            case 7:
                this.regionString = "구로구";
                break;
            case 8:
                this.regionString = "금천구";
                break;
            case 9:
                this.regionString = "노원구";
                break;
            case 10:
                this.regionString = "도봉구";
                break;
            case 11:
                this.regionString = "동대문구";
                break;
            case 12:
                this.regionString = "동작구";
                break;
            case 13:
                this.regionString = "마포구";
                break;
            case 14:
                this.regionString = "서대문구";
                break;
            case 15:
                this.regionString = "서초구";
                break;
            case 16:
                this.regionString = "성동구";
                break;
            case 17:
                this.regionString = "송파구";
                break;
            case 18:
                this.regionString = "양천구";
                break;
            case 19:
                this.regionString = "영등포구";
                break;
            case 20:
                this.regionString = "용산구";
                break;
            case 21:
                this.regionString = "은평구";
                break;
            case 22:
                this.regionString = "종로구";
                break;
            case 23:
                this.regionString = "중구";
                break;
            case 24:
                this.regionString = "중랑구";
                break;
        }
    }
}
