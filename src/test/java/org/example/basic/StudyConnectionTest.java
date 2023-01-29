package org.example.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudyConnectionTest {

    @Test
    public void getInstanceTest(){
        Assertions.assertNotNull(StudyConnection.getInstance());
    }

    @Test
    public void getUriInstanceTest(){
        Assertions.assertNotNull(StudyConnection.getUriInstance());
    }
}
