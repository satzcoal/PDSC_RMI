package com.cnpat.pdsc.common;

public abstract class Consts {

	public static final int SERVICE_TYPE_RMI = 0;
	public static final int SERVICE_TYPE_WEBSERVICE = 1;

	public static final int BOOK_STATUS_ENABLE = 0;
	public static final int BOOK_STATUS_TIMEOUT = 1;
	public static final int BOOK_STATUS_DISABLE = 2;

	public static final int BOOK_OPTYPE_ENABLE = 0;
	public static final int BOOK_OPTYPE_DISABLE = 1;

	public static final int UPDATE_OPTYPE_ADD = 0;
	public static final int UPDATE_OPTYPE_EDIT = 1;
	public static final int UPDATE_OPTYPE_ROLLBACK = 2;

	public static final int UPDATE_DATATYPE_CURRENT = 0;
	public static final int UPDATE_DATATYPE_GRANT = 1;
	public static final int UPDATE_DATATYPE_PUBLIC = 2;

}
