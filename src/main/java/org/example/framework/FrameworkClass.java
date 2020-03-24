package org.example.framework;

import org.example.annotations.After;
import org.example.annotations.Before;
import org.example.annotations.Test;
import org.example.calc.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FrameworkClass {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public void runTests(String packageWithTest) {
        List<Class<?>> classes = ClassFinder.find(packageWithTest);

        for (Class<?> testClass : classes) {
            log.info(testClass.getName());
            runTest(testClass);
        }
    }

    //
    private void runTest(Class testClass) {
        try {
            Object workObject = testClass.newInstance();
            methodBefore(workObject, testClass);
            methodTest(workObject, testClass);
            methodAfter(workObject, testClass);
        } catch (Throwable throwable) {
            log.error("Error: {}", throwable);
            log.error(throwable.getStackTrace().toString());

        }

    }

    private void methodBefore(Object workObject, Class testClass) {
        Method methodBefore = ReflectionHelper.findAnnotatedMethod(testClass, Before.class);
        ReflectionHelper.callMethod(workObject, methodBefore.getName(), methodBefore.getParameters());
        log.info("Before done");
    }

    private void methodTest(Object workObject, Class testClass) {
        Method methodTest = ReflectionHelper.findAnnotatedMethod(testClass, Test.class);
        ReflectionHelper.callMethod(workObject, methodTest.getName(), methodTest.getParameters());
        log.info("Test done");
    }

    private void methodAfter(Object workObject, Class testClass) {
        Method methodAfter = ReflectionHelper.findAnnotatedMethod(testClass, After.class);
        ReflectionHelper.callMethod(workObject, methodAfter.getName(), methodAfter.getParameters());
        log.info("After done");
    }
}
