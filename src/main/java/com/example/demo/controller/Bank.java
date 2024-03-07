package com.example.demo.controller;

import com.example.demo.model.AccountName;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Bank {

	private static com.example.demo.model.Bank bank;

	public static void main(String[] args) {
		bank = new com.example.demo.model.Bank();
		AccountName name = new AccountName("r", "e");
		bank.createUser(name);
		bank.addMoney(name, 10.0);
		SpringApplication.run(Bank.class, args);
	}

	@GetMapping(value ="/balance",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> getBalance(@RequestBody AccountName fullname) {
		double balance = bank.getUserBalance(fullname);

		if (balance < 0)
			return new ResponseEntity<>(0.0, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(balance, HttpStatus.OK);
	}

	@PostMapping(
			value = "/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> createUser(@RequestBody AccountName fullname){

		if (bank.createUser(fullname))
		{
			return new ResponseEntity<>(true, HttpStatus.CREATED);
		}

		return new ResponseEntity<>(false, HttpStatus.CONFLICT);
	}

	@PutMapping(
			value = "/addmoney",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Boolean> addMoney(@RequestParam(name = "amount") double amount, @RequestBody AccountName fullName){
		if(bank.addMoney(fullName, amount) == -1) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping(
			value = "/removemoney",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Boolean> removeMoney(@RequestParam(name = "amount") double amount, @RequestBody AccountName fullName){
		if(bank.withdrawMoney(fullName, amount) == -1) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}