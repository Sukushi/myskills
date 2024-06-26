package fr.dawan.myskills.generic;

import fr.dawan.myskills.entities.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<E extends BaseEntity,D,
		R extends JpaRepository<E, Long>,
		M extends GenericMapper<D,E>> implements GenericService<D> {
	
	protected final R repository;
	protected final M mapper;
	
	@Override
	public Page<D> findAll(Pageable page) {
		return repository.findAll(page).map(mapper::toDto);
	}
	@Override
	public Optional<D> findById(long id) {
		return repository.findById(id).map(mapper::toDto);
	}
	@Override
	public D saveOrUpdate(D dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}
	@Override
	public List<D> saveAll(List<D> dtoList) {
		dtoList = (List<D>) dtoList.stream().map(dto -> repository.save(mapper.toEntity(dto)));
		return dtoList;
	}
	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}
}
