package com.tu.mongodb.test;

import com.alibaba.fastjson.JSON;
import com.tu.mongodb.MongoStudyApplication;
import com.tu.mongodb.entity.Person;
import com.tu.mongodb.entity.Student;
import com.tu.mongodb.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author tu
 * @date 2022-11-11 15:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MongoStudyApplication.class)
public class TestApi {

    private final Logger logger = LoggerFactory.getLogger(TestApi.class);
    @Resource
    private PersonRepository personRepository;


    /**
     * 用于测试: insert
     */
    @Test
    public void test_insert() {
        Person entity = new Person("王五", 20, "123321200201011113");

        Person person = personRepository.save(entity);
        logger.info("测试结果: {}", JSON.toJSONString(person));

    }

    /**
     * 用于测试: 保存一个子类信息
     */
    @Test
    public void test_save_children() {
        Person student = new Student("赵六", 20, "123321200201021114", "01010102");
        Person person = personRepository.save(student);
        logger.info("测试结果: {} ", person);
    }


    /**
     * 用于测试:获取一个子类信息
     */
    @Test
    public void test_query_children() {
        String idNumber = "123321200201021111";
        Student student = personRepository.findByIdNumber(idNumber, Student.class);
        logger.info("测试结果: {}",JSON.toJSONString(student));
    }

    /**
     * 用于测试:获取一条记录
     */
    @Test
    public void test_query() {
        String idNumber = "123321200201021114";
        Student student = personRepository.findByIdNumber(idNumber,Student.class);
        logger.info("查询结果 absent 是否为 Student 类: {}", student instanceof Student);
        logger.info("测试结果: {}",JSON.toJSONString(student));
    }
}
