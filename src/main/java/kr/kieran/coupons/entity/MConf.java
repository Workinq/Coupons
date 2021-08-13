package kr.kieran.coupons.entity;

import com.massivecraft.massivecore.command.editor.annotation.EditorName;
import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;

import java.util.List;

@EditorName("config")
public class MConf extends Entity<MConf>
{
    // -------------------------------------------- //
    // META
    // -------------------------------------------- //

    protected static transient MConf i;
    public static MConf get() { return i; }

    // -------------------------------------------- //
    // OVERRIDE: ENTITY
    // -------------------------------------------- //

    @Override
    public MConf load(MConf that)
    {
        super.load(that);
        return this;
    }

    // -------------------------------------------- //
    // COMMAND ALIASES
    // -------------------------------------------- //

    public List<String> cmdAliases = MUtil.list("coupon", "coupons");

    // -------------------------------------------- //
    // MESSAGES
    // -------------------------------------------- //

    public String invalidCode = "<b>The code must be in the format XXXX XXXX XXXX XXXX";
    public String addedCoupon = "<g>Successfully gave a <i>$%,.1f <g>coupon with code <i>%s <g>to <i>%s<g>.";
    public String clearedCoupons = "<g>Successfully cleared coupons for <i>%,d <g>players.";
    public String noCoupons = "<b>%s does not have any coupons.";

    // -------------------------------------------- //
    // MISCELLANEOUS
    // -------------------------------------------- //

    public String couponListTitle = "<l>%s's Coupons";
    public String couponListFormat = "<i>%d. $%,.1f - %s";

}
