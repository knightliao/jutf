package com.github.knightliao.test.mocks;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * @author zhugongrui
 * @date 2016年6月3日
 */
public class MockUpBean<T> implements FactoryBean<T> {
    private final static Logger LOGGER = Logger.getLogger(MockUpBean.class);

    private final CglibProxy proxy = new CglibProxy();

    private Class<T> clazz;

    public MockUpBean(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T getObject() throws Exception {
        LOGGER.info(String.format("clazz=[%s] is mocked.", this.clazz));
        return getInstance();
    }

    public Class<?> getObjectType() {
        return this.clazz;
    }

    public boolean isSingleton() {
        return true;
    }

    protected T getInstance() {
        return this.proxy.getProxy(this.clazz);
    }

    private class CglibProxy implements MethodInterceptor {

        private final Enhancer enhancer = new Enhancer();

        @SuppressWarnings("unchecked")
        public T getProxy(Class<?> clazz) {
            this.enhancer.setCallback(this);
            this.enhancer.setSuperclass(clazz);
            return (T) this.enhancer.create();
        }

        public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {

            Object obj = this.invoke(arg0, arg1, arg2);
            return obj;
        }

        private Object invoke(Object arg0, Method method, Object[] args) {
            LOGGER.info(String.format("class=[%s], methond=[%s]", MockUpBean.this.clazz,
                    method.getName()));
            return null;
        }
    }
}
