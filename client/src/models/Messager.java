package models;

import java.io.Serializable;

public class Messager implements Serializable {
	private static final long serialVersionUID = 1L;
	private String text;
    private Object object;

    public Messager() {
        this.text = "";
    }

    public Messager(String text) {
        this.text = text;
    }
    
    public Messager(String text, Object object) {
        this.text = text;
        this.object = object;
    }

    public String toString() {
        return "Messager[\n" +
                "\ttext='" + text + '\'' + '\n' +
                "\tObject=" + object + '\n' +
                ']';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}