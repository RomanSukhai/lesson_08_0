package ru.unum.work;

public class WrongInputConsoleParametersException extends Exception{

    private String scs;

    public String getScs() {
        return scs;
    }

    public WrongInputConsoleParametersException(String scs) {
        this.scs = scs;
    }
}
