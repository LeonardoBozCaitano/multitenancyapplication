package br.com.multitenancy.services;

import br.com.multitenancy.persistence.entities.Company;
import br.com.multitenancy.persistence.repositories.CompanyRepository;
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
