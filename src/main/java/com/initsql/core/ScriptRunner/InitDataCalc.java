package com.initsql.core.ScriptRunner;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Description(初始化连接并执行sql文件)
 * author: Gao Xueyong
 */
@Service
public class InitDataCalc {
    private static final Logger log = LoggerFactory.getLogger(InitDataCalc.class);


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void init(String sqlFilePath) throws SQLException, IOException {
        log.info("..... start init .....");
        exceteSqlFile(sqlFilePath,jdbcTemplate.getDataSource().getConnection());
        log.info("..... end init .....");
    }

    /**
     * 执行sql文件
     * @param filePath
     * @param conn
     * @throws IOException
     * @throws SQLException
     */
    public void exceteSqlFile(String filePath,Connection conn) throws IOException, SQLException {
        ScriptRunner runner = new ScriptRunner(conn);
        Resources.setCharset(Charset.forName("UTF-8"));
        runner.setLogWriter(null);//设置是否输出日志
        runner.runScript(Resources.getResourceAsReader(filePath));
        runner.closeConnection();
        conn.close();
    }
}
