package com.javaspring.springmad.controller;

import com.javaspring.springmad.entity.Logs;
import com.javaspring.springmad.service.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogsController {
	@Autowired
	private LogsService logsService;

	@GetMapping
	public ResponseEntity<List<Logs>> getAllLogs() {
		List<Logs> logs = logsService.getAllLogs();

		return new ResponseEntity<>(logs, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Logs> getLogsById(@PathVariable Long id) {
		Logs logs = logsService.getLogsById(id);
		if (logs != null) {
			return new ResponseEntity<>(logs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Logs> createLogs(@RequestBody Logs logs) {
		Logs createdLogs = logsService.createLogs(logs);
		if (createdLogs != null) {
			return new ResponseEntity<>(createdLogs, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Logs> updateLogs(@PathVariable Long id, @RequestBody Logs logs) {
		Logs existingLogs = logsService.getLogsById(id);
		if (existingLogs != null) {
			Logs updatedLogs = logsService.updateLogs(id, logs);
			return new ResponseEntity<>(updatedLogs, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLogs(@PathVariable Long id) {
		Logs existingLogs = logsService.getLogsById(id);
		if (existingLogs != null) {
			logsService.deleteLogs(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
