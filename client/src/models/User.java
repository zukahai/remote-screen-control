package models;

import java.io.Serializable;

public class User implements Serializable{
    private int id;
    private int password;

    public User() {
        this.id = random(3);
        this.password = random(2);
    }
    
    public int random(int n) {
    	int max = (int)Math.pow(10, n - 1);
    	return (int)(Math.random() * 1000000) % (max * 10) + max;
    }
    
    public User(int id, int password) {
        this.id = id;
        this.password = password;
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", password=" + password +
                '}';
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.password != other.password) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
		return id;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getPassword() {
        return password;
    }
    
    public void setPassword(int password) {
        this.password = password;
    }  
    
    public static void main(String[] args) {
		System.out.println(new User());
	}
}