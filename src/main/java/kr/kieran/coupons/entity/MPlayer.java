package kr.kieran.coupons.entity;

import com.massivecraft.massivecore.collections.MassiveList;
import com.massivecraft.massivecore.store.SenderEntity;
import kr.kieran.coupons.entity.internal.Coupon;

public class MPlayer extends SenderEntity<MPlayer>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    public static MPlayer get(Object oid)
    {
        return MPlayerColl.get().get(oid);
    }

    // -------------------------------------------- //
    // LOAD
    // -------------------------------------------- //

    @Override
    public MPlayer load(MPlayer that)
    {
        this.setCoupons(that.coupons);
        return this;
    }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    private MassiveList<Coupon> coupons = new MassiveList<>();

    // -------------------------------------------- //
    // IS DEFAULT
    // -------------------------------------------- //

    @Override
    public boolean isDefault()
    {
        if (this.hasCoupons()) return false;
        return true;
    }

    // -------------------------------------------- //
    // FIELD: coupons
    // -------------------------------------------- //

    public MassiveList<Coupon> getCoupons() { return this.coupons; }
    public void setCoupons(MassiveList<Coupon> coupons) { this.coupons = coupons; }
    public boolean hasCoupons() { return !this.coupons.isEmpty(); }
    public void addCoupon(Coupon coupon)
    {
        this.coupons.add(coupon);
        this.changed();
    }
    public void clearCoupons()
    {
        this.coupons.clear();
        this.changed();
    }

}
