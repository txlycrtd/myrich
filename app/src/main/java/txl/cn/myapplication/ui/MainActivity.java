package txl.cn.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.data.NumData;

public class MainActivity extends AppCompatActivity {
    private int[] numData;
    private List dataList;
    private NumData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        numData=new int[]{21,583,813,858,78,891,746,84,875};
        dataList=new ArrayList();
        for(int i=0;i<1000;i++){
            NumData data=new NumData(i);
            dataList.add(data);
        }
        for (int i=0;i<dataList.size();i++){
            data= (NumData) dataList.get(i);


            for(int a=0;a<numData.length;a++){

                NumData datas=new NumData(numData[a]);
                if(datas.getNumOne()==data.getNumOne()&&datas.getNumTwo()==data.getNumTwo()){
                    dataList.remove(i);
                }
                if(datas.getNumTwo()==data.getNumTwo()&&datas.getNumThree()==data.getNumThree()){
                    dataList.remove(i);
                }
                if(datas.getNumOne()==data.getNumOne()&&datas.getNumThree()==data.getNumThree()){
                    dataList.remove(i);
                }
                if(a==numData.length-1){
                    if(data.getNumOne()==10-datas.getNumOne()||data.getNumTwo()==10-datas.getNumTwo()||data.getNumThree()==10-datas.getNumThree()){
                        dataList.remove(i);
                    }
                }

            }



        }
        Log.i("还剩多少",dataList.size()+"");
        for(int b=0;b<dataList.size();b++){
            Log.i("值",((NumData)dataList.get(b)).getNum()+"");
            Log.i("和",((NumData)dataList.get(b)).getAndValue(b)+"");
            Log.i("1",((NumData)dataList.get(b)).getNumOne()+"");
            Log.i("2",((NumData)dataList.get(b)).getNumTwo()+"");
            Log.i("3",((NumData)dataList.get(b)).getNumThree()+"");
        }
    }
}
