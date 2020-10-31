import all.mapper.BlogMapper;
import all.pojo.Blog;
import all.utils.IdUtils;
import all.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test01(){
        for (int i = 0; i < 5; i++) {
            System.out.println(IdUtils.getId());
        }
    }
    @Test
    public void test02() {

        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("哈哈哈");
        blog.setCreatTime(new Date());
        blog.setViews(8888);

        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("SpringMVC");
        mapper.addBlog(blog);

        sqlSession.commit();

        sqlSession.close();
    }
    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","Java");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }


    @Test
    public void test04(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();

        //choose和switch case同理！！！ 满足第一个条件时，后面条件不再执行，都不满足执行otherwise
//        map.put("title","Java");
        map.put("author","哈哈哈");
        map.put("views",8888);
        List<Blog> blogs = mapper.queryBlogChoose(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }


    @Test
    public void test05(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("author","嘿嘿嘿");
        map.put("title","JavaJavaJava");
        map.put("id","6fe17509.0297.4e75.ba00.ec4d2579ec11");
        mapper.updateBlog(map);
        sqlSession.commit();
        sqlSession.close();
    }
}
