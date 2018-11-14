package txl.cn.myapplication.utlis;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import txl.cn.myapplication.data.DbData;
import txl.cn.myapplication.data.NumData;

/**
 * 作者：tangxl on 2018/11/2 17:02
 */
public class GetNumUtils {
    private List<DbData> dbDataList;
    private List<NumData> numDataList;
    private NumData numData;
    private List<Integer> oneNumList;
    private List<Integer> twoNumList;
    private List<Integer> threeNumList;
    private List<NumData> lawDataList;
    private Context context;
    /**
     * 上两次的排列数据
     */
    private List<Integer> lawData;
    /**
     * 上两次的中奖数据
     */
    private List<Integer> lawNumData;
    /**
     * 10次历史记录的最大值
     */
    private int maxCount;

    public GetNumUtils(List<DbData> daList, Context contexts) {
        this.dbDataList = daList;
        this.context = contexts;
        numDataList = new ArrayList<>();
        oneNumList = new ArrayList<>();
        twoNumList = new ArrayList<>();
        threeNumList = new ArrayList<>();
        lawDataList = new ArrayList<>();
        lawData=new ArrayList<>();
        lawNumData=new ArrayList<>();
        for (DbData dbData : dbDataList) {
            NumData numData = new NumData(dbData.getNum());
            numDataList.add(numData);
        }
        getHistoryData();
    }

    /**
     * 获取最大历史值和十个历史号码排序
     */
    private void getHistoryData() {
        for (int i = 0; i < numDataList.size(); i++) {
            if (!oneNumList.contains(numDataList.get(i).getNumOne())) {
                oneNumList.add(numDataList.get(i).getNumOne());
            }
            if (oneNumList.size() == 10) {
                maxCount = i;
                break;
            } else if (oneNumList.size() < 10 && i == numDataList.size() - 1) {
                Toast.makeText(context, "数据不够", Toast.LENGTH_SHORT).show();
            }
        }
        for (int i = 0; i < numDataList.size(); i++) {
            if (!twoNumList.contains(numDataList.get(i).getNumTwo())) {
                twoNumList.add(numDataList.get(i).getNumTwo());
            }
            if (twoNumList.size() == 10) {
                maxCount = maxCount > i ? maxCount : i;
                break;
            } else if (twoNumList.size() < 10 && i == numDataList.size() - 1) {
                Toast.makeText(context, "数据不够", Toast.LENGTH_SHORT).show();
            }
        }
        for (int i = 0; i < numDataList.size(); i++) {
            if (!threeNumList.contains(numDataList.get(i).getNumThree())) {
                threeNumList.add(numDataList.get(i).getNumThree());
            }
            if (threeNumList.size() == 10) {
                maxCount = maxCount > i ? maxCount : i;
                break;
            } else if (threeNumList.size() < 10 && i == numDataList.size() - 1) {
                Toast.makeText(context, "数据不够", Toast.LENGTH_SHORT).show();
            }

        }
        oneNumList.clear();
        twoNumList.clear();
        threeNumList.clear();
        for (int i = maxCount; i > -1; i--) {
            if (!oneNumList.contains(numDataList.get(i).getNumOne())) {
                oneNumList.add(numDataList.get(i).getNumOne());
            }
            if (!twoNumList.contains(numDataList.get(i).getNumTwo())) {
                twoNumList.add(numDataList.get(i).getNumTwo());
            }
            if (!threeNumList.contains(numDataList.get(i).getNumThree())) {
                threeNumList.add(numDataList.get(i).getNumThree());
            }
        }

    }

    /**
     * 十次号码后的序号
     */
    public Boolean getDataLaw(NumData datas) {
        this.numData = datas;
        boolean isOk = true;

        for (int i = maxCount + 1; i < dbDataList.size(); i++) {
            DbData dbData = dbDataList.get(i);
            NumData historyData = new NumData(dbData.getNum());
            NumData lawDatass = setHistoryDataList(historyData);
            lawDataList.add(lawDatass);
        }

        Log.e("排列数据", maxCount + "??" + dbDataList.size());
        Log.e("排列0", new Gson().toJson(oneNumList));
        Log.e("排列0", new Gson().toJson(twoNumList));
        Log.e("排列0", new Gson().toJson(threeNumList));
        List<Integer> onesList = oneNumList;
        List<Integer> twosList = twoNumList;
        List<Integer> threesList = threeNumList;

        for (int i = 0; i < lawDataList.size(); i++) {
            NumData data = lawDataList.get(i);
            if(i==lawDataList.size()-1||i==lawDataList.size()-2){
                lawData.add(data.getNumOne());
                lawData.add(data.getNumTwo());
                lawData.add(data.getNumThree());
            }
            if ((maxCount + i + 1) < dbDataList.size()) {
                Log.e("排列数据" + i, "号码:" + dbDataList.get(maxCount + 1 + i).getNum() + ">>>>" + "排列:" + data.numStr() + ">>>>" +
                        data.getNumDS() + ">>>>" + data.getNumSize() + ">>>>和值:" + (data.getNumOne() + data.getNumTwo() + data.getNumThree())

                );
            }


        }
        /**
         * 只含2以下 8以上
         */
        int one,one1,two,two1,three,three1;
        int one2,one3,two2,two3,three2,three3;
        int numOne,numTwo,numThree;
        one=onesList.get(0);
        one1=onesList.get(1);
        one2=onesList.get(8);
        one3=onesList.get(9);
        two=twosList.get(0);
        two1=twosList.get(1);
        two2=twosList.get(8);
        two3=twosList.get(9);
        three=threesList.get(0);
        three1=threesList.get(1);
        three2=threesList.get(8);
        three3=threesList.get(9);
        numOne=numData.getNumOne();
        numTwo=numData.getNumTwo();
        numThree=numData.getNumThree();
        if(((numOne==one||numOne==one1)&&(numTwo==two||numTwo==two1))
                ||((numOne==one||numOne==one1)&&(numThree==three||numThree==three1))
                ||((numTwo==two||numTwo==two1)&&(numThree==three||numThree==three1))
                ){
            isOk=false;
        }
        if(((numOne==one2||numOne==one3)&&(numTwo==two2||numTwo==two3))
                ||((numOne==one2||numOne==one3)&&(numThree==three2||numThree==three3))
                ||((numTwo==two2||numTwo==two3)&&(numThree==three2||numThree==three3))
                ){
            isOk=false;
        }
//        NumData data=new NumData(dbDataList.get(dbDataList.size()-1).getNum());
//        NumData data2=new NumData(dbDataList.get(dbDataList.size()-2).getNum());
//        lawNumData.add(data.getNumOne());
//        lawNumData.add(data.getNumTwo());
//        lawNumData.add(data.getNumThree());
//        lawNumData.add(data2.getNumOne());
//        lawNumData.add(data2.getNumTwo());
//        lawNumData.add(data2.getNumThree());
        NumData lawDatas=setHistoryDataList(numData);
//        if((lawNumData.contains(numData.getNumOne())&&(lawNumData.contains(numData.getNumTwo())&&lawNumData.contains(numData.getNumThree())
//        ||(!lawNumData.contains(numData.getNumOne())&&(!lawNumData.contains(numData.getNumTwo())&&!lawNumData.contains(numData.getNumThree()))))))
//        {
//            isOk=false;
//        }
        if((lawData.contains(lawDatas.getNumOne())&&(lawData.contains(lawDatas.getNumTwo())&&lawData.contains(lawDatas.getNumThree())
                ||(!lawData.contains(lawDatas.getNumOne())&&(!lawData.contains(lawDatas.getNumTwo())&&!lawData.contains(lawDatas.getNumThree()))))))
        {
            isOk=false;
        }


        return isOk;
    }

    private NumData setHistoryDataList(NumData data) {

        NumData numData = new NumData();
        for (int i = 0; i < oneNumList.size(); i++) {
            if (oneNumList.get(i) == data.getNumOne()) {
                int oneData = oneNumList.get(i);
                numData.setNumOne(i);
                oneNumList.remove(i);
                Collections.reverse(oneNumList);
                oneNumList.add(oneData);
                Collections.reverse(oneNumList);
                break;
            }
        }
        for (int i = 0; i < twoNumList.size(); i++) {
            if (twoNumList.get(i) == data.getNumTwo()) {
                int twoData = twoNumList.get(i);
                numData.setNumTwo(i);
                twoNumList.remove(i);
                Collections.reverse(twoNumList);
                twoNumList.add(twoData);
                Collections.reverse(twoNumList);
                break;
            }
        }
        for (int i = 0; i < threeNumList.size(); i++) {
            if (threeNumList.get(i) == data.getNumThree()) {
                int threeData = threeNumList.get(i);
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

