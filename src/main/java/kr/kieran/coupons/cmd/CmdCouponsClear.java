package kr.kieran.coupons.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.type.container.TypeList;
import kr.kieran.coupons.cmd.type.TypeMPlayer;
import kr.kieran.coupons.entity.MConf;
import kr.kieran.coupons.entity.MPlayer;
import kr.kieran.coupons.entity.MPlayerColl;

import java.util.Collection;

public class CmdCouponsClear extends CouponsCommand
{
    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CmdCouponsClear()
    {
        // Parameters
        this.addParameter(TypeList.get(TypeMPlayer.get()), "players", "all", true);
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void perform() throws MassiveException
    {
        // Args
        Collection<MPlayer> mplayers = this.readArg(MPlayerColl.get().getAll());

        // Clear coupons for all players
        for (MPlayer mplayer : mplayers) mplayer.clearCoupons();

        // Inform
        msender.msg(MConf.get().clearedCoupons, mplayers.size());
    }

}
