package com.forever.mybatisPlus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.forever.mybatisPlus.model.User;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 代码生成器演示
 * </p>
 */
public class MpGenerator {

    private GlobalConfig gc; //全局配置
    private AutoGenerator mpg; //mp的generator

    public MpGenerator() {
        gc = new GlobalConfig();
        mpg = new AutoGenerator();
    }


    @Test
    public void test() {
        User user = new User().setAge(15).setId(1).setName("张三");
        System.out.println(user);
    }


    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */

    @Test
    public void testGenerate() {
        setGenerator(); //配置生成
        configDataSource();   //配置数据源
        configStrategy();      // 策略配置
        configPackage();      // 包配置
        configInjection();  // 配置....
        configTemplate(); //配置生成的文件哪些不生成
        mpg.execute();  // 执行生成
    }


    private void setGenerator() {
        // 选择 freemarker 引擎，默认 Veloctiy
        // mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        gc.setFileOverride(true); //设置文件覆盖 (默认为false)
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false (默认为true)
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("Forever丶诺");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sDao"); //设置Mapper的类名  默认XXXMapper
        // gc.setXmlName("%sDao");
        // gc.setServiceName("%sService");      //默认 I+XXX+Service
        // gc.setServiceImplName("%sServiceDiy"); //默认 XXXServiceImpl
        // gc.setControllerName("%sAction"); //默认后缀是Controller
        //gc.setOutputDir("D://"); //设置文件的输出目录  (默认"D://");
        // gc.setKotlin(true); //是否生成 kotlin 代码 (默认为false)


        mpg.setGlobalConfig(gc);
    }

    private void configInjection() {
        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
  /*      focList.add(new FileOutConfig("/template/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return "D://my_" + tableInfo.getEntityName() + ".jsp";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);*/

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
    }

    private void configStrategy() {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setEntityLombokModel(true);//
        strategy.setTablePrefix(new String[]{"tlog_", "tsys_"});// 此处可以修改为您的表前缀

        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"user"}); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表

        // 自定义实体父类
        // strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
        // 自定义实体，公共字段
        // strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");

        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);
    }

    private void configDataSource() {
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        // dsc.setDbType(DbType.MYSQL);
/*        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });*/

        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("");
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis"); //设置链接数据库的四大属性
        mpg.setDataSource(dsc);
    }


    /**
     * 配置包名
     *
     * @param :
     * @Author: Forever丶诺
     * @Date: 17:04 2018/2/9
     */
    private void configPackage() {
        mpg.setPackageInfo(new PackageConfig().setParent("com.baomidou").setModuleName("test").setEntity("model").setMapper("dao").setXml("dao.xml").setController("controller"));
    }


    /**
     * 配置模板的生成文件
     *
     * @param :
     * @Author: Forever丶诺
     * @Date: 17:20 2018/2/9
     */
    private void configTemplate() {
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        //tc.setEntity("");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);
    }


}