import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IDEA 2019
 * author:bdqn kgc zhou qi chao
 * Date:2020/10/19
 * Time:14:53
 */
public class TestMyBatis {

    private SqlSession sqlSession;

    /**
     * 在~~之前
     */
    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testGetCount(){

        Object selectOne = sqlSession.selectOne("cn.bdqn.mybatis.mapper.UserMapper.getCount");
        System.out.println(selectOne);
    }

    /**
     * 在~~之后
     */
    @After
    public void after(){
        sqlSession.close();
    }


}
