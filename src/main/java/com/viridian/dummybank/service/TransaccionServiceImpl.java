package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaccionServiceImpl implements TransaccionService{
    @Autowired
    protected TransaccionRepository transaccionRepository;
}
