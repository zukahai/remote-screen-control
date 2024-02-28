package models;

import java.io.Serializable;

public class Messager implements Serializable {
    private String text;

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
}