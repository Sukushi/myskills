package fr.dawan.myskills.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GenericService<D> {
	Page<D> findAll(Pageable page);
	Optional<D> findById(long id);
	D saveOrUpdate(D entity);
	List<D> saveAll(List<D> entities);
	void deleteById(long id);
}
