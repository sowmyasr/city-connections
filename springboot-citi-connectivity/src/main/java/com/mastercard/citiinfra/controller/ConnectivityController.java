package com.mastercard.citiinfra.controller;

import com.mastercard.citiinfra.services.ConnectivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class ConnectivityController {

	@Autowired
	private ConnectivityService connectivityService;
	@RequestMapping(method = RequestMethod.GET, value = "/connected")
	public String getConnectivity(@RequestParam(name ="origin") String origin,@RequestParam(name ="destination") String destination) throws IOException {
		return connectivityService.isConnected(origin.toLowerCase(), destination.toLowerCase());
	}
}
