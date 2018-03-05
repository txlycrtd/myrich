package txl.cn.myapplication.utlis;

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
}
