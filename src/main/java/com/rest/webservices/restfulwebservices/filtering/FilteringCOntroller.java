package com.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringCOntroller {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        //Dynamic filter for specific API  and add the @JsonFilter("SomeBeanFilter")
        //MappingJacksonValue
        SomeBean someBean = new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);
        mappingJacksonValue.setFilters(filters);
        return mappingJacksonValue;
    }

    // value1, value3 will be present in response

    @GetMapping("/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(new SomeBean("value1","value2","value3"), new SomeBean("value4","value5","value6"));
    }
}

