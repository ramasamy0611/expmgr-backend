package com.ram.projects.expmgr.rest.converter;

@FunctionalInterface
public interface Converter<I, O> {
    O convert(I input);
}
