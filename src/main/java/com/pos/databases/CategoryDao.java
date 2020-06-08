package com.pos.databases;

import com.pos.model.entity.Category;
import javafx.application.Application;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

@ConfigAutowireable
@Dao(config = AppConfig.class)
public interface CategoryDao {

    @Select
    List<Category> selectAll();
}
