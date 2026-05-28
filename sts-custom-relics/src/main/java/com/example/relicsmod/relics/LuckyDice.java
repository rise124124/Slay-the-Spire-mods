package com.example.relicsmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.RegenPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.Random;

public class LuckyDice extends CustomRelic {

    public static final String ID = "LuckyDice";
    private static final int STR_AMT = 1;
    private static final int DEX_AMT = 1;
    private static final int REGEN_AMT = 2;

    private static final Texture IMG = RelicTextureHelper.createRelicTexture(
            new Color(0.2f, 0.8f, 0.3f, 1.0f), Color.GREEN);
    private static final Texture OUTLINE = RelicTextureHelper.createOutlineTexture(
            new Color(0.1f, 0.5f, 0.15f, 1.0f));

    public LuckyDice() {
        super(ID, IMG, OUTLINE, RelicTier.UNCOMMON, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return "At the start of each combat, randomly gain #b" + STR_AMT + " Strength, #b" + DEX_AMT +
                " Dexterity, or #b" + REGEN_AMT + " Regenerate.";
    }

    @Override
    public void atBattleStart() {
        flash();
        int roll = new Random().nextInt(3);
        switch (roll) {
            case 0:
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player,
                        new StrengthPower(AbstractDungeon.player, STR_AMT), STR_AMT));
                break;
            case 1:
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player,
                        new DexterityPower(AbstractDungeon.player, DEX_AMT), DEX_AMT));
                break;
            case 2:
                addToBot(new ApplyPowerAction(AbstractDungeon.player, AbstractDungeon.player,
                        new RegenPower(AbstractDungeon.player, REGEN_AMT), REGEN_AMT));
                break;
        }
    }

    @Override
    public AbstractRelic makeCopy() {
        return new LuckyDice();
    }
}
