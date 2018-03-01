package txl.cn.myapplication.utlis;

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
        if(num<100){
            return 0;
        }else {
            return (num%100)/10;
        }
    }
    public static int getThreeNum(int num){
        if(num<100){
            return 0;
        }else {
            return num%100%10;
        }
    }
    private static String intToString(int num){
            return num+"";
    }
    private static int stringToint(String numS){
        return Integer.parseInt(numS);
    }
}
