
package com.smartisanos.notes.module;

public interface NotesStateChangeListener {
    void onStateEnter();

    void onStateExit();

    void onStatePause();

    void onStateResume();

    void onStateDestory();

}
