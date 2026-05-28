package com.example.relicsmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.actions.common.LoseHPAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class HourglassOfTime extends CustomRelic {

    public static final String ID = "HourglassOfTime";
    private static final int HP_LOSS = 1;

    private static final Texture IMG = RelicTextureHelper.createRelicTexture(
            new Color(0.9f, 0.7f, 0.2f, 1.0f), Color.GOLD);
    private static final Texture OUTLINE = RelicTextureHelper.createOutlineTexture(
            new Color(0.7f, 0.5f, 0.1f, 1.0f));

    public HourglassOfTime() {
        super(ID, IMG, OUTLINE, RelicTier.BOSS, LandingSound.MAGICAL);
        this.counter = 0;
    }

    @Override
    public String getUpdatedDescription() {
        return "At the start of each turn, gain [E]. NL At the end of your turn, lose #b" + HP_LOSS + " HP.";
    }

    @Override
    public void atTurnStart() {
        flash();
        addToBot(new GainEnergyAction(1));
    }

    @Override
    public void onPlayerEndTurn() {
        flash();
        addToBot(new LoseHPAction(AbstractDungeon.player, AbstractDungeon.player, HP_LOSS));
    }

    @Override
    public AbstractRelic makeCopy() {
        return new HourglassOfTime();
    }
}
