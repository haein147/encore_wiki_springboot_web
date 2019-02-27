package com.encore.wikidemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SimilarDAO {
    JdbcTemplate jdbc;

    public SimilarDAO() {
    	
       BasicDataSource ds = new BasicDataSource();
        //ds.setUrl("jdbc:mysql://13.124.239.128:3306/WIKI?autoReconnect=true&useSSL=false");
       ds.setUrl("jdbc:mysql://13.124.239.128:3306/WIKIPEDIA?autoReconnect=true&useSSL=false&characterEncoding=utf-8&useUnicode=true");
       ds.setUsername("root");
        ds.setPassword("Zez)EFQ2M:lw");
        System.out.println("=+++ 생성자-- " + ds);
        
        jdbc = new JdbcTemplate(ds);
    }

    public List<String> getSimilar(String title) {
        try {
        	List<String> List = Arrays.asList(jdbc.queryForObject("SELECT SIMILAR FROM SIMILARS WHERE TITLE=? LIMIT 1", String.class, title).split("\t")) ;
        	//System.out.println("=====" + List);
        	return List;
        } catch (Exception e) {
        	//e.printStackTrace();
            return new ArrayList<>();
            
        }
    }
}
