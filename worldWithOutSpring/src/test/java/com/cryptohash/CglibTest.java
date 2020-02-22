package com.cryptohash;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.FixedValue;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class CglibTest {
    @Test
    public void intro_to_cglib(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Cat.class);
        Cat cat = new Cat();
        System.out.println(cat.meow());
        /*enhancer.setCallback(new FixedValue() {
            @Override
            public Object loadObject() throws Exception {
                return "meeow by cglib";
            }
        });*/
        enhancer.setCallback(new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (method.getName().equals("age")) {
                    return 10;
                }else{
                    return "something else";
                }
            }
        });
        Cat cat1 = (Cat) enhancer.create();
        System.out.println(cat1.meow());
        System.out.println(cat1.age());

    }

    public static class Cat{
        public String meow(){
            return "meeooow";
        }
        public int age(){
            return 5;
        }
    }
}
