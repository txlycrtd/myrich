package txl.cn.myapplication.utlis;

import android.util.Log;

import txl.cn.myapplication.data.NumData;

/**
 * Created by tangxl on 2018/3/1.
 */

public class NumUtils {

    public static int getNum(int num){

        if(num<10){
            String numS="00"+num;
            return stringToint(numS);
        }else if(num>10&&num<99){
            String numS="0"+num;
            return stringToint(numS);
        }else {
            return num;
        }
    }

    public static int getOneNum(int num){
        if(num<100){
            return 0;
        }else {
            return num/100;
        }
    }
    public static int getTwoNum(int num){
        if(num<10){
            return 0;
        }else if(num>9&&num<100){
            return num/10;
        }
        else {
            return (num%100)/10;
        }
    }
    public static int getThreeNum(int num){
        if(num<10){
            return num;
        }else if(num>9&&num<100){
            return num%10%10;
        }
        else {
            return num%100%10;
        }
    }
    public static String intToString(NumData num){
            return num.getNumOne()+""+num.getNumTwo()+""+num.getNumThree();
    }
    private static int stringToint(String numS){
        return Integer.parseInt(numS);
    }
    public static boolean isTwoAndSame(NumData data,NumData datas){
        if(data.getNumOne()+data.getNumTwo()==datas.getNumOne()+datas.getNumOne()){
            return true;
        }
        if(data.getNumOne()+data.getNumThree()==datas.getNumOne()+datas.getNumThree()){
            return true;
        }
        if(data.getNumTwo()+data.getNumThree()==datas.getNumTwo()+datas.getNumThree()){
            return true;
        }
        return false;
    }

    public static boolean isSizeSame(NumData data,NumData datas){

        return data.getNumSize().equals(datas.getNumSize());
    }
    public static boolean isNumSame(NumData data,NumData datas){
        if(datas.getNumOne()==data.getNumOne()&&datas.getNumTwo()==data.getNumTwo()){
           return true;
        }
        if(datas.getNumTwo()==data.getNumTwo()&&datas.getNumThree()==data.getNumThree()){
           return true;
        }
        if(datas.getNumOne()==data.getNumOne()&&datas.getNumThree()==data.getNumThree()){
          return true;
        }
        return false;
    }
    public static boolean isAndSame(NumData data,NumData datas){
        return data.getNumOne()+data.getNumTwo()+data.getNumThree()==datas.getNumOne()+datas.getNumTwo()+datas.getNumThree();
    }
    public static boolean isAndisTen(NumData data,NumData datas){
        if((data.getNumOne()+datas.getNumOne())==10){
            return true;
        }
        if((data.getNumTwo()+datas.getNumTwo())==10){
            return true;
        }
        if((data.getNumThree()+datas.getNumThree())==10){
            return true;
        }
        return false;
    }
    public static boolean isAbs(NumData data,NumData datas){
        int abs=Math.abs(data.getNumOne()-datas.getNumOne())+Math.abs(data.getNumTwo()-datas.getNumTwo())+Math.abs(data.getNumThree()-datas.getNumThree());
        if(abs<9&&abs>22){
            Log.i("删除6",NumUtils.intToString(data)+"<>"+NumUtils.intToString(datas)+"<>"+abs);
            return true;
        }
        return false;
    }
    public static int getAndValue(NumData data){
        return data.getNumOne()+data.getNumTwo()+data.getNumThree();
    }

    /**
     * 根据两期 判断波动
     * @return
     */
    public static boolean isWave(NumData data1,NumData data2,NumData data3){
        Log.i("波动",getWave(data2,data3)+data3.getNum());
        if(getWave(data1,data2).equals(getWave(data2,data3))){
            return true;
        }
        return false;
    }
    private static String getWave(NumData data,NumData datas){
        String waveOne="";
        if(datas.getNumOne()>data.getNumOne()){
            waveOne="右";
        }else if(datas.getNumOne()<data.getNumOne()){
            waveOne="左";
        }else {
            waveOne="中";
        }
        String waveTwo="";
        if(datas.getNumTwo()>data.getNumTwo()){
            waveTwo="右";
        }else if(datas.getNumTwo()<data.getNumTwo()){
            waveTwo="左";
        }else {
            waveTwo="中";
        }
        String waveThree="";
        if(datas.getNumThree()>data.getNumThree()){
            waveThree="右";
        }else if(datas.getNumThree()<data.getNumThree()){
            waveThree="左";
        }else {
            waveThree="中";
        }
        return waveOne+waveTwo+waveThree;
    }
}
