package jp.co.obs.android.AndroidHello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompleteActivity extends Activity {

	public Location get_location() {
        LocationManager location_manager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
    	String bs = location_manager.getBestProvider( new Criteria(), true);
    	Location loc = location_manager.getLastKnownLocation( bs );
    	return loc;
    }

	public class Button5ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(CompleteActivity.this, AndroidHelloActivity.class);
	    	startActivity(intent);
	    }
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete);

        // ボタン5が押された時の呼び先を定義
        Button myButton5 = (Button) findViewById(R.id.button5);
        myButton5.setOnClickListener(new Button5ClickListener());

    	Location loc = get_location();
    	String latitude = "";
    	String longitude = "";

        if( loc == null) {
        	latitude = "　取得不可";
        	longitude = "　取得不可";
        }
        else {
        	latitude = String.valueOf(loc.getLatitude());
        	longitude = String.valueOf(loc.getLongitude());
        }

    	TextView textView1 = (TextView)findViewById(R.id.textView1);
        // 日付のフォーマット編集を行うインスタンスを生成
    	SimpleDateFormat  sdf = new SimpleDateFormat("yyyy'年'MM'月'dd'日 'HH'時'mm'分'ss'秒'");
        Date  date = new Date();
        Bundle extras=getIntent().getExtras();
        String buttonkind = "不明";
        if (extras!=null) {
        	buttonkind = extras.getString("ButtonKind");
        }
        textView1.setText(buttonkind + "を記録しました。" + "\n緯度：" + latitude + "\n経度：" + longitude + "\n時刻：" + sdf.format(date));

        OBSdb_DAO dao = new OBSdb_DAO(this);
        DB_Location_DTO dto = new DB_Location_DTO();
        dto.setAddtime(sdf.format(date));
        dto.setAddflg(buttonkind);
        dto.setLatitude(latitude);
        dto.setLongitude(longitude);
        dao.insert(dto);
    };
}
