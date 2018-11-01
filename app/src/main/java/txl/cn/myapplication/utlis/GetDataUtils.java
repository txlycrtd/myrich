package txl.cn.myapplication.utlis;

import android.util.Log;

import txl.cn.myapplication.data.NumData;

/**
 * 作者：tangxl on 2018/9/27 16:04
 */
public class GetDataUtils {
    public static boolean getData(NumData data, NumData datas, NumData datass) {
        boolean isOk;
        isOk = NumUtils.isAndSame(datas, datass);
        Log.i("aaaaa0", isOk + "" + datass.getNum());
        if (isOk) {

            isOk = NumUtils.isKD(datas, datass);
            Log.i("aaaaa1", isOk + "" + datass.getNum());

        }
        if (isOk) {
            isOk = NumUtils.isSizeSame(datas, datass);
            if (!isOk) {
                isOk = NumUtils.isDSSame(datas, datass);
            }
            Log.i("aaaaa2", isOk + "" + datass.getNum());
        }
        if (isOk) {
            isOk = NumUtils.isWave(data, datas, datass);
            Log.i("aaaaa3", isOk + "" + datass.getNum());
        }
        if (isOk) {
            isOk = NumUtils.getK(datass) > 0;
            Log.i("aaaaa4", isOk + "" + datass.getNum());
        }
        if (isOk) {

            isOk = NumUtils.isDSSame(datas, datass);
            if (!isOk) {
                isOk = NumUtils.isSizeSame(datas, datass);
            }
            Log.i("aaaaa5", isOk + "" + datass.getNum());
        }

        return isOk;
    }

    public static boolean getDatas(NumData data,NumData numData, NumData numDatas) {
        boolean isOk = false;
        int isSame = 0;
        if (numData.getNumOneDS().equals(numDatas.getNumOneDS())) {
            isSame++;
        }
        if (numData.getNumTwoDS().equals(numDatas.getNumTwoDS())) {
            isSame++;
        }
        if (numData.getNumThreeDS().equals(numDatas.getNumThreeDS())) {
            isSame++;
        }
        if (numData.getNumOneSize().equals(numDatas.getNumOneSize())) {
            isSame++;
        }
        if (numData.getNumTwoSize().equals(numDatas.getNumTwoSize())) {
            isSame++;
        }
        if (numData.getNumThreeSize().equals(numDatas.getNumThreeSize())) {
            isSame++;
        }
        if ((isSame >1&&isSame<5)) {
            isOk = true;

        }
       double abAbs=Math.abs(data.getNumOne()-numData.getNumOne())+Math.abs(data.getNumTwo()-numData.getNumTwo())
               +Math.abs(data.getNumThree()-numData.getNumThree());
        double bcAbs=Math.abs(numDatas.getNumOne()-numData.getNumOne())+Math.abs(numDatas.getNumTwo()-numData.getNumTwo())
                +Math.abs(numDatas.getNumThree()-numData.getNumThree());
        double ac=(abAbs+bcAbs)/2;
        if(
                ac<5||ac>12
                ){
            isOk=false;
        }

        
//        if(isOk){
//            isOk=NumUtils.isAndSame(numData,numDatas);
//        }
//        if(isOk){
//            isOk=NumUtils.isKD(numData,numDatas);
//        }
//        if (isOk) {
//            isOk = NumUtils.getK(numDatas) > 0;
//        }
//        if (isOk) {
//            Log.i("什么什么啊", numDatas.numStr() + "<>" + numData.getNum());
//
//
//
//            if (
//                        numDatas.numStr().contains(numData.numStrOne()) && numDatas.numStr().contains(numData.numStrTwo())
//                                || numDatas.numStr().contains(numData.numStrOne()) && numDatas.numStr().contains(numData.numStrThree())
//                                || numDatas.numStr().contains(numData.numStrTwo()) && numDatas.numStr().contains(numData.numStrThree())
//                        ) {
//                    isOk = false;
//
//
//
//            }
//
//
//        }

        return isOk;
    }
}
