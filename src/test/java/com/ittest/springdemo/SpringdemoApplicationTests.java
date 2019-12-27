package com.ittest.springdemo;

import com.ittest.springdemo.bean.Emp;
import com.ittest.springdemo.bean.Student;
import com.ittest.springdemo.bean.User;
import com.ittest.springdemo.entities.Bill;
import com.ittest.springdemo.entities.Provider;
import com.ittest.springdemo.entities.QueryProvider;
import com.ittest.springdemo.mybatis.mapper.BillMapper;
import com.ittest.springdemo.mybatis.mapper.ProviderMapper;
import com.ittest.springdemo.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringdemoApplicationTests {
    @Autowired
    Emp emp;

    @Autowired
    Student student;

    @Autowired
    ApplicationContext context;

    //jdbc连接数据库
    @Autowired
    DataSource dataSource;

    @Autowired
    ProviderMapper providerMapper;

    @Autowired
    BillMapper billMapper;

    //邮件处理器
    @Autowired
    JavaMailSenderImpl javaMailSender;

    //添加字符串类型的redis模板
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    //添加object类型的redis模板
    @Autowired
    RedisTemplate redisTemplate;

    //object类型的redis模板，序列化器为jackson
    @Autowired
    RedisTemplate jsonRedisTemplate;

    //日志记录器
    Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void contextLoads() {
        System.out.println(emp);
    }

    @Test
    public void printStudent(){
        System.out.println(student);
    }

    @Test
    public void testxml(){
        StudentService service = context.getBean(StudentService.class);
        service.add();
    }

    @Test
    public void testConfigureBean(){
        StudentService service = (StudentService) context.getBean("studentService02");
        service.add();
    }


    /**
     * 日志级别： trace < debug < info < warn < error
     * 默认的日志级别为info
     *
     */
    @Test
    public void logTest(){
        //跟踪信息
        logger.trace("这是跟踪信息。。。");
        //调试日志
        logger.debug("这是调试日志。。。。");
        //info日志
        logger.info("这是info日志。。。。");
        //warn日志
        logger.warn("这是warn日志。。。。。");
        //error日志
        logger.error("这是error日志。。。。。");
    }

    /**
     * 测试连接数据库
     */
    @Test
    public void connectMysql() throws SQLException {
        // 默认采用的数据源连接池：com.zaxxer.hikari.HikariDataSource
        System.out.println("datasource:" + dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void addProvider(){
        Provider provider = new Provider();
        provider.setProviderCode("P_1011");
        provider.setProviderName("aaaa");
        provider.setAddress("dawdawd");
        provider.setPeople("aasaa");
        provider.setPhone("12345678");
        provider.setFax("028-15456");
        provider.setDescribe("qweqewqeqweqwe");

        int pid = providerMapper.addProvider(provider);
        System.out.println("pid=" + pid);
        System.out.println("provider的pid=" + provider.getPid());

    }

    @Test
    public void queryBypids(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        QueryProvider queryProvider = new QueryProvider();
        queryProvider.setIdlist(list);
        List<Provider> providerlist = providerMapper.getProviderByIdList1(queryProvider);
        for (Provider provider : providerlist){
            System.out.println(provider);
        }
    }

    @Test
    public void queryBypids02(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Provider> providerlist = providerMapper.getProviderByIdList2(list);
        for (Provider provider : providerlist){
            System.out.println(provider);
        }
    }

    @Test
    public void queryByBid(){
        Bill bill1 = billMapper.getBillByBid(1);
        System.out.println(bill1);
    }

    @Test
    public void addBill(){
        Bill bill = new Bill();
        bill.setBillCode("B_006");
        bill.setBillName("xx服务");
        bill.setBillCom("年");
        bill.setBillNum(10);
        bill.setMoney(5000d);
        bill.setPay(0);
        Provider provider = new Provider();
        provider.setPid(10);
        bill.setProvider(provider);
        billMapper.addBill(bill);
    }

    @Test
    public void updateBill(){
        Bill bill = new Bill();
        bill.setBid(6);
        bill.setBillCode("B_006");
        bill.setBillName("xx服务");
        bill.setBillCom("年");
        bill.setBillNum(30);
        bill.setMoney(5500.0);
        bill.setPay(0);
        Provider provider = new Provider();
        provider.setPid(6);
        bill.setProvider(provider);
        billMapper.updateBill(bill);
    }

    @Test
    public void getProviderBills(){
        List<Provider> providerBills = providerMapper.getProviderBills();
        for(Provider provider : providerBills){
            System.out.println(provider);
        }
    }

    @Test
    public  void getBills(){
        Bill bill = new Bill();
        bill.setProvider(new Provider());
        billMapper.getBills(bill);
    }


    //测试发送邮件
    @Test
    public void testSendSimpleMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        //设置主题
        message.setSubject("测试邮件");
        //设置内容
        message.setText("简单的文字的邮件内容。。。。。");
        //设置发送人
        message.setFrom("602011385@qq.com");
        //设置接收人
        message.setTo("caoyp@chinawyny.com");
        javaMailSender.send(message);
    }

    //发送复杂邮件
    @Test
    public void testMimeMail() throws MessagingException {
        //创建复杂类型的邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //通过消息帮助对象来设置发送内容，第二个参数为true,才可以发送邮件
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

        messageHelper.setSubject("复杂类型邮件");
        messageHelper.setText("<h2 style='color:red'>这是一个复杂类型的邮件</h2>",true);
        //添加附件
//        messageHelper.addAttachment("1.jpg",new File("sendmail.jpg"));
        messageHelper.setFrom("602011385@qq.com");
        messageHelper.setTo("caoyp@chinawyny.com");
        javaMailSender.send(mimeMessage);
    }


    //redis处理字符串类型的数据
    @Test
    public void testStringRedis(){

        //设置字符串的值
        stringRedisTemplate.opsForValue().set("job","QA");
        //设置list
        stringRedisTemplate.opsForList().leftPush("like","basketball");
        stringRedisTemplate.opsForList().leftPushAll("like","football","swing");
        //设置set
        stringRedisTemplate.opsForSet().add("set","one","two","three","one");
        //设置zset
        stringRedisTemplate.opsForZSet().add("zset","one",1);
        stringRedisTemplate.opsForZSet().add("zset","two",2);
        stringRedisTemplate.opsForZSet().add("zset","three",3);

        stringRedisTemplate.opsForHash().put("hash","aaaa","123456");
    }

    //redis处理object数据类型
    @Test
    public void testObjectRedis(){
        User user = new User();
        user.setName("张三");
        user.setGender(0);
        //存储对象时，对象必须实现序列化接口（因为redisTemplate中默认使用了jdk序列化）
//        redisTemplate.opsForValue().set("user",user);

        //使用自定义的对象序列化redisTemplate
        jsonRedisTemplate.opsForValue().set("user01",user);
    }

}

