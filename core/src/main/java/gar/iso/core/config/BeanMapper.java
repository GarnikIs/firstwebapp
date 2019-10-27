package gar.iso.core.config;

import ma.glasnost.orika.Converter;
import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
public class BeanMapper extends ConfigurableMapper {

    @Autowired(required = false)
    private final List<Mapper<?, ?>> mappers = Collections.emptyList();

    @Autowired(required = false)
    private final List<Converter<?, ?>> converters = Collections.emptyList();

    public BeanMapper() {
        super(false);
    }

    @PostConstruct
    @Override
    public void init() {
        super.init();
    }

    @Override
    protected void configure(final MapperFactory factory) {
        mappers.forEach(mapper -> addMapper(factory, mapper));
        converters.forEach(converter -> addConverter(factory, converter));
    }

    @SuppressWarnings("unchecked")
    private void addMapper(final MapperFactory factory, final Mapper<?, ?> mapper) {
        factory.classMap(mapper.getAType(), mapper.getBType()).byDefault().customize((Mapper) mapper).register();
    }

    private void addConverter(final MapperFactory factory, final Converter<?, ?> converter) {
        factory.getConverterFactory().registerConverter(converter);
    }
}