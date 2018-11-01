package txl.cn.myapplication.utlis;

import android.util.Log;

import txl.cn.myapplication.data.NumData;

/**
 * Created by tangxl on 2018/3/1.
 */

public class NumUtils {

    public static int getNum(int num) {

        if (num < 10) {
            String numS = "00" + num;
            return stringToint(numS);
        } else if (num > 10 && num < 99) {
            String numS = "0" + num;
            return stringToint(numS);
        } else {
            return num;
        }
    }

    public static int getOneNum(int num) {
        if (num < 100) {
            return 0;
        } else {
            return num / 100;
        }
    }

    public static int getTwoNum(int num) {
        if (num < 10) {
            return 0;
        } else if (num > 9 && num < 100) {
            return num / 10;
        } else {
            return (num % 100) / 10;
        }
    }

    public static int getThreeNum(int num) {
        if (num < 10) {
            return num;
        } else if (num > 9 && num < 100) {
            return num % 10 % 10;
        } else {
            return num % 100 % 10;
        }
    }

    public static String intToString(NumData num) {
        return num.getNumOne() + "" + num.getNumTwo() + "" + num.getNumThree();
    }

    private static int stringToint(String numS) {
        return Integer.parseInt(numS);
    }

    //大小组合相同或者相反
    public static boolean isSizeSame(NumData data, NumData datas) {

        if (data.getNumSize().equals("大大大")) {
            if (datas.getNumSize().equals("小小小") || datas.getNumSize().equals("大大大")) {
                return false;
            }
        } else if (data.getNumSize().equals("大小小")) {
            if (datas.getNumSize().equals("大小小") || datas.getNumSize().equals("小大大")) {
                return false;
            }
        } else if (data.getNumSize().equals("大大小")) {
            if (datas.getNumSize().equals("小小大") || datas.getNumSize().equals("大大小")) {
                return false;
            }
        } else if (data.getNumSize().equals("小小小")) {
            if (datas.getNumSize().equals("小小小") || datas.getNumSize().equals("大大大")) {
                return false;
            }
        } else if (data.getNumSize().equals("小小大")) {
            if (datas.getNumSize().equals("大大小") || datas.getNumSize().equals("小小大")) {
                return false;
            }
        } else if (data.getNumSize().equals("小大大")) {
            if (datas.getNumSize().equals("大小小") || datas.getNumSize().equals("小大大")) {
                return false;
            }
        } else if (data.getNumSize().equals("大小大")) {
            if (datas.getNumSize().equals("小大小") || datas.getNumSize().equals("大小大")) {
                return false;
            }
        } else if (data.getNumSize().equals("小大小")) {
            if (datas.getNumSize().equals("小大小") || datas.getNumSize().equals("大小大")) {
                return false;
            }
        }
        return true;
    }

    //单双相同或相反
    public static boolean isDSSame(NumData data, NumData datas) {

        if (data.getNumDS().equals("单单单")) {
            if (datas.getNumDS().equals("单单单") || datas.getNumDS().equals("双双双")) {
                return false;
            }
        } else if (data.getNumDS().equals("单双单")) {
            if (datas.getNumDS().equals("单双单") || datas.getNumDS().equals("双单双")) {
                return false;
            }
        } else if (data.getNumDS().equals("单单双")) {
            if (datas.getNumDS().equals("单单双") || datas.getNumDS().equals("双双单")) {
                return false;
            }
        } else if (data.getNumDS().equals("单双双")) {
            if (datas.getNumDS().equals("单双双") || datas.getNumDS().equals("双单单")) {
                return false;
            }
        } else if (data.getNumDS().equals("双双双")) {
            if (datas.getNumDS().equals("双双双") || datas.getNumDS().equals("单单单")) {
                return false;
            }
        } else if (data.getNumDS().equals("双单双")) {
            if (datas.getNumDS().equals("双单双") || datas.getNumDS().equals("单双单")) {
                return false;
            }
        } else if (data.getNumDS().equals("双双单")) {
            if (datas.getNumDS().equals("双双单") || datas.getNumDS().equals("单单双")) {
                return false;
            }
        } else if (data.getNumDS().equals("双单单")) {
            if (datas.getNumDS().equals("双单单") || datas.getNumDS().equals("单双双")) {
                return false;
            }
        }
        return true;
    }

    /**
     * 和值
     *
     * @param data
     * @param datas
     * @return
     */
    public static boolean isAndSame(NumData data, NumData datas) {

        return getAndValue(data) != getAndValue(datas);
    }


    /**
     * 跨度
     *
     * @param data
     * @param datas
     * @return
     */
    public static boolean isKD(NumData data, NumData datas) {
        if (getK(data) == getK(datas)) {
            return false;
        }
        return true;
    }

    private static int getAndValue(NumData data) {
        Log.i("哪一个", data.getNum() + "<>" + data.getNumOne() + "<>" + data.getNumTwo() + "<>" + data.getNumThree());
        return data.getNumOne() + data.getNumTwo() + data.getNumThree();
    }

    /**
     * 根据两期 判断波动
     *
     * @return
     */
    public static boolean isWave(NumData data1, NumData data2, NumData data3) {
        Log.i("波动", getWave(data2, data3) + data3.getNum());
        if (getWave(data1, data2).equals(getWave(data2, data3))) {
            return false;
        }
        return true;
    }

    private static String getWave(NumData data, NumData datas) {
        String waveOne = "";
        if (datas.getNumOne() > data.getNumOne()) {
            waveOne = "右";
        } else if (datas.getNumOne() < data.getNumOne()) {
            waveOne = "左";
        } else {
            waveOne = "中";
        }
        String waveTwo = "";
        if (datas.getNumTwo() > data.getNumTwo()) {
            waveTwo = "右";
        } else if (datas.getNumTwo() < data.getNumTwo()) {
            waveTwo = "左";
        } else {
            waveTwo = "中";
        }
        String waveThree = "";
        if (datas.getNumThree() > data.getNumThree()) {
            waveThree = "右";
        } else if (datas.getNumThree() < data.getNumThree()) {
            waveThree = "左";
        } else {
            waveThree = "中";
        }
        return waveOne + waveTwo + waveThree;
    }

    public static int getK(NumData date) {
        int kd = 0;
        int one = Math.abs(date.getNumOne() - date.getNumTwo());
        int two = Math.abs(date.getNumOne() - date.getNumThree());
        int three = Math.abs(date.getNumTwo() - date.getNumThree());
        if (one >= two && one >= three) {
            kd = one;
        } else if (two >= three && two >= one) {
            kd = two;
        } else if (three >= one && three >= two) {
            kd = three;

        }
        Log.i("跨度", kd + ">>" + date.getNum() + "" + ">>" + one + ">" + two + ">" + three);
        return kd;
    }
}
