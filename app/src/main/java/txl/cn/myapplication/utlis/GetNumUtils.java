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
     * 10次历史记录的最大值
     */
    private int maxCount;

    public GetNumUtils(List<DbData> daList,Context contexts) {
        this.dbDataList = daList;
        this.context=contexts;
        numDataList = new ArrayList<>();
        oneNumList = new ArrayList<>();
        twoNumList = new ArrayList<>();
        threeNumList = new ArrayList<>();
        lawDataList = new ArrayList<>();
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
            }
            if(oneNumList.size() <10&&i==numDataList.size()-1){
                Toast.makeText(context,"数据不够",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        for (int i = 0; i < numDataList.size(); i++) {
            if (!twoNumList.contains(numDataList.get(i).getNumTwo())) {
                twoNumList.add(numDataList.get(i).getNumTwo());
            }
            if (twoNumList.size() == 10) {
                maxCount = maxCount > i ? maxCount : i;
                break;
            }
            if(twoNumList.size() <10&&i==numDataList.size()-1){
                Toast.makeText(context,"数据不够",Toast.LENGTH_SHORT).show();
                return;
            }
        }
        for (int i = 0; i < numDataList.size(); i++) {
            if (!threeNumList.contains(numDataList.get(i).getNumThree())) {
                threeNumList.add(numDataList.get(i).getNumThree());
            }
            if (threeNumList.size() == 10) {
                maxCount = maxCount > i ? maxCount : i;
                break;
            }

            if(threeNumList.size() <10&&i==numDataList.size()-1){
                Toast.makeText(context,"数据不够",Toast.LENGTH_SHORT).show();
                return;
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
    public List<String> getDataLaw() {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int i = maxCount + 1; i < dbDataList.size(); i++) {
            DbData dbData = dbDataList.get(i);
            NumData historyData = new NumData(dbData.getNum());
            NumData lawData = setHistoryDataList(historyData);
            lawDataList.add(lawData);
        }

        Log.e("排列数据", maxCount + "??" + dbDataList.size());
        Log.e("排列0",new Gson().toJson(oneNumList));
        Log.e("排列0",new Gson().toJson(twoNumList));
        Log.e("排列0",new Gson().toJson(threeNumList));
        List onesList = oneNumList;
        List twosList = twoNumList;
        List threesList = threeNumList;

        for (int i = 0; i < lawDataList.size(); i++) {
            NumData data = lawDataList.get(i);

            Log.e("排列数据" + i, "号码:" + dbDataList.get(maxCount + 1 + i).getNum() + ">>>>" + "排列:" + data.numStr() + ">>>>" +
                    data.getNumDS() + ">>>>" + data.getNumSize() + ">>>>和值:" + (data.getNumOne() + data.getNumTwo() + data.getNumThree())

            );
            if (i == lawDataList.size() - 2 || i == lawDataList.size() - 1) {
                ones = ones + data.getNumOne();
                twos = twos + data.getNumTwo();
                threes = threes + data.getNumThree();
            }

        }
        Log.e("排列2",new Gson().toJson(onesList));
        Log.e("排列2",new Gson().toJson(twosList));
        Log.e("排列2",new Gson().toJson(threesList));
        if (onesList.size() == 10) {
            if (ones < 10) {
                onesList.remove(0);
                onesList.remove(0);
            } else if (ones > 10) {
                onesList.remove(onesList.size() - 1);
                onesList.remove(onesList.size() - 1);
            } else {
                onesList.remove(0);
                onesList.remove(onesList.size() - 1);
            }
        }

        if (twosList.size() == 10) {
            if (twos < 10) {
                twosList.remove(0);
                twosList.remove(0);
            } else if (twos > 10) {
                twosList.remove(twosList.size() - 1);
                twosList.remove(twosList.size() - 1);
            } else {
                twosList.remove(0);
                twosList.remove(twosList.size() - 1);
            }
        }
        if (threesList.size() == 10) {
            if (threes <10) {
                threesList.remove(0);
                threesList.remove(0);
            } else if (threes > 10) {
                threesList.remove(threesList.size() - 1);
                threesList.remove(threesList.size() - 1);
            } else {
                threesList.remove(0);
                threesList.remove(threesList.size() - 1);
            }
        }
        List<String> dataList = new ArrayList<>();
        dataList.add(new Gson().toJson(onesList));
        dataList.add(new Gson().toJson(twosList));
        dataList.add(new Gson().toJson(threesList));
        Log.e("排列值:",ones+">>"+twos+">>"+threes);
        Log.e("排列3",new Gson().toJson(onesList));
        Log.e("排列3",new Gson().toJson(twosList));
        Log.e("排列3",new Gson().toJson(threesList));
        return dataList;
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
