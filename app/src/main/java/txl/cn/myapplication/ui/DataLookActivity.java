package txl.cn.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import txl.cn.myapplication.R;
import txl.cn.myapplication.adapter.MyAdapter;
import txl.cn.myapplication.db.DBManager;
import txl.cn.myapplication.utlis.GetDataUtils;
import txl.cn.myapplication.utlis.GetNumUtils;
import txl.cn.myapplication.utlis.NumUtils;

public class DataLookActivity extends AppCompatActivity {
    private RecyclerView dataList;

    public DBManager getManager() {
        return manager;
    }

    private DBManager manager;
    private Button btStart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        initView();
    }

    private void initView() {
        manager=new DBManager(this);
        dataList=findViewById(R.id.rv_list);
        btStart=findViewById(R.id.bt_start);
        dataList.setLayoutManager(new LinearLayoutManager(this));
        dataList.setAdapter(new MyAdapter(this,manager.queryDta()));
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetNumUtils utils=new GetNumUtils(manager.queryDta());
                utils.getDataLaw();
            }
        });
    }
}
