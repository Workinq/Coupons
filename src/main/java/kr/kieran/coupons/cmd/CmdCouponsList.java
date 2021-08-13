package kr.kieran.coupons.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.collections.MassiveList;
import com.massivecraft.massivecore.command.Parameter;
import com.massivecraft.massivecore.pager.Pager;
import com.massivecraft.massivecore.pager.Stringifier;
import com.massivecraft.massivecore.util.Txt;
import kr.kieran.coupons.cmd.type.TypeMPlayer;
import kr.kieran.coupons.entity.MConf;
import kr.kieran.coupons.entity.MPlayer;
import kr.kieran.coupons.entity.internal.Coupon;

public class CmdCouponsList extends CouponsCommand
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CmdCouponsList()
    {
        // Parameters
        this.addParameter(Parameter.getPage());
        this.addParameter(TypeMPlayer.get(), "player", "you");
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        // Args
        int page = this.readArg();
        MPlayer mplayer = this.readArg(this.msender);

        // Get the player's coupons and check there are some
        MassiveList<Coupon> coupons = mplayer.getCoupons();
        if (coupons.isEmpty()) throw new MassiveException().setMsg(MConf.get().noCoupons, mplayer.getName());

        // Create pager & send to player
        Pager<Coupon> pager = new Pager<>(this, Txt.parse(MConf.get().couponListTitle, mplayer.getName()), page, coupons, new Stringifier<Coupon>()
        {
            @Override
            public String toString(Coupon coupon, int index)
            {
                return Txt.parse(MConf.get().couponListFormat, index + 1, coupon.getValue(), coupon.getCode());
            }
        });
        pager.message();
    }

}
