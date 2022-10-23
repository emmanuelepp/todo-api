package com.emmanuelepp.todoapi.mapper;

public interface IMapper<I,O> {
    public O map(I in);
}
