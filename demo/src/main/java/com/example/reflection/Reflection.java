package com.example.reflection;

public class Reflection {
    
    public String publicField = "ONE";
    private String privateField = "TWO";
    protected String protectedField = "TREE";
    
    public Reflection() {}

    public Reflection(String publicField) {
        this.publicField = publicField;
    }
    
    private Reflection(String publicField, String privateField, String protectedField) {
        this.publicField = publicField;
        this.privateField = privateField;
        this.protectedField = protectedField;
    }

    public String publicMethod() throws NullPointerException {
        return "public";
    }

    private String privateMethod() throws NullPointerException {
        return "private method";
    }
}
