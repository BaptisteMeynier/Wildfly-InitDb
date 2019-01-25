package com.javaee8.rest;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ApplicationScoped
public class DatabaseInitialiser {

    @Resource(lookup = "java:jboss/datasources/ExampleDS")
    private DataSource bookDatasource;

    @Produces
    public DataSource construct() {
        return bookDatasource;
    }
/*
    @PostConstruct
    private void init() throws SQLException, IOException {
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("insert.sql");
        BufferedReader in = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line;
        while ((line = in.readLine()) != null) {
            try (Connection con = bookDatasource.getConnection();
                 PreparedStatement ps = con.prepareStatement(line)
            ) {
                ps.executeUpdate();
            }
        }

    }*/

}
