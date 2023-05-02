package com.jrtp.app.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.jrtp.app.binding.CitizenAppDto;
import com.jrtp.app.entity.CitizenAppEntity;
import com.jrtp.app.repository.CitizenAppRepository;
import com.jrtp.app.service.CitizenRegistrationServie;

@Service
public class CitizenRegistraionServiceImpl implements CitizenRegistrationServie {

	@Autowired
	public CitizenAppRepository citizenAppRepository;
	
	
	private static final String REST_URL ="http://";

	@Override
	public String registrationCitizen(CitizenAppDto citizenAppDto) {
		/*
		 * Long ssn = citizenAppDto.getSsn();
		 * 
		 * WebClient webClient = WebClient.create();
		 * 
		 * String stateName = webClient.get() .uri(REST_URL, ssn) .retrieve()
		 * .bodyToMono(String.class) .block();
		 */
		
	//	if("Rhode Island".equals(stateName)) {
			
			CitizenAppEntity entity = new CitizenAppEntity();
			BeanUtils.copyProperties(citizenAppDto, entity);
			
			citizenAppRepository.save(entity);
			return "Citizen App Created :" + entity.getAppId();
		//}
		//return "Citizen Not Belogs to RI..";
		
		
	}

}
