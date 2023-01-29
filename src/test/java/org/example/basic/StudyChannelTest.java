package org.example.basic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StudyChannelTest {

    @Test
    public void getInstanceTest() throws InterruptedException {
        Assertions.assertNotNull(StudyChannel.getInstance());
    }
}
