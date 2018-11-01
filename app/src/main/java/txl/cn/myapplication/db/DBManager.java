package txl.cn.myapplication.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import txl.cn.myapplication.data.DbData;


public class DBManager  {
    private DBHelper dbhelper;
    private SQLiteDatabase db;
    private Context context;
    public DBManager(Context contexts){
        this.context=contexts;
        dbhelper = new DBHelper(context);
        if (db == null) {
            db = dbhelper.getWritableDatabase();
        }

    }
    public void addNum(DbData data){
        ContentValues cv = new ContentValues();
        cv.put("numcount", data.getNumCount());
        cv.put("num", data.getNum());
        db.insert("nums", null, cv);
    }
    public void deleteNum(int numCount){
        String [] nums={numCount+""};
        db.delete("nums","numcount=?",nums);
    }

    public List<DbData> queryDta() {
        List<DbData> dataList = new ArrayList();
        Cursor c = db.rawQuery("SELECT * FROM nums", null);
        while (c.moveToNext()) {
            DbData data=new DbData();
            data.setNum(c.getInt(c.getColumnIndex("num")));
            data.setNumCount(c.getInt(c.getColumnIndex("numcount")));
            dataList.add(data);
        }
        c.close();
        return dataList;
    }
    public void updataData(DbData data){
        ContentValues cv = new ContentValues();
        String[] ids = {data.getNumCount()+""};
        cv.put("numcount",data.getNumCount());
        cv.put("nums",data.getNum());
        db.update("nums",cv,"numcount=?",ids);
    }
}
