package br.com.control.handlers.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class Mapper extends ModelMapper {
    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public <D> D convert(Object source, Class<D> destinationType) throws Exception {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(source);
        if (!constraintViolations.isEmpty())
            throw new Exception((Throwable) constraintViolations);

        return super.map(source, destinationType);
    }

    public <D> Collection convertList(Collection sources, Class<D> destinationType) throws Exception {
        Set<ConstraintViolation<Object>> constraintViolations = new HashSet<>();
        Collection collection = new HashSet<>();
        sources.stream().forEach(source->{
            constraintViolations.addAll(validator.validate(source));
            collection.add(super.map(source, destinationType));
        });

        if (!constraintViolations.isEmpty())
            throw new Exception((Throwable) constraintViolations);

        return collection;
    }


}

