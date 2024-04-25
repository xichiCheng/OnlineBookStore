package utils;

import org.apache.commons.beanutils.BeanUtils;
import pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class WebUtils {
    public static Object copyParamToBean(HttpServletRequest req,Object bean){

        try {
            BeanUtils.populate(bean,req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bean;
    }
}
