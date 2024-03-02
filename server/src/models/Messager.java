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

    public String toString() {
        return "Messager{" +
                "text='" + text + '\'' +
                '}';
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