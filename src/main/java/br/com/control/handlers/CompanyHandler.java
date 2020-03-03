package br.com.control.handlers;

import br.com.control.persistence.entities.Company;
import br.com.control.handlers.config.HandlerBase;
import br.com.control.services.CompanyService;
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
