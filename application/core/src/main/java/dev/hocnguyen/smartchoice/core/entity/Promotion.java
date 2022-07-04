package dev.hocnguyen.smartchoice.core.entity;

public class Promotion {
    private Integer value;
    private PromotionType type;

    public Promotion(Integer value, PromotionType type ) {
        this.value = value;
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public PromotionType getType() {
        return type;
    }
}
