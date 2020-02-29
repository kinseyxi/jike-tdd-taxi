package com.jiker.keju.util;

import com.jiker.keju.exception.TaxiException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    public List<Integer> getNumberByMatcher(String str) {
        List<Integer> numberList=new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String strNumber = matcher.group();
            Integer number = null;
            try {
                number = Integer.valueOf(Integer.parseInt(strNumber));
            } catch (NumberFormatException e) {
                throw new TaxiException("String转换int异常");
            }
            numberList.add(number);
        }
        return numberList;
    }

    public  int calculate(int kilo, int waitTime) {
        int price=0;
        float waitPrice= (float) (0.25*waitTime);
        if(kilo<=2){
            price = (int) Math.round(6 + waitPrice);
        }
        if(kilo>2 && kilo<=8){
            price= (int) Math.round(6+(kilo-2)*0.8+waitPrice);
        }
        if(kilo>8){
            price= (int) Math.round(10.8+(kilo-8)*1.2+waitPrice);
        }
        return price;
    }
}
