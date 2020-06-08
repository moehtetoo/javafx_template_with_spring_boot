package com.pos.model.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.seasar.doma.Entity;

@Data
@Getter
@Setter
@Entity
public class Category {
    private int id;
    private String name;
}
