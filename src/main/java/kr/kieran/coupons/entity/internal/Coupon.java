package kr.kieran.coupons.entity.internal;

import com.massivecraft.massivecore.store.EntityInternal;

public class Coupon extends EntityInternal<Coupon>
{
    // -------------------------------------------- //
    // OVERRIDE: ENTITY
    // -------------------------------------------- //

    @Override
    public Coupon load(Coupon that)
    {
        this.code = that.code;
        this.value = that.value;
        return this;
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private String code;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    private Double value;
    public Double getValue() { return value; }
    public void setValue(Double value) { this.value = value; }

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public Coupon(String code, Double value)
    {
        this.code = code;
        this.value = value;
    }

}
