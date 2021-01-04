package org.kaelbastos.Domain.entities.utils;

import java.util.Collection;

public abstract class Validator <T>{
    public abstract Notification validate(T t);

    public static boolean isNullOrEmpty(String string){
        return string == null || string.isEmpty() || string.isBlank();
    }

    public static boolean isNullOrEmpty(Collection collection){
        return collection == null || collection.isEmpty();
    }

    public static boolean isNull(Integer integer){
        return integer == null;
    }

    public static boolean isNull(Object object){return object == null;}
}
