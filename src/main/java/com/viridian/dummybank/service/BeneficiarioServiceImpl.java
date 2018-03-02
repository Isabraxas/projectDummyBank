package com.viridian.dummybank.service;

import com.viridian.dummybank.dao.BeneficiarioRepository;
import com.viridian.dummybank.model.Beneficiario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService{

    @Autowired
    protected BeneficiarioRepository beneficiarioRepository;

    @Override
    public List<Beneficiario> getAll() {
        return this.beneficiarioRepository.findAll();
    }

    @Override
    public void save(Beneficiario beneficiario) {
        this.beneficiarioRepository.save(beneficiario);
    }

    @Override
    public void delete(Long id) {
        this.beneficiarioRepository.delete(id);
    }

    @Override
    public Beneficiario getBeneficiarioById(Long id) {
        return this.beneficiarioRepository.findOne(id);
    }

    // añadido por marcelo
    @Override
    public Beneficiario getBeneficiarioByNumeroCuenta(Long numeroCuenta) {
        return beneficiarioRepository.getBeneficiarioByNumeroCuenta(numeroCuenta);
    }


}
