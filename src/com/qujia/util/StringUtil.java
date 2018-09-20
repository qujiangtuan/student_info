package com.qujia.util;

import java.util.Random;

public class StringUtil {
          public static boolean isEmpty(String str) {
                    if ("".equals(str) || str == null) {
                              return true;
                    }
                    return false;
          }

          public static boolean isEmpty(int str) {
                    if ("".equals(str)) {
                              return true;
                    }
                    return false;
          }
          public static String getRandom3() {
                    String threeNumber;
                    Random random = new Random();
                    int i = random.nextInt(1000);
                    String str = i + "";
                    if (i >= 0 && i <= 9) {
                              threeNumber = "00" + str;
                    } else if (i >= 10 && i <= 99) {
                              threeNumber = "0" + str;
                    } else {
                              threeNumber = str;
                    }
                    return threeNumber;
          }
          public static String getRandom2() {
                    String twoNumber;
                    Random random = new Random();
                    int i = random.nextInt(100);
                    String str = i + "";
                    if (i >= 0 && i <= 9) {
                              twoNumber = "0" + str;
                    } else {
                              twoNumber = str;
                    }
                    return twoNumber;
          }

}
