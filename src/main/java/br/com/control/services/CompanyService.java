package br.com.control.services;

import br.com.control.persistence.entities.Company;
import br.com.control.persistence.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repository;

    public List<Company> getAll() {
        return repository.findAll();
    }
}
