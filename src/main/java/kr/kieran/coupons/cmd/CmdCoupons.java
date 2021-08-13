package kr.kieran.coupons.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.util.MUtil;
import kr.kieran.coupons.entity.MConf;

import java.util.List;

public class CmdCoupons extends CouponsCommand
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    private static CmdCoupons i = new CmdCoupons();
    public static CmdCoupons get() { return i; }

    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    public CmdCouponsAdd cmdCouponsAdd = new CmdCouponsAdd();
    public CmdCouponsClear cmdCouponsClear = new CmdCouponsClear();
    public CmdCouponsList cmdCouponsList = new CmdCouponsList();

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        this.cmdCouponsList.execute(sender, MUtil.list());
    }

    @Override
    public List<String> getAliases()
    {
        return MConf.get().cmdAliases;
    }

}
