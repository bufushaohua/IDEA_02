package com.cyc;

import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MyTest {
    @Test
    public void test(){
        /** 创建实体管理类工厂，借助Persistence的静态方法获取
         *  其中传递的参数为持久化单元名称，需要JPA配置文件中指定
         */
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
        //创建实体管理类
        EntityManager entityManager = factory.createEntityManager();
        //获取事务对象
        EntityTransaction transaction = entityManager.getTransaction();
        //开启事务
        transaction.begin();
        Customer customer = new Customer();
        customer.setCustomName("江西理工大学");
        //保存操作
        entityManager.persist(customer);
        //提交事务
        transaction.commit();
        entityManager.close();
        factory.close();
    }
}
