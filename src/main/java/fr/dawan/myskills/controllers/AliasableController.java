package fr.dawan.myskills.controllers;

import java.util.Optional;

public interface AliasableController<D> {
    public Optional<D> findByAlias(String alias);
}
