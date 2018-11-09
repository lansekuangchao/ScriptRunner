package com.initsql.core.ScriptRunner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * ScriptRunner test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScriptRunnerApplicationTests {
    private static final Logger log = LoggerFactory.getLogger(ScriptRunnerApplicationTests.class);
    @Autowired
    private InitDataCalc initDataCalc;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {
        try {
            initDataCalc.init("sql/init.sql");
            log.info("..... 执行初始化sql完成 .....");
            log.info("..... 查询结果 .....");
            log.info("-----------------------------------------------------------");
            List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from api_category");
            list.forEach(ls -> log.info(ls.toString()));
            log.info("-----------------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
