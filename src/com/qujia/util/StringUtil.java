package com.qujia.util;

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

}
