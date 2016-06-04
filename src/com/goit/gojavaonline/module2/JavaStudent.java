package com.goit.gojavaonline.module2;

/**
 * Created by tamila on 6/4/16.
 */
public class JavaStudent extends Student {
    private int javaKnowledgeLevel;

    public JavaStudent(String name) {
        super(name);
    }

    public int getJavaKnowledgeLevel() {
        return javaKnowledgeLevel;
    }

    public void setJavaKnowledgeLevel(int javaKnowledgeLevel) {
        this.javaKnowledgeLevel = javaKnowledgeLevel;
    }
}
