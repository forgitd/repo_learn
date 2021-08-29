package com.keqi;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

// 代码自动生成器
public class AutoCode {
    public static void main(String[] args) {
        // 需要构建一个代码自动生成器
        AutoGenerator mpg = new AutoGenerator();

        // 1 全局配置
        GlobalConfig gc = new GlobalConfig();
        // 获取当前项目路径，设置输出路径
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("keqi");
        gc.setOpen(false);            // 是否打开资源管理器 （windows文件夹）
        gc.setFileOverride(false);    // 是否覆盖
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        mpg.setGlobalConfig(gc);

        // 2 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("yiing123");
        dsc.setDbType(DbType.MYSQL);
        mpg.setDataSource(dsc);

        // 3 包的配置
        PackageConfig pc = new PackageConfig();
        pc.setModuleName("test");
        pc.setParent("com.keqi");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setController("controller");
        pc.setService("service");
        mpg.setPackageInfo(pc);

        // 4 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("user");    // 要自动生成的表
        sc.setNaming(NamingStrategy.underline_to_camel); //下划线转驼峰
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);

        // 设置逻辑删除
        sc.setLogicDeleteFieldName("deleted");
        // 设置自动填充
        TableFill creatTime = new TableFill("creat_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time",FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> list = new ArrayList<>();
        list.add(creatTime);
        list.add(updateTime);
        sc.setTableFillList(list);
        // 乐观锁
        sc.setVersionFieldName("version");
        mpg.setStrategy(sc);

        mpg.execute();

    }
}
