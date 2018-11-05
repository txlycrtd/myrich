package txl.cn.myapplication.utlis;

import java.util.ArrayList;
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
    public void GetDataUtils(List<DbData> daList){
        this.dbDataList=daList;
        numDataList=new ArrayList<>();
        for(DbData dbData:dbDataList){
            NumData numData=new NumData(dbData.getNum());
            numDataList.add(numData);
        }
    }
    private void getHistoryData(){

    }

}
