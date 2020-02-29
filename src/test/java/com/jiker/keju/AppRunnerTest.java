package com.jiker.keju;

import org.junit.Test;

public class AppRunnerTest {
    AppRunner appRunner=new AppRunner();
    @Test
    public void main(){
      appRunner.main(new String[]{"testData.txt"});
    }
}
