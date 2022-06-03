package com.unla.unlaGAulas.helpers;

public class ViewRouteHelper {
	/**** Views ****/
	//HOME
	public final static String INDEX = "home/index";
	
	//USER
	public final static String USER_LOGIN = "user/login";
	public final static String USER_LOGOUT = "user/logout";
	
	//ADMIN
	public final static String ADMIN_INDEX = "admin/index";
	public final static String ADMIN_FINAL = "admin/adminFinal";
	public final static String ADMIN_CURSO = "admin/adminCurso";
	public final static String ADMIN_USER = "admin/adminUser";
	public final static String ADMIN_FINAL_ESPACIO = "admin/adminFinalEspacio";
	
	//PROFESOR
	public final static String PROFESOR_INDEX = "profesor/index";
	public final static String PROFESOR_NEWFINAL = "profesor/newFinal";
	public final static String PROFESOR_NEWCURSO = "profesor/newCurso";
	public final static String PROFESOR_USER = "profesor/profesorUser";
	
	/**** Redirects ****/
	public final static String ROUTE = "/index";
	public final static String PROFESOR_ROOT = "/profesor/index";
	public final static String ADMIN_ROOT_FINAL = "/admin/adminFinal";

}
