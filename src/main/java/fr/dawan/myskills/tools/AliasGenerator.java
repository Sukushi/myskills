package fr.dawan.myskills.tools;

import fr.dawan.myskills.entities.AliasableEntity;
import fr.dawan.myskills.exceptions.InvalideAliasException;
import fr.dawan.myskills.repositories.AliasableRepository;

import java.text.Normalizer;

public class AliasGenerator {
    /**
     * création auto d'un alias (refactor d'un alias, création à partir d'un name)
     * format : kebab-case_id
     * longueur limitée (cf constante)
     *
     * @param aliasable
     * @param repo
     * @return
     */
    public static final int LIMITE = 30;

    public static String generateAlias(String name, AliasableRepository repository) {
		if (!name.isEmpty()) {
			return generate(name,repository);
		}
		throw new InvalideAliasException("Name required");
    }

    /**
     * 1- normalise l'Alias
     * 2- réduit l'alias à LIMITE si trop long
     * 3- si alias déjà existant en bdd: ajoute un incrément (mon-alias_1, mon-alias_2,...)
     *
     * @param name   : Alias ou Name (si alias non renseigné)
     * @param repository : nécessaire pour vérifier si déjà présent en Bdd
     * @return nouvel alias
     */
    private static String generate(String name, AliasableRepository repository) {
        String aliasGenerated = (normalizeAlias(name));
        // pour ne pas avoir des alias trop long => taille limitée à LIMITE caracteres
        if (aliasGenerated.length() > LIMITE) aliasGenerated = aliasGenerated.substring(0, LIMITE);
        // si l'alias généré existe en bdd => ajout d'un chiffre
        if (repository.findByAlias(aliasGenerated).isPresent()) {
			int increment = 1;
			aliasGenerated += "_";
			while (repository.findByAlias(aliasGenerated + increment).isPresent()) {
				increment++;
			}
			aliasGenerated += increment;
        }
        return aliasGenerated;
    }

    /**
     * Normalise l'alias
     * supprime caractères spéciaux
     * supprime les majuscules
     * kebab-case (snake_case_autorisé ou ecriture-hybride_1 autorisée)
     *
     * @param alias à normaliser
     * @return alias normalisé
	 * @throws InvalideAliasException si alias null ou constitué uniquement d'espaces ou de caractères spéciaux
     */
    public static String normalizeAlias(String alias) {
        if (alias == null || alias.trim().isEmpty()) throw new InvalideAliasException("null");

        String aliasNormalized = Normalizer.normalize(alias, Normalizer.Form.NFKD) // Les caractères sont décomposés par équivalence canonique et de compatibilité, et sont réordonnés.
				.toLowerCase()
				.replace(" ","_")
                .replaceAll("[\\n\"'.:?!&/<>|]", "-") // remplace : retour ligne . : | / < > ? ! & ' " en -
                .replaceAll("[^a-z0-9-_]", "") // supprime caractères spéciaux autres que _ et -
                .replaceAll("[-]{2,}", "-") // si plusieurs - à la suite => 1seul
                .replaceAll("(^[-])|([-]$)", "") // supprime - en début et fin
			;

        // s'il n'y a que des caractères spéciaux
        if (aliasNormalized.replaceAll("[-_]", "").isEmpty())
            throw new InvalideAliasException("Utilisez des caractères alphanumériques");
        return aliasNormalized;
    }
}
