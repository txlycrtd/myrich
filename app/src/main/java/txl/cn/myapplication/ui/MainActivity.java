package txl.cn.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import txl.cn.myapplication.R;
import txl.cn.myapplication.data.NumData;
import txl.cn.myapplication.utlis.NumUtils;

public class MainActivity extends AppCompatActivity {
    private int[] numData;
    private List dataList;
    private NumData data;
    private boolean isCanMove=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        numData=new int[]{021,583,813,858,78,891,746,84,875};
        dataList=new ArrayList();
        for(int i=0;i<1000;i++){
            NumData data=new NumData(i);
            dataList.add(data);
        }
        for (int i=0;i<dataList.size();i++){
            isCanMove=false;
            data= (NumData) dataList.get(i);

            for(int a=0;a<numData.length;a++){

                NumData datas=new NumData(numData[a]);
               if(NumUtils.isNumSame(data,datas)){
                  isCanMove=true;
                  Log.i("删除1",NumUtils.intToString(data));
               }
               if(NumUtils.isAndSame(data,datas)&&NumUtils.isSizeSame(data,datas)){
                  isCanMove=true;
                   Log.i("删除2",NumUtils.intToString(data));
               }
                if(a==numData.length-1){
                    if(data.getNumOne()==10-datas.getNumOne()||data.getNumTwo()==10-datas.getNumTwo()||data.getNumThree()==10-datas.getNumThree()){
                        isCanMove=true;
                        Log.i("删除3",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas)+"<>"+(10-datas.getNumOne()));
                    }
                    if(NumUtils.isTwoAndSame(data,datas)){
                       isCanMove=true;
                        Log.i("删除4",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas));
                    }
                    if(NumUtils.isSizeSame(data,datas)){
                       isCanMove=true;
                        Log.i("删除5",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas));
                    }
                }

            }

            if (isCanMove){
                Log.i("什么鬼啊",NumUtils.intToString((NumData) dataList.get(i)));
                dataList.remove(i);
            }

        }
        Log.i("还剩多少",dataList.size()+"");
        for(int b=0;b<dataList.size();b++){

            Log.i("值",(NumUtils.intToString((NumData)dataList.get(b))));
            Log.i("和",((NumData)dataList.get(b)).getAndValue(b)+"");
            Log.i("大小",((NumData)dataList.get(b)).getNumSize());

            Log.i("1",((NumData)dataList.get(b)).getNumOne()+"");
            Log.i("2",((NumData)dataList.get(b)).getNumTwo()+"");
            Log.i("3",((NumData)dataList.get(b)).getNumThree()+"");
        }
    }
}
