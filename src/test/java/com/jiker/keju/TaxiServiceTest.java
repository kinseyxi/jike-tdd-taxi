package com.jiker.keju;

import com.jiker.keju.service.TaxiService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class TaxiServiceTest {
    TaxiService taxiService;
    @Before
    public void init(){
        String filReaderPath="./src/main/resources/testData.txt";
        taxiService = new TaxiService(new File(filReaderPath));

    }
    @Test
    public void create(){
        org.junit.Assert.assertNotNull(taxiService);
    }
    @Test
    public void pay(){
        String receipt=taxiService.pay();
        Assert.assertTrue(receipt.length()>0);
    }
}
