package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperacionServiceImpl implements OperacionService {
    @Autowired
    protected OperacionRepository operacionRepository;
}
