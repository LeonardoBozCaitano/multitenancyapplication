package br.com.multitenancy.handlers;

import br.com.multitenancy.persistence.entities.Company;
import br.com.multitenancy.handlers.config.HandlerBase;
import br.com.multitenancy.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyHandler implements HandlerBase {

    @Autowired
    private CompanyService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Company> getAll() {
        return service.getAll();
    }
}
