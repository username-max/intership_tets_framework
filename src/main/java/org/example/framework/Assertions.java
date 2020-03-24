package org.example.framework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assertions {

    private static final Logger log = LoggerFactory.getLogger(Assertions.class);

    private String value;

    public Assertions(String value) {
        this.value = value;
    }

    public boolean assertEquals(String value) {
        if (this.value.equals(value)) {
            log.info("The test is correct");
        } else {
            log.info("Test Failed:");
            log.info("Expected: " + this.value);
            log.info("Got result: " + value);
        }
        return this.value.equals(value);
    }

    public boolean assertTrue() {
        if (this.value.equals("true")) {
            log.info("The test is correct");
        } else {
            log.info("Test Failed:");
            log.info("Expected: " + true);
            log.info("Got result: " + this.value);
        }
        return this.value.equals("true");
    }


    public boolean assertNotNull() {
        if (!this.value.equals("null")) {
            log.info("The test is correct");
        } else {
            log.info("Test Failed: got result is null");
        }
        return this.value.equals("null");
    }

    public static Assertions assertThat(Object resultFoo) {
        return new Assertions(String.valueOf(resultFoo));
    }
}
