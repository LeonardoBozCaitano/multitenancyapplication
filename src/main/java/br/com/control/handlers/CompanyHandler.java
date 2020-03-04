package br.com.control.handlers;

import br.com.control.handlers.dtos.CompanyDto;
import br.com.control.handlers.config.HandlerBase;
import br.com.control.handlers.utils.Mapper;
import br.com.control.services.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/company")
public class CompanyHandler implements HandlerBase<CompanyDto> {

    private CompanyService service;
    private Mapper mapper;

    CompanyHandler(CompanyService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<CompanyDto> getAll() {
        try {
            return new ArrayList<CompanyDto>(mapper.convertList(service.getAll(), CompanyDto.class));
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CompanyDto get(@PathVariable("id") String id) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public CompanyDto save(CompanyDto dto) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public CompanyDto update(@PathVariable("id") String id, CompanyDto dto) {
        return null;
    }

    @Override
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void delete(@PathVariable("id") String id) {

    }
}
