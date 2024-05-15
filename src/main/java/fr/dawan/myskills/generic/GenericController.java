package fr.dawan.myskills.generic;

import fr.dawan.myskills.dtos.BaseEntityDto;
import fr.dawan.myskills.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RequiredArgsConstructor
@RestController
public abstract class GenericController <D extends BaseEntityDto, S extends GenericService<D>> {
    protected final S service;

    @GetMapping
    public ResponseEntity<Page<D>> findAll(Pageable page) {
        return ResponseEntity.ok(service.findAll(page));
    }
    @GetMapping("/unpaged")
    public ResponseEntity<Page<D>> findAll() {
        return ResponseEntity.ok(service.findAll(Pageable.unpaged()));
    }
    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable long id) {
        return service.findById(id).map(ResponseEntity::ok).orElseThrow(NotFoundException::new);
    }
    @PostMapping
    public ResponseEntity<D> saveOrUpdate(@RequestBody D dto) {
		if (service.findById(dto.getId()).isPresent())
			return new ResponseEntity<>(service.saveOrUpdate(dto), HttpStatus.CREATED);
		return ResponseEntity.ok(service.saveOrUpdate(dto));
    }
	@PostMapping("/list")
	public ResponseEntity<List<D>> saveAll(@RequestBody List<D> listDto) {
		return ResponseEntity.ok(service.saveAll(listDto));
	}
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        service.deleteById(id);
    }
}
