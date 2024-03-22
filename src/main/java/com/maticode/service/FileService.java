package com.maticode.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maticode.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;

	public String processFile() throws IOException {

		if (checkPermissions()) {

			try (Stream<Path> paths = Files.walk(Paths.get("C:\\reservascheques"))) {
				paths.filter(Files::isRegularFile)
						.filter(path -> Pattern.matches("archivo-\\d{8}-\\d{4}\\.txt", path.getFileName().toString()))
						.max(Comparator.comparing(path -> path.getFileName().toString())).ifPresent(t -> {
							System.out.println(t.getFileName());
							try {
								processFile(t);
							} catch (IOException e) {
								e.printStackTrace();
							}
						});

			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("No tiene permisos de lectura/escritura en el disco");
			return "No tiene permisos de lectura/escritura en el disco";
		}
		return "Exito";
	}

	private String processFile(Path filePath) throws IOException {
		// Inserta el archivo en la base de datos
		String respuesta = fileRepository.insertFile(filePath);
		// Mueve el archivo al subdirectorio

		if ("Archivo insertado con éxito".equals(respuesta)) {
			try {
				Files.move(filePath, Paths.get("C:\\reservascheques\\historial\\" + filePath.getFileName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IOException("Error al procesar archivo");
		}
		return "Archivo insertado con éxito";
	}

	public boolean checkPermissions() throws IOException {

		FileInputStream input;
		try {
			input = new FileInputStream("C:\\reservascheques\\archivo-20240128-1605.txt");
			try (ReadableByteChannel source = input.getChannel()) {
				source.isOpen();
				System.out.println("Entré");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Path of Input text file

//		Path path = Paths.get("C:\\reservascheques");
//		path.toAbsolutePath();
//		System.out.println(path);
		return true;
//		File file = new File(path);
//		 ruta.toAbsolutePath();
//		boolean flagRead;
//		boolean flagWrite;
//
//		if (directory.canRead()) {
//			System.out.println("Tienes permisos de lectura en el directorio.");
//			flagRead = true;
//		} else {
//			System.out.println("No tienes permisos de lectura en el directorio.");
//			flagRead = false;
//		}
//
//		if (directory.canWrite()) {
//			System.out.println("Tienes permisos de escritura en el directorio.");
//			flagWrite = true;
//		} else {
//			System.out.println("No tienes permisos de escritura en el directorio.");
//			flagWrite = false;
//		}
//
//		return (flagRead && flagWrite);
	}
}
