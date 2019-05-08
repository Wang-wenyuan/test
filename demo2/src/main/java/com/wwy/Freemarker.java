package com.wwy;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Freemarker {
    public void createFtl(List list) throws IOException, TemplateException {
        Configuration configuration = new Configuration();

        //3、设置模板文件保存的目录
        configuration.setDirectoryForTemplateLoading(new File("D:\\javaProject\\demo\\demo2\\src\\main\\resources"));

        //4、模板文件的编码格式，一般就是utf-8
        configuration.setDefaultEncoding("utf-8");

        //5、加载一个模板文件，创建一个模板对象。
        //Template template = configuration.getTemplate("provincesql.ftl");
        Template template = configuration.getTemplate("districtsql.ftl");

        //6、创建一个数据集。可以是pojo也可以是map。推荐使用map
        Map data = new HashMap();
        //data.put("province", list);   //${test}
        //data.put("city",list);
        data.put("district",list);
        //7、创建一个Writer对象，指定输出文件的路径及文件名。
        //Writer out = new FileWriter(new File("D:/province.txt"));
        //Writer out = new FileWriter(new File("D:/city.txt"));
        Writer out = new FileWriter(new File("D:/district.txt"));

        //8、生成静态页面
        //@Param1:数据   @Param2:输出流  数据data+模板test.ftl封装到test.html
        template.process(data, out);

        //9、关闭流
        out.close();
    }
}
