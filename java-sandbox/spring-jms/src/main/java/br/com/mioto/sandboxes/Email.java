package br.com.mioto.sandboxes;

public class Email {

	public Email(String email, String msg) {
		super();
		this.email = email;
		this.msg = msg;
	}

	private String email;
	private String msg;
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}


}
