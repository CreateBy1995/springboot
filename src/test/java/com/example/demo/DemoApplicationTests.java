package com.example.demo;

import com.example.demo.beans.ConditionBean;
import org.aopalliance.intercept.MethodInterceptor;
import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class DemoApplicationTests {
    @Test
    public void testObjenesis() {
        // 一个没有无参构造函数的类
        Class<NoContructBean> clazz = NoContructBean.class;
        try {
            // 使用反射的机制实例化，会报错
            NoContructBean noContructBean = clazz.newInstance();
            System.out.println(noContructBean.getName());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        // 而使用Objenesis则会无需通过构造函数来创建
        Objenesis objenesis = new ObjenesisStd();
        ObjectInstantiator<NoContructBean> objectInstantiator = objenesis.getInstantiatorOf(NoContructBean.class);
        NoContructBean noContructBean = objectInstantiator.newInstance();
        System.out.println(noContructBean.getName());
    }

    @Test
    public void testAccessible() {
        Class<ConditionBean> conditionBeanClass = ConditionBean.class;
        try {
            Method method = conditionBeanClass.getDeclaredMethod("ok1");
            method.invoke(conditionBeanClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testLucene() {
        Directory dir = new RAMDirectory();
        IndexWriter indexWriter = null;
        // 1. 创建 Directory (索引存放位置)，这里是参数dir

        // 2. 创建IndexWriter 写索引
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
        try {
            indexWriter = new IndexWriter(dir, iwc);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 3. 创建Document 对象 field
        Document document;
        File file = new File("/Users/dongcongxu/tempObj");
        for (File f : file.listFiles()) {
            document = new Document();

            // 4. 为Documen添加field
            try {
                document.add(new Field("content", FileUtils.readFileToString(f, "utf-8"), TextField.TYPE_STORED));
            } catch (IOException e) {
                e.printStackTrace();
            }
            document.add(new TextField("fileName", f.getName(), Field.Store.YES));
            document.add(new StringField("filePath", f.getAbsolutePath(), Field.Store.YES));
            // 5. 通过IndexWriter 添加文档到索引中
            try {
                indexWriter.addDocument(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
