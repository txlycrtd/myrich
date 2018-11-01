package txl.cn.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.data.DbData;
import txl.cn.myapplication.data.NumData;
import txl.cn.myapplication.db.DBManager;
import txl.cn.myapplication.utlis.GetDataUtils;
import txl.cn.myapplication.utlis.NumUtils;

public class MainActivity extends AppCompatActivity {
    private EditText edOne,edTwo;
    private int numOne,numTwo;
    private Button btGo,btGoto;
    private NumData numData,numDatas;
    private List<NumData> data,datas;
    private DBManager dbManager;
    private int numNa=0;
    private TextView tvNumCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
      edOne=findViewById(R.id.et_one);
//      edTwo=findViewById(R.id.et_two);
      btGo=findViewById(R.id.bt_go);
      btGoto=findViewById(R.id.bt_golook);
      tvNumCount=findViewById(R.id.tv_numcount);
      data=new ArrayList<>();
      datas=new ArrayList<>();
      dbManager=new DBManager(this);
        if(dbManager.queryDta().size()>0){
            numNa=dbManager.queryDta().size();
        }
        if(numNa>0){
            tvNumCount.setVisibility(View.VISIBLE);
            tvNumCount.setText("共"+numNa+"条数据");
        }else {
            tvNumCount.setVisibility(View.GONE);
        }

      btGo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getDatas();
          }
      });
      btGoto.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(MainActivity.this,DataLookActivity.class));
          }
      });
    }
    private void getDatas(){
        if(edOne.getText().toString().isEmpty()||edOne.getText().toString().length()!=3){
            Toast.makeText(this,"输入不合法",Toast.LENGTH_SHORT).show();
           return;
        }

        int input=Integer.parseInt(edOne.getText().toString());
        DbData dbData=new DbData();
        dbData.setNumCount(numNa);
        dbData.setNum(input);
        dbManager.addNum(dbData);
        numNa++;
        edOne.setText("");
        tvNumCount.setVisibility(View.VISIBLE);
        tvNumCount.setText("共"+numNa+"条数据");
        Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
        Log.i("数据",dbManager.queryDta().toString());
    }
    private void getData() {
        data.clear();
        for(int i=0;i<1000;i++){
            NumData nuData=new NumData(i);
            Log.i("单双",nuData.getNum()+"<>"+nuData.getNumDS());
            data.add(nuData);
        }
        String oneText=edOne.getText().toString();
        String twoText=edTwo.getText().toString();
        if(null==oneText||null==twoText||oneText.isEmpty()||twoText.isEmpty()){
            Toast.makeText(this,"号码不能为空",Toast.LENGTH_LONG).show();
            return;
        }
//        if(null==twoText||twoText.isEmpty()){
//            Toast.makeText(this,"号码不能为空",Toast.LENGTH_LONG).show();
//            return;

        numOne=Integer.parseInt(oneText);
        numTwo=Integer.parseInt(twoText);
        numData=new NumData(numOne);
        numDatas=new NumData(numTwo);
        datas.clear();
        for(int i=0;i<data.size();i++){
//            if(GetDataUtils.getData(numData,numDatas,data.get(i))){
//                datas.add(data.get(i));
//            }
            if(GetDataUtils.getDatas(numData,numDatas,data.get(i))){
                datas.add(data.get(i));
            }
        }
        String string="";
        for(int i=0;i<datas.size();i++){
            if(i!=datas.size()-1){
                string=string+NumUtils.intToString(datas.get(i))+",";
            }else {
                string=string+NumUtils.intToString(datas.get(i));
            }
        }
        startActivity(InputActivity.InPutInit(this,string,datas.size()));
    }
}
