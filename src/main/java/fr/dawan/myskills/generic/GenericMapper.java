package fr.dawan.myskills.generic;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
