package jp.co.obs.android.AndroidHello;

public class DB_Location_DTO {
	// DBアクセス用のDTOを定義
    private String addtime;     // 日付時刻
    private String addflg;      // 1:始業　2:移動　3:終業
    private String latitude;    // 緯度
    private String longitude;   // 経度

    public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddflg(String addflg) {
		this.addflg = addflg;
	}

	public String getAddflg() {
		return addflg;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLongitude() {
		return longitude;
	}

}
