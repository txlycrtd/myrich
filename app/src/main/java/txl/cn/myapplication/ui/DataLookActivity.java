package txl.cn.myapplication.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.adapter.MyAdapter;
import txl.cn.myapplication.data.NumData;
import txl.cn.myapplication.db.DBManager;
import txl.cn.myapplication.utlis.GetNumUtils;
import txl.cn.myapplication.utlis.NumUtils;

public class DataLookActivity extends AppCompatActivity {
    private RecyclerView dataList;

    public DBManager getManager() {
        return manager;
    }
    private List<NumData> datas;
    private List<String> okDatas;
    private DBManager manager;
    private Button btStart;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        initView();
    }

    private void initView() {
        datas=new ArrayList<>();
        okDatas=new ArrayList<>();
        for(int i=0;i<1000;i++){
            NumData data=new NumData(i);
            datas.add(data);
        }
        manager=new DBManager(this);
        dataList=findViewById(R.id.rv_list);
        btStart=findViewById(R.id.bt_start);
        dataList.setLayoutManager(new LinearLayoutManager(this));
        dataList.setAdapter(new MyAdapter(this,manager.queryDta()));
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okDatas.clear();
                GetNumUtils utils=new GetNumUtils(manager.queryDta(),DataLookActivity.this);
                for(int i=0;i<datas.size();i++){
                    if(utils.getDataLaw(datas.get(i))){
                        okDatas.add(datas.get(i).numStr());
                    }
                }

                Log.e("排列多少",okDatas.size()+"");
                String dataStr=new Gson().toJson(okDatas);
                startActivity(InputActivity.InPutInit(DataLookActivity.this,dataStr));

            }
        });
    }
}
