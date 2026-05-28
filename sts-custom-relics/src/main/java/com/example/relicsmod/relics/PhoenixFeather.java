package com.example.relicsmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class PhoenixFeather extends CustomRelic {

    public static final String ID = "PhoenixFeather";
    private static final float HP_THRESHOLD = 0.5f;
    private static final float HEAL_PCT = 0.25f;

    private static final Texture IMG = RelicTextureHelper.createRelicTexture(
            new Color(0.9f, 0.4f, 0.1f, 1.0f), Color.ORANGE);
    private static final Texture OUTLINE = RelicTextureHelper.createOutlineTexture(
            new Color(0.6f, 0.25f, 0.05f, 1.0f));

    public PhoenixFeather() {
        super(ID, IMG, OUTLINE, RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return "At the start of each combat, if your HP is below #b50%, heal #b25% of your Max HP.";
    }

    @Override
    public void atBattleStart() {
        int currentHp = AbstractDungeon.player.currentHealth;
        int maxHp = AbstractDungeon.player.maxHealth;
        if (currentHp > 0 && currentHp < maxHp * HP_THRESHOLD) {
            flash();
            int healAmt = (int) (maxHp * HEAL_PCT);
            AbstractDungeon.player.heal(healAmt, true);
        }
    }

    @Override
    public AbstractRelic makeCopy() {
        return new PhoenixFeather();
    }
}
