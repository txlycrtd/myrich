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

    private String getNumOneSize() {
        return getNumOne() < 4 ? "小" : "大";
    }

    private String getNumTwoSize() {
        return getNumTwo() < 4 ? "小" : "大";
    }

    private String getNumThreeSize() {
        return getNumThree() < 4 ? "小" : "大";
    }

    public String getNumSize() {
        return getNumOneSize() + getNumTwoSize() + getNumThreeSize();
    }

    public NumData(int num) {
        this.num = NumUtils.getNum(num);
        this.numOne = NumUtils.getOneNum(num);
        this.numTwo = NumUtils.getTwoNum(num);
        this.numThree = NumUtils.getThreeNum(num);
    }
}
