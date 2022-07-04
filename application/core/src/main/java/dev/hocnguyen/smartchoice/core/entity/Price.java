package dev.hocnguyen.smartchoice.core.entity;

import java.math.BigInteger;

public class Price {
    private Integer value;
    private PriceUnit unit;
    public Price(Integer value, PriceUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Integer getValue() {
        return value;
    }

    public PriceUnit getUnit() {
        return unit;
    }
}
