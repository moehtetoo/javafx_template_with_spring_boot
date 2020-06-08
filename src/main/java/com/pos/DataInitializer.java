package com.pos;

import com.pos.databases.CategoryDao;
import com.pos.model.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoryDao categoryDao;

    @Bean
    public CommandLineRunner getCommandLineRunner(){
        return args -> {
            List<Category> list = this.categoryDao.selectAll();
            list.forEach((category) -> {
                System.out.println(category.toString());
            });
        };
    }
}
