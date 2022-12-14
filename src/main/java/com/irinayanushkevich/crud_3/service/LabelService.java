package com.irinayanushkevich.crud_3.service;

import com.irinayanushkevich.crud_3.model.Label;
import com.irinayanushkevich.crud_3.repository.LabelRepository;
import com.irinayanushkevich.crud_3.repository.hib_rep.HibLabelRepositoryImpl;

import java.util.List;

public class LabelService {
    private final LabelRepository labelRep;

    public LabelService() {
        labelRep = new HibLabelRepositoryImpl();
    }

    public LabelService(LabelRepository labelRep) {
        this.labelRep = labelRep;
    }

    public Label create(Label label) {
        return labelRep.create(label);
    }

    public Label getById(Long id) {
        return labelRep.getById(id);
    }

    public Label edit(Label label) {
        return labelRep.edit(label);
    }

    public boolean delete(Long id) {
        return labelRep.delete(id);
    }

    public List<Label> getAll() {
        return labelRep.getAll();
    }
}
