//
// �� ������ JAXB(JavaTM Architecture for XML Binding) ���� ���� 2.2.8-b130911.1802 ������ ���� �����Ǿ����ϴ�. 
// <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>�� �����Ͻʽÿ�. 
// �� ������ �����ϸ� �ҽ� ��Ű���� ���������� �� ���� ������ �սǵ˴ϴ�. 
// ���� ��¥: 2024.03.23 �ð� 10:24:41 AM KST 
//


package com.example.springapplication;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the springbook.com.example.springapplication.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: springbook.com.example.springapplication.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sqlmap }
     * 
     */
    public Sqlmap createSqlmap() {
        return new Sqlmap();
    }

    /**
     * Create an instance of {@link SqlType }
     * 
     */
    public SqlType createSqlType() {
        return new SqlType();
    }

}
