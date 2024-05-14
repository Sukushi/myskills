package fr.dawan.myskills.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface GenericService<D> {
	Page<D> findAll(Pageable pageable);
	Optional<D> findById(long id);
	D saveOrUpdate(D entity);
	void deleteById(long id);
}
