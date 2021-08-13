package kr.kieran.coupons;

import com.massivecraft.massivecore.MassivePlugin;
import com.massivecraft.massivecore.collections.MassiveList;
import kr.kieran.coupons.entity.MConfColl;
import kr.kieran.coupons.entity.MPlayerColl;

import java.util.List;

public class CouponsPlugin extends MassivePlugin
{
    // -------------------------------------------- //
    // INSTANCE & CONSTRUCT
    // -------------------------------------------- //

    private static CouponsPlugin i;
    public CouponsPlugin() { CouponsPlugin.i = this; }
    public static CouponsPlugin get() { return i; }

    // -------------------------------------------- //
    // OVERRIDE
    // -------------------------------------------- //

    @Override
    public void onEnableInner()
    {
        this.activateAuto();
    }

    @Override
    public List<Class<?>> getClassesActiveColls()
    {
        return new MassiveList<>(
                MConfColl.class,
                MPlayerColl.class
        );
    }

}
