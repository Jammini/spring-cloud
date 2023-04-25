package me.world.hellocloud.dto;

public class Hello2DTO {
    private String result;
    private int count;

    public Hello2DTO(String result, int count) {
        this.result = result;
        this.count = count;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
