package com.jiker.keju.service;

import com.jiker.keju.IO.ReadFileOperate;
import com.jiker.keju.util.CommonUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

public class TaxiService {
    CommonUtil commonUtil=new CommonUtil();
    String receipt="";
    private ReadFileOperate readFileOperate=new ReadFileOperate();
    public TaxiService(File file) {
        List<Integer> numberList=readFileOperate.readFile(file);
        ListIterator<Integer> iterator = numberList.listIterator();
        while (iterator.hasNext()){
            int kilo = iterator.next().intValue();
            int waitTime=0;
            if(iterator.hasNext()){
                waitTime = iterator.next().intValue();
            }
            int price = commonUtil.calculate(kilo, waitTime);
            receipt+="收费"+price+"元\n";
        }
    }

    public String pay() {
        return receipt;
    }
    public void writeFile(String fileName) throws IOException {
        File file = new File(fileName);
    }

}
