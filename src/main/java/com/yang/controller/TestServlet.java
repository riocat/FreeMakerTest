package com.yang.controller;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/10.
 */
public class TestServlet extends HttpServlet {

    private Configuration cfg;

    @Override
    public void init() throws ServletException {
        super.init();
        cfg = new Configuration();
        cfg.setServletContextForTemplateLoading(this.getServletContext(), null);
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        Template t = cfg.getTemplate("/WEB-INF/ftl/helloworld.ftl");
        PrintWriter out = response.getWriter();
        Map<String, String> dataModel = new HashMap<String, String>();
        dataModel.put("name", "allen");
        try {
            t.process(dataModel, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
