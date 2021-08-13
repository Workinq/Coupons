package kr.kieran.coupons.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.primitive.TypeDouble;
import com.massivecraft.massivecore.command.type.primitive.TypeString;
import kr.kieran.coupons.cmd.type.TypeMPlayer;
import kr.kieran.coupons.entity.MConf;
import kr.kieran.coupons.entity.MPlayer;
import kr.kieran.coupons.entity.internal.Coupon;

public class CmdCouponsAdd extends CouponsCommand
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CmdCouponsAdd()
    {
        // Parameters
        this.addParameter(TypeMPlayer.get(), "player");
        this.addParameter(TypeDouble.get(), "amount");
        this.addParameter(TypeString.get(), "code", true);
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        // Args
        MPlayer mplayer = this.readArg();
        double value = this.readArg();
        String code = this.readArg();

        // Verify the code entered is correct
        if (code.replace(" ", "").replaceAll("[^0-9]", "").length() != 16) throw new MassiveException().setMsg(MConf.get().invalidCode);

        // Create the coupon with the provided args
        Coupon coupon = new Coupon(code, value);
        mplayer.addCoupon(coupon);

        // Inform
        msender.msg(MConf.get().addedCoupon, value, code, mplayer.getName());
    }

}
