package com.mart.deletebot;

public class Config {

    private boolean logMessages;
    private boolean logDeletes;
    private boolean logEdits;
    private boolean addRoleToLog;

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

    public boolean isAddRoleToLog() {
        return addRoleToLog;
    }

    public void setAddRoleToLog(boolean addRoleToLog) {
        this.addRoleToLog = addRoleToLog;
    }
}
