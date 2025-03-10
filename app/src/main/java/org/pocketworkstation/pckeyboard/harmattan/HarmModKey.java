package org.pocketworkstation.pckeyboard.harmattan;

import android.util.Log;

//k harmattan
public final class HarmModKey
{
    public static final int MOD_KEY_STATE_RELEASED = 0;
    public static final int MOD_KEY_STATE_PRESSED = 1;
    public static final int MOD_KEY_STATE_LOCKED = 2;

    public int state = MOD_KEY_STATE_RELEASED;

    public boolean Pressed()
    {
        return state == MOD_KEY_STATE_PRESSED;
    }

    public boolean Released()
    {
        return state == MOD_KEY_STATE_RELEASED;
    }

    public boolean Locked()
    {
        return state == MOD_KEY_STATE_LOCKED;
    }

    public boolean Downed()
    {
        return state != MOD_KEY_STATE_RELEASED;
    }

    public void Press()
    {
        state = MOD_KEY_STATE_PRESSED;
    }

    public void Release()
    {
        state = MOD_KEY_STATE_RELEASED;
    }

    public void Touch()
    {
        state = Next();
    }

    public int Next()
    {
        int ret = (++state) % 3;
        // Log.e("modkey", "" + ret);
        return ret;
    }

    public void SetState(boolean s)
    {
        state = s ? MOD_KEY_STATE_PRESSED : MOD_KEY_STATE_RELEASED;
    }

    public void SetState(int s)
    {
        if(s < MOD_KEY_STATE_RELEASED || s > MOD_KEY_STATE_LOCKED) return;
        state = s;
    }

    public static boolean IsPressed(int state)
    {
        return state == MOD_KEY_STATE_PRESSED;
    }

    public static boolean IsReleased(int state)
    {
        return state == MOD_KEY_STATE_RELEASED;
    }

    public static boolean IsLocked(int state)
    {
        return state == MOD_KEY_STATE_LOCKED;
    }
}
