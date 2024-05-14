package fr.dawan.myskills.tools;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
