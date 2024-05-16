package fr.dawan.myskills.services.impl;

import fr.dawan.myskills.dtos.AnswerDto;
import fr.dawan.myskills.entities.Answer;
import fr.dawan.myskills.generic.GenericServiceImpl;
import fr.dawan.myskills.mappers.AnswerMapper;
import fr.dawan.myskills.repositories.AnswerRepository;
import fr.dawan.myskills.services.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AnswerServiceImpl extends GenericServiceImpl<Answer,AnswerDto,AnswerRepository,AnswerMapper> implements AnswerService {
	public AnswerServiceImpl(AnswerRepository repository, AnswerMapper mapper) {
		super(repository, mapper);
	}

	/**
	 * Récupère l'id d'une réponse par l'id d'une image
	 *
	 * @param imageId id de l'image
	 * @return id de la réponse trouvée
	 */
	@Transactional(readOnly = true)
	@Override
	public Long findByImg(long imageId) {
		Answer a = repository.findByImgId(imageId);
		return a != null ? a.getId() : 0;
	}
}
