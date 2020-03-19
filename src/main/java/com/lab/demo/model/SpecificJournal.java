package com.lab.demo.model;

public class SpecificJournal {
    private String name;
    private int studyGroup;
    private String prisMark;
    private int prisAttempts;
    private String siiMark;
    private int siiAttempts;


    public SpecificJournal(String name, int studyGroup, String prisMark, int prisAttempts, String siiMark, int siiAttempts) {
        this.name = name;
        this.studyGroup = studyGroup;
        this.prisMark = prisMark;
        this.prisAttempts = prisAttempts;
        this.siiMark = siiMark;
        this.siiAttempts = siiAttempts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudyGroup() {
        return studyGroup;
    }

    public void setStudyGroup(int studyGroup) {
        this.studyGroup = studyGroup;
    }

    public String getPrisMark() {
        return prisMark;
    }

    public void setPrisMark(String prisMark) {
        this.prisMark = prisMark;
    }

    public String getSiiMark() {
        return siiMark;
    }

    public void setSiiMark(String siiMark) {
        this.siiMark = siiMark;
    }

    public int getPrisAttempts() {
        return prisAttempts;
    }

    public void setPrisAttempts(int prisAttempts) {
        this.prisAttempts = prisAttempts;
    }

    public int getSiiAttempts() {
        return siiAttempts;
    }

    public void setSiiAttempts(int siiAttempts) {
        this.siiAttempts = siiAttempts;
    }
}
