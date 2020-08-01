package com.liuweiwei.test;

import java.util.UUID;

import com.liuweiwei.bean.Department;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuweiwei.bean.Employee;
import com.liuweiwei.dao.DepartmentMapper;
import com.liuweiwei.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private SqlSession sqlSession;

    @Test
    public void testCRUD() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        int count = ioc.getBeanDefinitionCount();
        System.out.println(count);
        String[] names = ioc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);
        System.out.println(bean);
        Department department = bean.selectByPrimaryKey(1);
        System.out.println(department.toString());
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department1 = mapper.selectByPrimaryKey(1);
        System.out.println(department1);
        /*
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            if (i / 2 == 0) {
                String uid = UUID.randomUUID().toString().substring(0, 5) + i;
                mapper.insertSelective(new Employee(null, uid, "0", uid + "@163.com", 1));
            } else {
                String uid = UUID.randomUUID().toString().substring(0, 5) + i;
                mapper.insertSelective(new Employee(null, uid, "1", uid + "@163.com", 1));
            }
        }
        System.out.println("批量插入完成.");
        */
    }

}
