package main.test;

import lombok.NoArgsConstructor;
import main.test.anotations.AfterSuite;
import main.test.anotations.BeforeSuite;
import main.test.anotations.Test;

import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class TestStarter {

    public static void start(Class<?> clazz) {
        checkCorrectAnnotations(clazz);
        invokeIfAnnotated(BeforeSuite.class, clazz);
        invokeInOrderIfAnnotated(Test.class, clazz);
        invokeIfAnnotated(AfterSuite.class, clazz);
    }

    private static void checkCorrectAnnotations(Class<?> clazz) {
        int beforeSuiteCount = 0;
        int afterSuiteCount = 0;

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                beforeSuiteCount++;
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                afterSuiteCount++;
            }
            if (method.isAnnotationPresent(BeforeSuite.class) && method.isAnnotationPresent(Test.class)) {
                throw new RuntimeException("Class " + clazz.getName() + " has more than one BeforeSuite or AfterSuite annotation");
            } else if (method.isAnnotationPresent(AfterSuite.class) && method.isAnnotationPresent(Test.class)) {
                throw new RuntimeException("Class " + clazz.getName() + " has more than one BeforeSuite or AfterSuite annotation");
            }
        }
        if (beforeSuiteCount > 1 || afterSuiteCount > 1) {
            throw new RuntimeException("Class " + clazz.getName() + " has more than one BeforeSuite or AfterSuite annotation");
        }
    }

    private static void invokeIfAnnotated(Class annotation, Class clazz) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                try {
                    method.setAccessible(true);
                    method.invoke(clazz.newInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void invokeInOrderIfAnnotated(Class<Test> annotation, Class clazz) {
        SortedMap<Integer, Method> methods = new TreeMap<>(Comparator.naturalOrder());
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation)) {
                methods.put(method.getAnnotation(annotation).order(), method);
            }
        }

        for (Map.Entry<Integer, Method> method : methods.entrySet()) {
            try {
                method.getValue().setAccessible(true);
                method.getValue().invoke(clazz.newInstance());
                System.out.println("\t(".concat(method.getValue().getName()).concat(")"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
