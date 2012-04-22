package jp.co.obs.android.AndroidHello;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;

public class AndroidHelloActivity extends Activity {

	public class Button1ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(AndroidHelloActivity.this, CompleteActivity.class);
	    	intent.putExtra("ButtonKind", "始業");
	    	startActivity(intent);
	    }
	}

	public class Button2ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(AndroidHelloActivity.this, CompleteActivity.class);
	    	intent.putExtra("ButtonKind", "移動");
	    	startActivity(intent);
	    }
	}

	public class Button3ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(AndroidHelloActivity.this, CompleteActivity.class);
	    	intent.putExtra("ButtonKind", "終業");
	    	startActivity(intent);
	    }
	}

	public class Button4ClickListener implements OnClickListener {
	    public void onClick(View v) {
	    	Intent intent = new Intent(AndroidHelloActivity.this, ReferenceActivity.class);
	    	startActivity(intent);
	    }
	}

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // ボタン1が押された時の呼び先を定義
        Button myButton1 = (Button) findViewById(R.id.button1);
        myButton1.setOnClickListener(new Button1ClickListener());

        // ボタン2が押された時の呼び先を定義
        Button myButton2 = (Button) findViewById(R.id.button2);
        myButton2.setOnClickListener(new Button2ClickListener());

        // ボタン3が押された時の呼び先を定義
        Button myButton3 = (Button) findViewById(R.id.button3);
        myButton3.setOnClickListener(new Button3ClickListener());

        // ボタン4が押された時の呼び先を定義
        Button myButton4 = (Button) findViewById(R.id.button4);
        myButton4.setOnClickListener(new Button4ClickListener());

    }
}


