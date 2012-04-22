package jp.co.obs.android.AndroidHello;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OBS_DB_Helper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "OBSdb";
	private static final int DATABASE_VERSION = 1;
	private static OBS_DB_Helper dbConnection;

	//　データベースアクセスを一元管理する為のシングルトン関数
	public static OBS_DB_Helper getInstance(Context context){
		if(dbConnection == null) dbConnection = new OBS_DB_Helper(context);
		return dbConnection ;
	}

    // DATABASE名称のゲッター定義
	public String getDataBaseName() {
		return DATABASE_NAME;
	}

	//　コンストラクタ定義
	public OBS_DB_Helper(Context context) {
		// 第1PRM：決まり文句
		// 第2PRM：データベース名称ここでは「OBS_db」
		// 第3PRM：用途がよく分からないらしい、とりあえずnull
		// 第4PRM：DBのバージョン、とりあえず1
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // table create
        db.execSQL(
            "create table location(      " +
            "   addtime   text not null, " +    // 日付時刻
            "   addflg    text,          " +    // 始業　移動　終業
            "   latitude  text,          " +    // 緯度
            "   longitude text           " +    // 経度
            ");"
        );
    }
}

