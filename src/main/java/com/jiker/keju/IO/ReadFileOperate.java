package com.jiker.keju.IO;

import com.jiker.keju.exception.TaxiException;
import com.jiker.keju.util.CommonUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFileOperate {
    CommonUtil commonUtil=new CommonUtil();
    public List<Integer> readFile(File file) {
        List<Integer> numberList=new ArrayList<>();
        if(file==null || file.length()<1){
            throw new TaxiException("文件不存在");
        }
        FileReader fr=null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!=null){
                if(!line.trim().equals("")){
                    List<Integer> numberByMatcher = commonUtil.getNumberByMatcher(line);
                    numberList.addAll(numberByMatcher);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return numberList;
    }
}
