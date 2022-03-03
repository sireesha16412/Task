package com.example.loginformwithedittexts;

public final class Modelclass {
    public String key;
    public String value;

    public Modelclass(String key, String value) {
        this.key = key;
        this.value = value;
    }
public Modelclass(){

}

    @Override
    public boolean equals(Object o) {
        return o instanceof Modelclass && key.equals(((Modelclass) o).key);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
