package com.example.demo.controllers.admin.base;

import org.springframework.ui.Model;

import com.example.demo.database.base.DbEntity;

public interface CrudController <T extends DbEntity> {

    String index(Model model);
    
    String details(Model model);
    String details(Model model, T item);
    String details(Model model, Long id);
}
