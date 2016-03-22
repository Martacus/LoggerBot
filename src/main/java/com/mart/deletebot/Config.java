package com.mart.deletebot;

public class Config {

    public boolean logMessages;
    public boolean logDeletes;
    public boolean logEdits;

    public boolean isLogMessages() {
        return logMessages;
    }

    public void setLogMessages(boolean logMessages) {
        this.logMessages = logMessages;
    }

    public boolean isLogDeletes() {
        return logDeletes;
    }

    public void setLogDeletes(boolean logDeletes) {
        this.logDeletes = logDeletes;
    }

    public boolean isLogEdits() {
        return logEdits;
    }

    public void setLogEdits(boolean logEdits) {
        this.logEdits = logEdits;
    }
}
