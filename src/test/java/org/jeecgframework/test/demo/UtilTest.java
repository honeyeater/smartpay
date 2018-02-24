package org.jeecgframework.test.demo;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * 单元测试 抽象基类 加载配置
 * @author  许国杰
 */
public class UtilTest {

    public static void main(String[] args) {
        int a = (int)Math.random()*10000000;
        System.out.println(a);
    }
}
