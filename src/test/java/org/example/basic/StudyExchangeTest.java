package org.example.basic;

import org.junit.jupiter.api.Test;

public class StudyExchangeTest {

    @Test
    public void exchangeDeclareTest(){
        StudyExchange.exchangeDeclare("wang.chang.sheng", "topic", true, false, false, null);
    }

    @Test
    public void exchangeDeclareNoWaitTest(){
        StudyExchange.exchangeDeclareNoWait("wcs", "fanout", true, false, false, null);
    }

    @Test
    public void exchangeDeclarePassiveTest(){
        StudyExchange.exchangeDeclarePassive("wcs");
    }

    @Test
    public void exchangeDeleteTest(){
        StudyExchange.exchangeDelete("wang.chang.sheng", false);
    }

    @Test
    public void exchangeDeleteNoWaitTest(){
        StudyExchange.exchangeDeleteNoWait("wcs", false);
    }
}
