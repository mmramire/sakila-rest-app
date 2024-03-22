package com.maticode.repository;

import java.nio.file.Path;

import org.springframework.stereotype.Repository;

@Repository
public class FileRepository {

	public String insertFile(Path filePath) {
		// Aquí va tu código para insertar el archivo en la base de datos
		return "Archivo insertado con éxito";
	}
}
