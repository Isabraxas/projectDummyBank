package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperadorServiceImpl implements OperadorService{
    @Autowired
    protected OperadorRepository operadorRepository;
}
