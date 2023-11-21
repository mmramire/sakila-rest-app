package com.maticode.service;

import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maticode.dtos.ActorDTO;
import com.maticode.dtos.ActorSearchDTO;
import com.maticode.exception.ActorException;
import com.maticode.repository.ActorRepository;

@Service
public class ActorService {

	// Constantes
	private static final Long CERO_MB = 0L;
	private static final Long QUINIENTOS_MB = 524288000L;

	ResourceBundle bundle = ResourceBundle.getBundle("Errors");

	@Autowired
	private ActorRepository actorRepository;

	public ActorDTO findActorById(Long id) throws ActorException {
		try {
			return this.actorRepository.findActorById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
	}

	public List<ActorDTO> findByFirstName(String firstName) throws ActorException {
		try {
			return this.actorRepository.findByFirstName(firstName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
	}

	public List<ActorDTO> findByLastName(String lastName) throws ActorException {
		try {
			return this.actorRepository.findByLastName(lastName);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
	}

	public Resource downloadPicture(Long id) throws ActorException {
		try {
			Optional<Long> pictureBytesLengthSearch = this.actorRepository.getBlobSizeById(id);

			if (pictureBytesLengthSearch.isPresent()) {
				Long pictureBytes = pictureBytesLengthSearch.get();

				if (CERO_MB.equals(pictureBytes)) {
					throw new ActorException(String.format(bundle.getString("error.imagen_no_cargada"), id));
				} else if (pictureBytes > QUINIENTOS_MB) {
					throw new ActorException(String.format(bundle.getString("error.supera_limite"), id));
				}
				return this.actorRepository.downloadPicture(id);
			} else {
				throw new ActorException(bundle.getString("error.registro_no_existe"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}

	}

	public List<ActorDTO> getAll() throws ActorException {
		try {
			return this.actorRepository.getAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
	}

	public Page<ActorDTO> getAllActorsByPages(Pageable pageable) throws ActorException {
		try {
			// Obtiene el conteo total de registros
			Long total = actorRepository.getTotalActors();

			// Obtiene los registros paginados
			List<ActorDTO> actors = actorRepository.getAllActorsByPages(pageable);

			// Crea un objeto Page con los resultados paginados y el conteo total
			return new PageImpl<>(actors, pageable, total);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
	}

	public Page<ActorDTO> allActorsByPost(ActorSearchDTO request, Pageable pageable) throws ActorException {
		try {
			// Obtiene el conteo total de registros
			Long total = actorRepository.getTotalActors();

			// Obtiene los registros paginados
			List<ActorDTO> actors = actorRepository.allActorsByPost(request, pageable);

			// Crea un objeto Page con los resultados paginados y el conteo total
			return new PageImpl<>(actors, pageable, total);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ActorException(bundle.getString("error.error_sistemas"));
		}
		// return actorRepository.allActorsByPost(request);
	}
}
