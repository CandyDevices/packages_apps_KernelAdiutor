/*
 * Copyright (C) 2015 Willi Ye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grarak.kerneladiutor.fragments.kernel;

import android.os.Bundle;

import com.grarak.kerneladiutor.R;
import com.grarak.kerneladiutor.elements.cards.PopupCardView;
import com.grarak.kerneladiutor.elements.cards.SeekBarCardView;
import com.grarak.kerneladiutor.elements.cards.SwitchCardView;
import com.grarak.kerneladiutor.fragments.RecyclerViewFragment;
import com.grarak.kerneladiutor.utils.kernel.Wake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willi on 02.01.15.
 */
public class WakeFragment extends RecyclerViewFragment implements PopupCardView.DPopupCard.OnDPopupCardListener,
        SwitchCardView.DSwitchCard.OnDSwitchCardListener {

    private PopupCardView.DPopupCard mDt2wCard;
    private PopupCardView.DPopupCard mDt2sCard;
    private SwitchCardView.DSwitchCard mS2wCard;
    private SwitchCardView.DSwitchCard mS2sCard;
    private SwitchCardView.DSwitchCard mLenientCard;

    @Override
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);

        if (Wake.hasDt2w()) dt2wInit();
        if (Wake.hasDt2s()) dt2sInit();
        if (Wake.hasS2w()) s2wInit();
        if (Wake.hasS2s()) s2sInit();
        if (Wake.hasLenient()) lenientInit();
    }

    private void dt2wInit() {
        mDt2wCard = new PopupCardView.DPopupCard(Wake.getDt2wMenu(getActivity()));
        mDt2wCard.setTitle(getString(R.string.dt2w));
        mDt2wCard.setDescription(getString(R.string.dt2w_summary));
        mDt2wCard.setItem(Wake.getDt2wValue());
        mDt2wCard.setOnDPopupCardListener(this);

        addView(mDt2wCard);
    }

    private void dt2sInit() {
        mDt2sCard = new PopupCardView.DPopupCard(Wake.getDt2sMenu(getActivity()));
        mDt2sCard.setTitle(getString(R.string.dt2s));
        mDt2sCard.setDescription(getString(R.string.dt2s_summary));
        mDt2sCard.setItem(Wake.getDt2sValue());
        mDt2sCard.setOnDPopupCardListener(this);

        addView(mDt2sCard);
    }

    private void s2wInit() {
        mS2wCard = new SwitchCardView.DSwitchCard();
        mS2wCard.setTitle(getString(R.string.s2w));
        mS2wCard.setDescription(getString(R.string.s2w_summary));
        mS2wCard.setChecked(Wake.isS2wActive());
        mS2wCard.setOnDSwitchCardListener(this);

        addView(mS2wCard);
    }

    private void s2sInit() {
        mS2sCard = new SwitchCardView.DSwitchCard();
        mS2sCard.setTitle(getString(R.string.s2s));
        mS2sCard.setDescription(getString(R.string.s2s_summary));
        mS2sCard.setChecked(Wake.isS2sActive());
        mS2sCard.setOnDSwitchCardListener(this);

        addView(mS2sCard);
    }

    private void lenientInit() {
        mLenientCard = new SwitchCardView.DSwitchCard();
        mLenientCard.setTitle(getString(R.string.lenient));
        mLenientCard.setDescription(getString(R.string.lenient_summary));
        mLenientCard.setChecked(Wake.isLenientActive());
        mLenientCard.setOnDSwitchCardListener(this);

        addView(mLenientCard);
    }

    @Override
    public void onItemSelected(PopupCardView.DPopupCard dPopupCard, int position) {
        if (dPopupCard == mDt2wCard) Wake.setDt2w(position, getActivity());
        else if (dPopupCard == mDt2sCard) Wake.setDt2s(position, getActivity());
    }


    @Override
    public void onChecked(SwitchCardView.DSwitchCard dSwitchCard, boolean checked) {
        if (dSwitchCard == mS2wCard)
            Wake.activateS2w(checked, getActivity());
        else if (dSwitchCard == mS2sCard)
            Wake.activateS2s(checked, getActivity());
        else if (dSwitchCard == mLenientCard)
            Wake.activateLenient(checked, getActivity());
        }
}
