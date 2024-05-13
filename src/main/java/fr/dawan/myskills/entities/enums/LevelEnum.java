package fr.dawan.myskills.entities.enums;

public enum LevelEnum {
	ALL, BEGINNER, INTERMEDIATE, ADVANCED, EXPERT, SCALABLE,
	NULL // Pour la recherche dans la méthode findByCategoryIdAndCreatorIdAndStatusAndLevel()
	;
	public LevelEnum raiseLevel() {
		switch (this) {
			case BEGINNER:
				return INTERMEDIATE;
			case INTERMEDIATE:
				return ADVANCED;
			case ADVANCED:
				return EXPERT;
			case EXPERT:
				return EXPERT;
			default:
				return INTERMEDIATE;
		}
	}
	public LevelEnum lowerLevel() {
		switch (this) {
			case BEGINNER:
				return BEGINNER;
			case INTERMEDIATE:
				return BEGINNER;
			case ADVANCED:
				return INTERMEDIATE;
			case EXPERT:
				return ADVANCED;
			default:
				return ALL;
		}
	}

}
