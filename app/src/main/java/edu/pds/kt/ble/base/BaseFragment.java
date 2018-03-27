/*
 * Copyright (c) 2017. xiaoyunfei
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package edu.pds.kt.ble.base;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Administrator
 */
public abstract class BaseFragment extends Fragment {
    protected View rootView;
    protected Unbinder mUnkinder;
    protected Context mContext;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mContext = getActivity();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initComponent(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        int layoutId = getLayoutId();
        if (layoutId > 0){
            rootView = inflater.inflate(layoutId, container, false);
        }else {
            mUnkinder = Unbinder.EMPTY;
        }
        mUnkinder = ButterKnife.bind(this,rootView);
        initViews(rootView);
        return rootView;
    }


    protected abstract int getLayoutId();
    protected void initComponent(Bundle savedInstanceState){}

    protected void initViews(View root){}

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnkinder.unbind();
    }
}
