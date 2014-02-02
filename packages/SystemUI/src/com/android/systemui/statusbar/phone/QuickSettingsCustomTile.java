/*
 * Copyright (C) 2013 The Android Open Source Project
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

package com.android.systemui.statusbar.phone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.systemui.R;

import meltedbutter.quicksettings.ITile;
import meltedbutter.quicksettings.ITileControls;

class QuickSettingsCustomTile extends QuickSettingsTileView {
    private final ITile mTile;

    QuickSettingsCustomTile(Context context, AttributeSet attrs, ITileControls controls, ITile tile) {
        super(context, attrs);

        setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                context.getResources().getDimensionPixelSize(R.dimen.quick_settings_cell_height)));
        setBackgroundResource(R.drawable.qs_tile_background);
        addView(LayoutInflater.from(context).inflate(R.layout.quick_settings_tile_basic, null),
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));

        tile.construct(context, controls, this,
                (ImageView) findViewById(R.id.image), (TextView) findViewById(R.id.text));
        mTile = tile;
    }

    @Override
    void setContent(int layoutId, LayoutInflater inflater) {
        throw new RuntimeException("why?");
    }
}
