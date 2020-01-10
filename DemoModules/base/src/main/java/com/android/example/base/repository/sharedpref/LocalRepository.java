package com.android.example.base.repository.sharedpref;

/**
 * Created by shajeer on 15/11/17.
 */

public interface LocalRepository {

    void save(String key, String value);

    String getString(String key);

    void clearAll();
}
