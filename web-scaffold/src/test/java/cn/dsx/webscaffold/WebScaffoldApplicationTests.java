package cn.dsx.webscaffold;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * 单元测试继承该类即可
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebScaffoldApplication.class)
@Transactional
@Rollback
class WebScaffoldApplicationTests {

    @Test
    void contextLoads() {
    }

}
