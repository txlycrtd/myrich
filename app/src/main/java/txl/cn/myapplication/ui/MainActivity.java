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
    private NumData datas;
    private boolean isCanMove=false;
    private List newDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        newDataList=new ArrayList();
        numData=new int[]{401,659,810,179,749,272,992,102,664};
        dataList=new ArrayList();
        for(int i=0;i<1000;i++){
            NumData data=new NumData(i);
            dataList.add(data);
        }
        for (int i=0;i<dataList.size();i++){
            isCanMove=false;
            data= (NumData) dataList.get(i);
            if(NumUtils.isWave(new NumData(numData[7]),new NumData(numData[8]),data)){
                isCanMove=true;
            }
            for(int a=0;a<numData.length;a++){

                 datas=new NumData(numData[a]);
               if(NumUtils.isNumSame(data,datas)){
                  isCanMove=true;
                  Log.i("删除1",NumUtils.intToString(data));
               }
               if(NumUtils.isAndSame(data,datas)&&NumUtils.isSizeSame(data,datas)){
                  isCanMove=true;
                   Log.i("删除2",NumUtils.intToString(data));
               }
                if(a==numData.length-1){
//                    if(NumUtils.isAndisTen(data,datas)){
//                        isCanMove=true;
//                        Log.i("删除3",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas)+"<>"+(10-datas.getNumOne()));
//                    }
                    if(NumUtils.isTwoAndSame(data,datas)){
                       isCanMove=true;
                        Log.i("删除4",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas));
                    }
                    if(NumUtils.isSizeSame(data,datas)){
                       isCanMove=true;
                        Log.i("删除5",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas));
                    }
                    if (NumUtils.isAbs(data,datas)){
                        isCanMove=true;
                    }
                    if(NumUtils.getAndValue(data)<10||NumUtils.getAndValue(data)>20){
                        isCanMove=true;
                    }
                }

            }

            if (!isCanMove){
                Log.i("什么鬼啊",NumUtils.intToString((NumData) dataList.get(i))+"<>"+i);
//                dataList.remove(i);
                newDataList.add(dataList.get(i));
            }

        }
        Log.i("还剩多少",newDataList.size()+"");
        for(int b=0;b<newDataList.size();b++){
            Log.i("序号",b+"");
            Log.i("值",(NumUtils.intToString((NumData)newDataList.get(b))));
            Log.i("和",NumUtils.getAndValue((NumData)newDataList.get(b))+"");
            Log.i("大小",((NumData)newDataList.get(b)).getNumSize());
            Log.i("1",((NumData)newDataList.get(b)).getNumOne()+"");
            Log.i("2",((NumData)newDataList.get(b)).getNumTwo()+"");
            Log.i("3",((NumData)newDataList.get(b)).getNumThree()+"");
        }
    }
}
