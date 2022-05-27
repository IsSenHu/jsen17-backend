package com.jsen17.commons.utils;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author HuSen
 * @since 2022/5/27 3:32 PM
 */
public class BeanCopyUtils extends BeanUtils {

    private static final Map<Class<?>, List<Field>> FIELD_CACHE = new ConcurrentHashMap<>();

    public static <T> T copy(Object source, T target) {
        if (source == null) {
            return null;
        }
        copyProperties(source, target);
        return target;
    }

    public static <T> T copyNotNull(Object source, T target) {
        if (source == null) {
            return null;
        }
        List<Field> fields = FIELD_CACHE.computeIfAbsent(source.getClass(), c -> {
            Field[] declaredFields = c.getDeclaredFields();
            Field.setAccessible(declaredFields, true);
            return Lists.newArrayList(declaredFields);
        });

        String[] ig = fields.stream().filter(field -> {
            try {
                return field.get(source) == null;
            } catch (IllegalAccessException e) {
                return false;
            }
        }).map(Field::getName).collect(Collectors.toList()).toArray(new String[]{});

        if (ig.length > 0) {
            copyProperties(source, target, ig);
        } else {
            copyProperties(source, target);
        }

        return target;
    }
}
