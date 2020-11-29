package edu.alexandrov.labs.behavior;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

public interface TriggerHandler<O, T> {

    default T handleTriggers(O obj, String request) throws InvocationTargetException,
                                                           IllegalAccessException, NoSuchMethodException {
        Method requiredMethod = null;
            for(Method method : obj.getClass().getDeclaredMethods()) {
                method.setAccessible(true);
                if(method.isAnnotationPresent(TriggeredBy.class) &&
                        Arrays.asList(method.getAnnotation(TriggeredBy.class)
                        .triggers()).contains(request)) {
                    requiredMethod = method;
                }
            }
        return Optional.of((T) requiredMethod.invoke(obj))
                .orElseThrow(NoSuchMethodException::new);
    }
}
