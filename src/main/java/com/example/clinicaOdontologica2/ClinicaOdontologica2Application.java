package com.example.clinicaOdontologica2;

import org.apache.log4j.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ClinicaOdontologica2Application {

	public static void main(String[] args) {
		//avisa a log4j donde esta el archivo de configuracion
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(ClinicaOdontologica2Application.class, args);
	}

}
