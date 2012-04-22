package jp.co.obs.android.AndroidHello;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OBSdb_DAO {

    // DB接続のインスタンスを定義
	private static OBS_DB_Helper dbConnection;

	//　コンストラクタ定義
	public OBSdb_DAO(Context context) {
		if (dbConnection == null) dbConnection = OBS_DB_Helper.getInstance(context);
	}

	//　DBにレコードを追加する関数
	public void insert(DB_Location_DTO dto) {

		SQLiteDatabase OBSdb = dbConnection.getWritableDatabase();

		ContentValues values = new ContentValues();
        values.put("addtime", dto.getAddtime());
        values.put("addflg", dto.getAddflg());
        values.put("latitude", dto.getLatitude());
        values.put("longitude", dto.getLongitude());
		try{
			OBSdb.insert("location", null, values);
		}finally{
			OBSdb.close();
		}
	}

	//　DBからデータを取得する関数
	public void select(List<DB_Location_DTO> list_dto) {

		//　リストを初期化
		list_dto.clear();

		SQLiteDatabase OBSdb = dbConnection.getReadableDatabase();

		String sqlstr =		"select addtime,addflg,latitude,longitude " +
							"from location " +
							"order by addtime desc " +
							"limit 100";
		try{

			Cursor cursor = OBSdb.rawQuery(sqlstr,null);

			//query()またはrawQuery()の実行
			if(cursor.moveToFirst()){
				do{
					DB_Location_DTO dto = new DB_Location_DTO();
					dto.setAddtime(cursor.getString(cursor.getColumnIndex("addtime")));
					dto.setAddflg(cursor.getString(cursor.getColumnIndex("addflg")));
					dto.setLatitude(cursor.getString(cursor.getColumnIndex("latitude")));
					dto.setLongitude(cursor.getString(cursor.getColumnIndex("longitude")));
					list_dto.add(dto);
				}while(cursor.moveToNext());
			}
		}finally{
			OBSdb.close();
		}
	}

	//　最後の登録情報をDBからデータを取得する関数
	public void select_last(DB_Location_DTO loc_dto) {

		SQLiteDatabase OBSdb = dbConnection.getReadableDatabase();

		String sqlstr =		"select addtime,addflg,latitude,longitude " +
							"from location " +
							"order by addtime desc " +
							"limit 1";
		try{

			Cursor cursor = OBSdb.rawQuery(sqlstr,null);

			//query()またはrawQuery()の実行
			if(cursor.moveToFirst()){
					loc_dto.setAddtime(cursor.getString(cursor.getColumnIndex("addtime")));
					loc_dto.setAddflg(cursor.getString(cursor.getColumnIndex("addflg")));
					loc_dto.setLatitude(cursor.getString(cursor.getColumnIndex("latitude")));
					loc_dto.setLongitude(cursor.getString(cursor.getColumnIndex("longitude")));
			}
		}finally{
			OBSdb.close();
		}
	}

}
