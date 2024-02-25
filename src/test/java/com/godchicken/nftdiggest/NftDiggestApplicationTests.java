package com.godchicken.nftdiggest;

import com.godchicken.nftdiggest.core.crawler.UbanQuanCrawler;
import com.godchicken.nftdiggest.core.entity.GoodsPageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NftDiggestApplicationTests {

    @Autowired
    private UbanQuanCrawler ubanQuanCrawler;

    @Test
    void contextLoads() {
        String one = "lab father";
        String two = "until exercise crouch";
        String three = "olive water pass";
        String four = "cluster violin cart steel";

        String[] list = new String[]{"1234","1243","1324","1342","1423","1432","2134","2143","2314","2341","2413","2431","3124","3142","3214","3241","3412","3421","4123","4132","4231","4213","4312","4321"};

        for(int i =0; i < list.length; i++){
            String x = list[i];
            char[] chars = x.toCharArray();
            String res = "";
            for(char a : chars){
                if(a == '1'){
                    res = res + one + " ";
                }
                if(a == '2'){
                    res = res + two + " ";
                }
                if(a == '3'){
                    res = res + three + " ";
                }
                if(a == '4'){
                    res = res + four + " ";
                }
            }
            System.out.println(res);
        }

    }

}
