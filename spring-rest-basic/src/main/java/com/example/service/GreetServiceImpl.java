package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements IGreetService {

	@Override
	public String showMessage() {
		return "Good Work!!!";
	}

}
