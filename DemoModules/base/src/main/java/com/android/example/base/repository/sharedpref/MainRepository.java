package com.android.example.base.repository.sharedpref;


import androidx.annotation.NonNull;

import javax.inject.Inject;

/**
 * Created by shajeer on 16/11/17.
 */

public class MainRepository implements BaseRepository {
    private final LocalRepository mLocalRepository;

    @Inject
    public MainRepository(@NonNull LocalRepository localRepository) {
        mLocalRepository = localRepository;
    }
}
