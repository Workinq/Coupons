package kr.kieran.coupons.cmd.type;

import com.massivecraft.massivecore.command.type.Type;
import kr.kieran.coupons.entity.MPlayer;
import kr.kieran.coupons.entity.MPlayerColl;

public class TypeMPlayer
{
    // -------------------------------------------- //
    // INSTANCE
    // -------------------------------------------- //

    public static Type<MPlayer> get()
    {
        return MPlayerColl.get().getTypeEntity();
    }

}
