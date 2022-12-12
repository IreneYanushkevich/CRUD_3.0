package com.irinayanushkevich.crud_3.service;

import com.irinayanushkevich.crud_3.model.Writer;
import com.irinayanushkevich.crud_3.repository.WriterRepository;
import com.irinayanushkevich.crud_3.repository.hib_rep.HibWriterRepositoryImpl;

import java.util.List;

public class WriterService {
    private final WriterRepository writerRep;

    public WriterService() {
        writerRep = new HibWriterRepositoryImpl();
    }

    public WriterService(WriterRepository writerRep) {
        this.writerRep = writerRep;
    }

    public Writer create(Writer writer) {
        return writerRep.create(writer);
    }

    public Writer getById(Long id) {
        return writerRep.getById(id);
    }

    public Writer edit(Writer writer) {
        return writerRep.edit(writer);
    }

    public boolean delete(Long id) {
        return writerRep.delete(id);
    }

    public List<Writer> getAll() {
        return writerRep.getAll();
    }
}
