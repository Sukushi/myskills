package fr.dawan.myskills.controllers;

import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface AliasableController<D> {
    public ResponseEntity<D> findByAlias(String alias);
}
