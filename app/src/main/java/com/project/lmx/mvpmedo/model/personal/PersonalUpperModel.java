package com.project.lmx.mvpmedo.model.personal;

import android.support.annotation.NonNull;

import com.project.lmx.mvpmedo.contract.personal.PersonalContract;

/**
 * Created by Administrator on 2017/9/26.
 * <p>
 */

public class PersonalUpperModel implements PersonalContract.IPersonalUpperModel {

    @NonNull
    public static PersonalUpperModel newInstance() {
        return new PersonalUpperModel();
    }
}
