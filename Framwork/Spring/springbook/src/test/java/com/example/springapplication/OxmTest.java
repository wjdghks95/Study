package com.example.springapplication;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/springapplication-applicationContext.xml")
public class OxmTest {

    @Autowired Unmarshaller unmarshaller;

    @Test
    public void unmarshallSqlMap() throws XmlMappingException, IOException {
        StreamSource xmlSource = new StreamSource(this.getClass().getResourceAsStream("/sqlmap.xml")); // InputStream을 이용하는 Source 타입의 StreamSource를 만든다.
        Sqlmap sqlmap = (Sqlmap) this.unmarshaller.unmarshal(xmlSource);// 어떤 OXM 기술이든 언마샬은 이 한 줄이면 끝이다.

        List<SqlType> sqlList = sqlmap.getSql();

        // JaxbTest와 동일하게 sqlmap.xml 파일의 내용을 정확히 가져왔는지 검사한다.
        assertThat(sqlList.size(), is(3));
        assertThat(sqlList.get(0).getKey(), is("add"));
        assertThat(sqlList.get(0).getValue(), is("insert"));
        assertThat(sqlList.get(1).getKey(), is("get"));
        assertThat(sqlList.get(1).getValue(), is("select"));
        assertThat(sqlList.get(2).getKey(), is("delete"));
        assertThat(sqlList.get(2).getValue(), is("delete"));
    }
}
