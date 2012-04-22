package jp.co.obs.android.AndroidHello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.List;

public class ReferenceActivity extends Activity {

	public class Button6ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(ReferenceActivity.this, AndroidHelloActivity.class);
	    	startActivity(intent);
	    }
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reference);

        // ボタン6が押された時の呼び先を定義
        Button myButton6 = (Button) findViewById(R.id.button6);
        myButton6.setOnClickListener(new Button6ClickListener());

        OBSdb_DAO dao = new OBSdb_DAO(this);
        List<DB_Location_DTO> list_dto = new ArrayList<DB_Location_DTO>();;
        dao.select(list_dto);

    	TextView textView2 = (TextView)findViewById(R.id.textView2);
    	textView2.setText("");

        for ( int i = 0; i < list_dto.size(); ++i ) {
        	DB_Location_DTO dto = list_dto.get(i);
        	String addtime = dto.getAddtime();
            String buttonkind = dto.getAddflg();
            String latitude = dto.getLatitude();
            String longitude = dto.getLongitude();
            textView2.append("データ " + String.valueOf( i+1 ) +
            		         "\n種別：" + buttonkind +
            		         "\n緯度：" + latitude +
            		         "\n経度：" + longitude +
            		         "\n時刻：" + addtime + "\n\n");
        }

    };
}
