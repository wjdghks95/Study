package com.example.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
    SimpleJdbcTemplate simpleJdbcTemplate;
    SimpleJdbcInsert simpleJdbcInsert;
    SimpleJdbcCall simpleJdbcCall;

    public void setDataSource(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    // DAO 초기화 작업
    @Autowired
    public void init(DataSource dataSource) {
        this.simpleJdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("member");// 테이블 이름을 지정한다.
//                .withSchemaName("") // 스키마 이름을 지정한다.
//                .withCatalogName("") // 카탈로그 이름을 지정한다.
//                .usingColumns("name", "id") // 원하는 컬럼만 insert 하도록 지정한다.
//                .usingGeneratedKeyColumns() // 자동 생성 키 컬럼을 지정한다. 지정된 컬럼은 INSERT 문에서 제외된다.
//                .withoutTableColumnMetaDataAccess() // DB에서 테이블 메타데이터를 가져오지 않도록 만든다.

        this.simpleJdbcCall = new SimpleJdbcCall(dataSource)
                .withFunctionName("find_name"); // 실행할 펑션의 이름을 지정한다.
//                .withProcedureName() // 실행할 프로시저 이름을 지정한다.
//                .returningResultSet() // 프로시저가 ResultSet을 돌려주는 경우 이를 RowMapper를 이용해 매핑해준다.
    }

    // SQL 실행 메소드
    // INSERT, UPDATE, DELETE
    public void sqlExecute() {
        // SQL 파라미터
        // varargs, Map, MapSqlParameterSource, BeanPropertySqlParameterSource

        // varargs
        simpleJdbcTemplate.update("INSERT INTO MEMBER(ID, NAME, POINT) VALUES (:id, :name, :point)", 1, "Spring", 3.5);

        // Map
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "Spring");
        map.put("point", 3.5);
        simpleJdbcTemplate.update("INSERT INTO MEMBER(ID, NAME, POINT) VALUES (:id, :name, :point)", map);

        // MapSqlParameterSource
        MapSqlParameterSource mapParams = new MapSqlParameterSource()
                .addValue("id", 1)
                .addValue("name", "Spring")
                .addValue("point", 3.5);
        simpleJdbcTemplate.update("INSERT INTO MEMBER(ID, NAME, POINT) VALUES (:id, :name, :point)", mapParams);

        // BeanPropertySqlParameterSource
        Member member = new Member(1, "Spring", 3.5);
        BeanPropertySqlParameterSource beanParams = new BeanPropertySqlParameterSource(member);
        simpleJdbcTemplate.update("INSERT INTO MEMBER(ID, NAME, POINT) VALUES (:id, :name, :point)", beanParams);
    }

    // SQL 조회 메소드
    // SELECT
    public Object sqlSelect(int min, int id, int point) {
        // queryForInt : 하나의 int 타입 값 조회
        int count = simpleJdbcTemplate.queryForInt("SELECT count(*) FROM MEMBER");
        simpleJdbcTemplate.queryForInt("SELECT count(*) FROM MEMBER WHERE point > :min", new MapSqlParameterSource("min", min));

        // queryForLong : 하나의 long 타입 값 조회
        simpleJdbcTemplate.queryForLong("SELECT count(*) FROM MEMBER WHERE point > :min", new MapSqlParameterSource("min", min));

        // queryForObject : 쿼리를 실행해서 하나의 값 조회, 결과 타입 지정
        try {
            String name = simpleJdbcTemplate.queryForObject("SELECT name FROM MEMBER WHERE id = ?", String.class, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

        // queryForObject(RowMapper<t>) : 쿼리를 실행해서 하나의 로우 조회, 다중 컬럼을 가진 쿼리에 사용
        Member member = simpleJdbcTemplate.queryForObject("SELECT * FROM MEMBER WHERE id = ?", new BeanPropertyRowMapper<Member>(Member.class), id);

        // query : 여러 개의 컬럼을 가진 여러 개의 로우를 조회
        List<Member> members = simpleJdbcTemplate.query("SELECT * FROM MEMBER WHERE point > ?", new BeanPropertyRowMapper<Member>(Member.class), point);

        // queryForMap : 하나의 로우 조회, 맵의 키에는 컬럼 이름이 들어가고 값에는 컬럼의 값이 저장된다.
        Map<String, Object> map = simpleJdbcTemplate.queryForMap("SELECT * FROM MEMBER WHERE id = ?", id);

        // queryForList : queryForMap의 다중 로우 버전이다.
        List<Map<String, Object>> maps = simpleJdbcTemplate.queryForList("SELECT * FROM MEMBER WHERE id = ?", id);

        return null;
    }

    // SQL 배치 메소드
    public void sqlBatch() {
        // batchUpdate
        simpleJdbcTemplate.batchUpdate("UPDATE MEMBER SET name = :name WHERE id = :id",
                new SqlParameterSource[] {
                        new MapSqlParameterSource().addValue("id", 1).addValue("name", "Spring3"),
                        new BeanPropertySqlParameterSource(new Member(2, "Book3"))
                });
    }

    // SimpleJdbcInsert
    public void simpleJdbcInsert() {
        Member member = new Member(1, "Spring", 3.5);
        this.simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(member)); // 실행

        this.simpleJdbcInsert.withCatalogName("register").usingGeneratedKeyColumns("id");
        int key = this.simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(member)).intValue();// 실행 및 자동생성 키 값을 Number 타입으로 반환

        this.simpleJdbcInsert.withCatalogName("register").usingGeneratedKeyColumns("id", "name");
        this.simpleJdbcInsert.executeAndReturnKeyHolder(new BeanPropertySqlParameterSource(member));// 실행 및 하나 이상의 자동생성 키 값을 KeyHolder 타입으로 반환
    }

    // SimpleJdbcCall
    public void simpleJdbcCall(int id) {
        String ret = this.simpleJdbcCall.executeFunction(String.class, id); // 저장 펑션을 실행
    }
}
