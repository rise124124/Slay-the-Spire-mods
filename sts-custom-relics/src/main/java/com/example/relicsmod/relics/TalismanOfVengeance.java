package com.example.relicsmod.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class TalismanOfVengeance extends CustomRelic {

    public static final String ID = "TalismanOfVengeance";
    private static final int BLOCK = 3;

    private static final Texture IMG = RelicTextureHelper.createRelicTexture(
            new Color(0.8f, 0.2f, 0.1f, 1.0f), Color.RED);
    private static final Texture OUTLINE = RelicTextureHelper.createOutlineTexture(
            new Color(0.5f, 0.1f, 0.05f, 1.0f));

    public TalismanOfVengeance() {
        super(ID, IMG, OUTLINE, RelicTier.RARE, LandingSound.CLINK);
    }

    @Override
    public String getUpdatedDescription() {
        return "Whenever you lose HP from an enemy's attack, gain #b" + BLOCK + " Block.";
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null
                && info.type != DamageInfo.DamageType.THORNS
                && info.type != DamageInfo.DamageType.HP_LOSS) {
            flash();
            addToBot(new GainBlockAction(AbstractDungeon.player, AbstractDungeon.player, BLOCK));
        }
        return damageAmount;
    }

    @Override
    public AbstractRelic makeCopy() {
        return new TalismanOfVengeance();
    }
}
