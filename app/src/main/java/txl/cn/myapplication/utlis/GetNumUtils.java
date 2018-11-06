package txl.cn.myapplication.utlis;

import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import txl.cn.myapplication.data.DbData;
import txl.cn.myapplication.data.NumData;

/**
 * 作者：tangxl on 2018/11/2 17:02
 */
public class GetNumUtils {
    private List<DbData> dbDataList;
    private List<NumData>numDataList;
    private NumData numData;
    private List<Integer> oneNumList;
    private List<Integer> twoNumList;
    private List<Integer> threeNumList;
    private List<NumData> lawDataList;
    /**
     * 10次历史记录的最大值
     */
    private int maxCount;
    public   GetNumUtils(List<DbData> daList){
        this.dbDataList=daList;
        numDataList=new ArrayList<>();
        oneNumList=new ArrayList<>();
        twoNumList=new ArrayList<>();
        threeNumList=new ArrayList<>();
        lawDataList=new ArrayList<>();
        for(DbData dbData:dbDataList){
            NumData numData=new NumData(dbData.getNum());
            numDataList.add(numData);
        }
        getHistoryData();
    }

    /**
     * 获取最大历史值和十个历史号码排序
     */
    private void getHistoryData(){
        for(int i=0;i<numDataList.size();i++){
           if(!oneNumList.contains(numDataList.get(i).getNumOne())){
               oneNumList.add(numDataList.get(i).getNumOne());
           }
           if(oneNumList.size()==10){
               maxCount=i;
               break;
           }
        }
        for(int i=0;i<numDataList.size();i++){
            if(!twoNumList.contains(numDataList.get(i).getNumTwo())){
                twoNumList.add(numDataList.get(i).getNumTwo());
            }
            if(twoNumList.size()==10){
                maxCount=maxCount>i?maxCount:i;
                break;
            }
        }
        for(int i=0;i<numDataList.size();i++){
            if(!threeNumList.contains(numDataList.get(i).getNumThree())){
                threeNumList.add(numDataList.get(i).getNumThree());
            }
            if(threeNumList.size()==10){
                maxCount=maxCount>i?maxCount:i;
                break;
            }
        }
        oneNumList.clear();
        twoNumList.clear();
        threeNumList.clear();
        for(int i=maxCount;i>-1;i--){
            if(!oneNumList.contains(numDataList.get(i).getNumOne())){
                oneNumList.add(numDataList.get(i).getNumOne());
            }
            if(!twoNumList.contains(numDataList.get(i).getNumTwo())){
                twoNumList.add(numDataList.get(i).getNumTwo());
            }
            if(!threeNumList.contains(numDataList.get(i).getNumThree())){
                threeNumList.add(numDataList.get(i).getNumThree());
            }
        }

    }

    /**
     * 十次号码后的序号
     */
    public void getDataLaw(){
        for(int i=maxCount+1;i<dbDataList.size();i++){
            DbData dbData=dbDataList.get(i);
            NumData historyData=new NumData(dbData.getNum());
            NumData lawData=setHistoryDataList(historyData);
            lawDataList.add(lawData);
        }

        Log.e("排列数据",maxCount+"??"+dbDataList.size());
        for(int i=0;i<lawDataList.size();i++){
            NumData data=lawDataList.get(i);
            Log.e("排列数据"+i,data.numStr()+">>>>"+(data.getNumOne()+data.getNumTwo()+data.getNumThree()));
        }

    }
    private NumData setHistoryDataList(NumData data){

        NumData numData=new NumData();
        for(int i=0;i<oneNumList.size();i++){
            if (oneNumList.get(i)==data.getNumOne()){
                int oneData=oneNumList.get(i);
                numData.setNumOne(i);
                oneNumList.remove(i);
                Collections.reverse(oneNumList);
                oneNumList.add(oneData);
                Collections.reverse(oneNumList);
                break;
            }
        }
        for(int i=0;i<twoNumList.size();i++){
            if (twoNumList.get(i)==data.getNumTwo()){
                int twoData=twoNumList.get(i);
                numData.setNumTwo(i);
                twoNumList.remove(i);
                Collections.reverse(twoNumList);
                twoNumList.add(twoData);
                Collections.reverse(twoNumList);
                break;
            }
        }
        for(int i=0;i<threeNumList.size();i++){
            if (threeNumList.get(i)==data.getNumThree()){
                int threeData=threeNumList.get(i);
                numData.setNumThree(i);
                threeNumList.remove(i);
                Collections.reverse(threeNumList);
                threeNumList.add(threeData);
                Collections.reverse(threeNumList);
                break;
            }
        }

        return numData;
    }
}
