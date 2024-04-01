package com.example.springapplication;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class AbstractUpdatableSqlRegistryTest {
    UpdatableSqlRegistry sqlRegistry;

    @Before
    public void setUp() {
        sqlRegistry = createUpdatableSqlRegistry();

        // 각 테스트 메소드에서 사용할 초기 SQL 정보를 미리 등록해둔다.
        sqlRegistry.registerSql("KEY1", "SQL1");
        sqlRegistry.registerSql("KEY2", "SQL2");
        sqlRegistry.registerSql("KEY3", "SQL3");
    }

    abstract protected UpdatableSqlRegistry createUpdatableSqlRegistry();

    @Test
    public void find() {
        checkFindResult("SQL1", "SQL2", "SQL3");
    }

    protected void checkFindResult(String expected1, String expected2, String expected3) {
        assertThat(sqlRegistry.findSql("KEY1"), is(expected1));
        assertThat(sqlRegistry.findSql("KEY2"), is(expected2));
        assertThat(sqlRegistry.findSql("KEY3"), is(expected3));
    }

    // 주어진 키에 해당하는 SQL을 찾을 수 없을 때 예외가 발생하는지를 확인한다.
    @Test(expected = SqlNotFoundException.class)
    public void unknownKey() {
        sqlRegistry.findSql("SQL9999!@#$");
    }

    // 하나의 SQL을 변경하는 기능에 대한 테스트다. 검증할 때는 변경된 SQL 외의 나머지 SQL은 그대로인지 확인해주는게 좋다.
    @Test
    public void updateSingle() {
        sqlRegistry.updateSql("KEY2", "Modified2");
        checkFindResult("SQL1", "Modified2", "SQL3");
    }

    @Test
    public void updateMulti() {
        HashMap<String, String> sqlmap = new HashMap<>();
        sqlmap.put("KEY1", "Modified1");
        sqlmap.put("KEY3", "Modified3");

        sqlRegistry.updateSql(sqlmap);
        checkFindResult("Modified1", "SQL2", "Modified3");
    }

    // 존재하지 않는  키의 SQL을 변경하려고 시도할 때 예외가 발생하는 것을 검증한다.
    @Test(expected = SqlUpdateFailureException.class)
    public void updateWithNotExistingKey() {
        sqlRegistry.updateSql("SQL9999!@#$", "Modified2");
    }
}
