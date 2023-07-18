package com.izdeveloper.userstorageappv2;

import java.io.Serializable;

public class User implements Serializable {
    private String name, surname, email, degree;
    private int avatar;
    private boolean Kand, DI, Tek, Uim;

    public User(String name, String surname, String email, String degree, int avatar, boolean Kand, boolean DI, boolean Tek, boolean Uim) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.degree = degree;
        this.avatar = avatar;
        this.Kand = Kand;
        this.DI = DI;
        this.Tek = Tek;
        this.Uim = Uim;
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getEmail() {
        return email;
    }
    public String getDegree() {
        return degree;
    }

    public int getAvatar() {
        return avatar;
    }

    public boolean isKand() {
        return Kand;
    }

    public boolean isDI() {
        return DI;
    }

    public boolean isTek() {
        return Tek;
    }

    public boolean isUim() {
        return Uim;
    }
}
