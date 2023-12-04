package com.fyd.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class TestDom4j {
    @Test
    public void testDead() throws DocumentException {
        // 读取jdbc.xml配置文件，获取document对象
        SAXReader saxReader = new SAXReader();
        // 通过类加载器获得指向字节码根路径下的指定文件的输入流
        InputStream resourceAsStream = TestDom4j.class.getClassLoader().getResourceAsStream("jdbc.xml");
        // 通过输入流获得配置文件，解析成一个dom对象
        Document document = saxReader.read(resourceAsStream);
        // 从document对象上获取配置文件中的信息
        /*
        * Element 元素结点
        * Attribute 属性结点
        * Text  文本结点
        * */
        Element rootElement = document.getRootElement();
        System.out.println(rootElement.getName());
        // 获取元素下的子元素
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            System.out.println("\t" + element.getName());
            // 获取属性
            Attribute idattribute = element.attribute("id");
            System.out.println("\t\t" + idattribute.getName() + ":" + idattribute.getValue());
            // 继续读取子元素
            List<Element> subElements = element.elements();
            for (Element subElement : subElements) {
                System.out.println("\t\t" + subElement.getName() + ":" + subElement.getText());
            }
        }

    }
}
