package kr.kieran.coupons.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;
import kr.kieran.coupons.entity.MPlayer;

public class CouponsCommand extends MassiveCommand
{
    // -------------------------------------------- //
    // FIELDS
    // -------------------------------------------- //

    public MPlayer msender;

    // -------------------------------------------- //
    // CONSTRUCT
    // -------------------------------------------- //

    public CouponsCommand()
    {
        this.setSetupEnabled(true);
    }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void senderFields(boolean set)
    {
        this.msender = set ? MPlayer.get(sender) : null;
    }

}
