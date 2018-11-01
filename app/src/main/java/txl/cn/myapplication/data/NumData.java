package txl.cn.myapplication.data;

import txl.cn.myapplication.utlis.NumUtils;

/**
 * Created by tangxl on 2018/3/1.
 */

public class NumData {
    private int num;
    private int numOne;
    private int numTwo;
    private int numThree;

    public int getNumCount() {
        return numCount;
    }

    public void setNumCount(int numCount) {
        this.numCount = numCount;
    }

    private int numCount;
    public int getNum() {
        return num;
    }

    public int getNumOne() {
        return numOne;
    }

    public int getNumTwo() {
        return numTwo;
    }

    public int getNumThree() {
        return numThree;
    }

    public String getNumOneSize() {
        return getNumOne() < 5 ? "小" : "大";
    }

    public String getNumTwoSize() {
        return getNumTwo() < 5 ? "小" : "大";
    }

    public String getNumThreeSize() {
        return getNumThree() < 5 ? "小" : "大";
    }

    public String getNumSize() {
        return getNumOneSize() + getNumTwoSize() + getNumThreeSize();
    }
    public String getNumDS(){
        return getNumOneDS()+getNumTwoDS()+getNumThreeDS();
    }
    public String getNumOneDS(){
        return getNumOne() %2==0 ? "双" : "单";
    }
    public String getNumTwoDS(){
        return getNumTwo() %2==0 ? "双" : "单";
    }
    public String getNumThreeDS(){
        return getNumThree() %2==0 ? "双" : "单";
    }
    public NumData(int num) {
        this.num = NumUtils.getNum(num);
        this.numOne = NumUtils.getOneNum(num);
        this.numTwo = NumUtils.getTwoNum(num);
        this.numThree = NumUtils.getThreeNum(num);
    }
    public String numStrOne(){
        return getNumOne()+"";
    }
    public String numStrTwo(){
        return getNumTwo()+"";
    }
    public String numStrThree(){
        return getNumThree()+"";
    }
    public String numStr(){
        if(num<10){
            return "00"+num;
        }else if(num>9&&num<100){
            return "0"+num;
        }
        return num+"";
    }

}
