package com.example.springapplication;

import org.springframework.context.annotation.Import;

@Import(value = SqlServiceContext.class)
public @interface EnableSqlService {
}
