package com.jiker.keju;

import com.jiker.keju.util.CommonUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class CommonUtilTest {
    CommonUtil commonUtil;
    @Before
    public void init(){
        commonUtil=new CommonUtil();
    }
    @Test
    public void create_test(){
        Assert.assertNotNull(commonUtil);
    }
    @Test
    public void getNumberByMatcher(){
        String str="1公里,等待0分钟";
        List<Integer> numberList= commonUtil.getNumberByMatcher(str);
        Assert.assertEquals(numberList.toArray(),new Integer[]{1,0});
    }
    @Test
    public void getNumberByMatcher_1(){
        String str="20公里,等待50分钟";
        List<Integer> numberList= commonUtil.getNumberByMatcher(str);
        Assert.assertEquals(numberList.toArray(),new Integer[]{20,50});
    }
    @Test
    public void calculate_kilo_le_2_and_wait_0(){
        int price= commonUtil.calculate(1,0);
        Assert.assertEquals(price,6);

    }
    @Test
    public void calculate_kilo_ne_2__and_wait_3(){
        int price= commonUtil.calculate(2,3);
        Assert.assertEquals(price,7);

    }
    @Test
    public void calculate_kilo_le_8_and_wait_0(){
        int price= commonUtil.calculate(3,0);
        Assert.assertEquals(price,7);

    }
    @Test
    public void calculate_kilo_ge_8_and_wait_0(){
        int price= commonUtil.calculate(10,0);
        Assert.assertEquals(price,13);

    }


}

