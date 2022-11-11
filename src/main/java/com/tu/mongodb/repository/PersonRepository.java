package com.tu.mongodb.repository;

import com.tu.mongodb.entity.Person;
import com.tu.mongodb.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author tu
 * @description Person 类 Mongodb 持久层
 */
@Repository
public interface PersonRepository extends MongoRepository<Person,Long> {


    /**
     * 根据 ID 获取
     * @param idNumber 身份证号
     * @param t 返回值类型
     * @return 返回值
     * @param <T> {@link Person} 的子类
     */
    <T extends Person> T findByIdNumber(String idNumber,Class<T> t);

    /**
     * 根据 ID 获取
     * @param idNumber 身份证号
     * @return 返回值
     */
    Person findByIdNumber(String idNumber);

}
