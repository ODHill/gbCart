package com.odhill.garbarinoCart.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.modelmapper.ModelMapper;

/**
 * 
 * @author odhill
 *
 */
public final class Utils {
	
	private Utils() {
		
	}

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


	/**
	 * Validacion de la correctitud del email
	 * 
	 * @param email
	 * @return Devuelve true en caso de que el mail sea correcto, false en caso contrario
	 */
	public static boolean validateMail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	/**
	 * Permite la creacion de un DTO con los datos de un Objeto el cual modela
	 * 
	 * @param object
	 * @param clazz
	 * @return El DTO creado
	 */
	public static <T> T convertToDto(Object object, Class<T> clazz) {
		ModelMapper modelMapper = new ModelMapper(); 
		return modelMapper.map(object, clazz);		
	}
	
}
