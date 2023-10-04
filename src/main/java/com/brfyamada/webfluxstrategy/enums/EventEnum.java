package com.brfyamada.webfluxstrategy.enums;


public enum EventEnum {

    EventBlock("event-block", 101, "successfully blocked"),
    EventUnblock("event-unblock", 102, "successfully unblocked"),
    EventCancel("event-cancel", 103, "successfully canceled");

    private String name;
    private int code;
    private String successMessage;


    EventEnum(String name, int code, String successMessage){
        this.name = name;
        this.code = code;
        this.successMessage = successMessage;
    }

    public String getName(){
        return this.name;
    }

    public int getCode() {
        return this.code;
    }

    public static EventEnum getEventByName(String name) {
        for (EventEnum enums : EventEnum.values()) {
            if (enums.getName().equals(name)) {
                return enums;
            }
        }
        return null;
    }

    public String getSuccessMessage() {
        return this.successMessage;
    }
}
