package com.jiker.keju;

import com.jiker.keju.IO.ReadFileOperate;
import com.jiker.keju.exception.TaxiException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.File;
import java.util.List;

public class IOTest {
    @Rule
    public ExpectedException expectedException=ExpectedException.none();
    private ReadFileOperate readFileOperate=new ReadFileOperate();
    @Test
    public void readFile_no_filepath(){
        expectedException.expect(TaxiException.class);;
        String filReaderPath="";
        List<Integer> numberList = readFileOperate.readFile(new File(filReaderPath));
    }
    @Test
    public void readFile(){
        String testDataFile="testData.txt";
        String filReaderPath="./src/main/resources/"+testDataFile;
        List<Integer> numberList = readFileOperate.readFile(new File(filReaderPath));
        Assert.assertEquals(numberList.toArray(),new Integer[]{1,0,3,0,10,0,2,3});
    }
}
