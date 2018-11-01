package txl.cn.myapplication.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME = "nums.db";
    private static final int VERSION = 1;
    public DBHelper(Context context){
        super(context, DBNAME, null, VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String stu_table="CREATE TABLE IF NOT EXISTS nums(_id integer primary key autoincrement,numcount integer ,num integer)";
        sqLiteDatabase.execSQL(stu_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS download");
        onCreate(sqLiteDatabase);
    }
}
