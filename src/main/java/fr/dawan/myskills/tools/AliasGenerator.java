package fr.dawan.myskills.tools;

import fr.dawan.myskills.exceptions.InvalideAliasException;
import fr.dawan.myskills.repositories.AliasableRepository;

import java.text.Normalizer;

public class AliasGenerator {
    
    public static final int LIMITE = 30;
	
	/**
	 * Création d'un alias de longueur limitée (cf constante)
	 * @param name
	 * @param repository
	 * @return
	 */
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
     * @param name   : nom à 'aliasiser'
     * @param repository : nécessaire pour vérifier si déjà présent en Bdd
     * @return un alias normalisé
     */
    private static String generate(String name, AliasableRepository repository) {
        String aliasNormalize = (normalize(name));
        // pour ne pas avoir des alias trop long => taille limitée avec la constante LIMITE
        if (aliasNormalize.length() > LIMITE) aliasNormalize = aliasNormalize.substring(0, LIMITE);
        // si l'alias généré existe en bdd => ajout d'un chiffre
        if (repository.findByAlias(aliasNormalize).isPresent()) {
			int increment = 1;
			aliasNormalize += "_";
			while (repository.findByAlias(aliasNormalize + increment).isPresent()) {
				increment++;
			}
			aliasNormalize += increment;
        }
        return aliasNormalize;
    }

    /**
     * Normalise l'alias en supprimant les caractères spéciaux et les majuscules
     * @param text le texte à normaliser
     * @return texte normalisé
	 * @throws InvalideAliasException si le texte est null ou constitué uniquement d'espaces ou de caractères spéciaux
     */
    public static String normalize(String text) {
        if (text == null || text.trim().isEmpty()) throw new InvalideAliasException("chaîne vide");

        String aliasNormalized = Normalizer.normalize(text, Normalizer.Form.NFKD) // Les caractères sont décomposés par équivalence canonique et de compatibilité, et sont réordonnés.
				.toLowerCase()
				.replace(" ","_") // remplace les espaces par des _
                .replaceAll("[\\n\"'.:?!&/<>|]", "-") // remplace : retour ligne . : | / < > ? ! & ' " en -
                .replaceAll("[^a-z0-9-_]", "") // supprime caractères spéciaux autres que _ et -
                .replaceAll("[-]{2,}", "-") // si plusieurs - à la suite => 1seul
                .replaceAll("(^[-])|([-]$)", "") // supprime - en début et fin
			;

        // s'il n'y a que des caractères spéciaux
        if (aliasNormalized.replaceAll("[-_]", "").isEmpty())
            throw new InvalideAliasException("utilisez des caractères alphanumériques non spéciaux");
        return aliasNormalized;
    }
}
