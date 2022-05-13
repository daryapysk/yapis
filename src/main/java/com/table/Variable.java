package com.table;

public class Variable<T>{
    private String dataType;
    private T value;

    private String accessType;

    public Variable(String dataType, T value, String accessType) {
        this.dataType = dataType;
        this.value = value;
        this.accessType = accessType;
    }

    public String getType() {
        return this.dataType;
    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
