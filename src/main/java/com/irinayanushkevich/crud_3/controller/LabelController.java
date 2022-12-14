package com.irinayanushkevich.crud_3.controller;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.service.LabelService;

import java.util.List;

public class LabelController {
    private final LabelService LabelService = new LabelService();

    public Label create(String name) {
        Label l = new Label(null, name);
        return LabelService.create(l);
    }

    public Label getById(Long id) {
        return LabelService.getById(id);
    }

    public Label edit(Long id, String name) {
        Label label = new Label(id, name);
        return LabelService.edit(label);
    }

    public boolean delete(Long id) {
        return LabelService.delete(id);
    }

    public List<Label> getAll() {
        return LabelService.getAll();
    }
}
