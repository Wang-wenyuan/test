package com.wwy;

import com.wwy.dao.TdareaInf;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;

public class MyMain {
    public static void main(String[] args) throws IOException, TemplateException {
        TdareaInf tdareaInf = new TdareaInf();
        //List list = tdareaInf.getProvince();
        List list = tdareaInf.getDistrict();
        Freemarker freemarker = new Freemarker();
        freemarker.createFtl(list);
    }
}
