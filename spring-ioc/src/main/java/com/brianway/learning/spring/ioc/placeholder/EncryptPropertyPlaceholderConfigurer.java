package com.brianway.learning.spring.ioc.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by brian on 16/6/22.
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
    private String[] encryptPropNames = {"userName", "password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }

    /**
     * 判断是否是加密的属性
     *
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptPropNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
