package com.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.model.RegistrationFlow;
import com.spring.persistence.RegistrationFlowRepository;

@Service
@Transactional
public class RegistrationSaveService implements InterfRegistrationSaveService {
	
	@Autowired
	private RegistrationFlowRepository registrationFlowRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public RegistrationFlow save(RegistrationFlow registrationFlow) {
		registrationFlow.setPassword(passwordEncoder.encode(registrationFlow.getPassword()));
		return registrationFlowRepository.save(registrationFlow);
	}

}
