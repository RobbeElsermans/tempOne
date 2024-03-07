package com.controller;

import com.model.UserModel;
import com.model.BankModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class BankController {

	private static BankModel bankModel;

	public static void main(String[] args) {
		bankModel = new BankModel();
		SpringApplication.run(BankController.class, args);
	}

	@PostMapping(
			value = "/users/create",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> createUser(@RequestBody UserModel user){
		user.getId();
		if (bankModel.createUser(user))
		{
			return new ResponseEntity<>(user.getId(), HttpStatus.CREATED);
		}

		return new ResponseEntity<>(0, HttpStatus.CONFLICT);
	}

	@GetMapping(value ="/users/{id}/balance")
	public ResponseEntity<Double> getBalance(@PathVariable(value = "id") int accountId) {
		double balance = bankModel.getUserBalance(accountId);

		if (balance < 0)
			return new ResponseEntity<>(0.0, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<>(balance, HttpStatus.OK);
	}

	@PutMapping(value = "/users/{id}/addmoney")
	public ResponseEntity<Boolean> addMoney(@RequestParam(name = "amount") double amount, @PathVariable(name = "id") int accountId){
		if(bankModel.addMoney(accountId, amount) == -1) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}

	@PutMapping(value = "/users/{id}/removemoney")
	public ResponseEntity<Boolean> removeMoney(@RequestParam(name = "amount") double amount, @PathVariable(name = "id") int accountId){
		if(bankModel.withdrawMoney(accountId, amount) == -1) {
			return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}