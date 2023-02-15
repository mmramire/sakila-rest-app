package com.maticode.queries;

/**
 * @author mmram
 *
 */
public class SQLCommands {

	/**
	 * 
	 * */
	private SQLCommands() {
	}

	// Customers
	public static final String SELECT_CUSTOMER_LIST_PARTIAL_DATA = "SELECT ID, name, phone, city, country FROM customer_list";

	// Films
	public static final String SELECT_FILM_LIST = "SELECT * FROM film_list;";

	/*
	 * The nicer_but_slower_film_list view contains a formatted view of the film
	 * table, with a comma-separated list of the film's actors. The
	 * nicer_but_slower_film_list view differs from the film_list view in the list
	 * of actors. The lettercase of the actor names is adjusted so that the first
	 * letter of each name is capitalized, rather than having the name in all-caps.
	 * As indicated in its name, the nicer_but_slower_film_list view performs
	 * additional processing and therefore takes longer to return data than the
	 * film_list view.
	 */
	public static final String SELECT_NICER_BUT_SLOWE_FILM_LIST = "SELECT * FROM nicer_but_slower_film_list";
}
